package com.imoiseyenko.spastructure.common.util;

/**
 * Coder to encode/decode file paths.
 *
 * @author igor.moiseyenko@nasty-creatures.com 
 * @version 0.1 Apr 20, 2014
 */
public class ByteCoder {

	/** Valid characters in the file path. Arranged in order of the ASCII code. 64 elements to fit in 64 bits. */
	private static final char[] SYMBOLS = { 'x', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
			'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '_', 'a', 'b',
			'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', '-', 'y',
			'z' };

	/** Symbol codes. Index of code equals to ASCII code of valid character. */
	private static final byte[] SYMBOL_CODES = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
			0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 61, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0, 0, 0, 0, 0, 0, 0,
			11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 0, 0, 0, 0,
			37, 0, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 0, 62, 63 };

	/** Number of bits in byte. */
	private static final int BYTE_SIZE = 8;

	/** Number of bits to group. */
	private static final int NUM_OF_MEANING_BITS = 6;

	/** Magic. */
	private static final int MAGIC_NUMBER = 3;

	/** Mask to enable last 6 bits.  */
	private static final int LAST_SIX_BITS_ENABLE = 0x0000003f;

	/** Mask to enable last 8 bits. */
	private static final int LAST_BYTE_ENABLE = 0x000000ff;

	/** Mask to enable second last 8 bits. */
	private static final int SECOND_LAST_BYTE_ENABLE = 0x0000ff00;

	/** Date is used as a salt. */
	private static final int DATE_SYMBOLS_LEN = 5;

	/**
	 * Encode.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	public static String encode(String input) {

		input = addCurrentDateSymbols(input);
		StringBuilder result = new StringBuilder();
		byte[] splittedBytes = splitBytes(splitCharsToBytes(input));
		for (byte b : splittedBytes) {
			result.append(SYMBOLS[b]);
		}

		return result.toString();
	}

	/**
	 * Decode.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	public static String decode(String input) {

		byte[] inputBytes = new byte[input.length()];
		for (int i = 0; i < input.length(); i++) {
			inputBytes[i] = SYMBOL_CODES[input.charAt(i)];
		}
		char[] unitedChars = unitBytesToChars(unitBytes(inputBytes));

		return removeCurrentDateSymbols(new String(unitedChars));
		//return new String(unitedChars);
	}

	/**
	 * Add date symbols as a salt to the end of data.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	private static String addCurrentDateSymbols(String input) {

		String dateValue = "" + System.currentTimeMillis();

		return input + dateValue.substring(dateValue.length() - DATE_SYMBOLS_LEN);
	}

	/**
	 * Remove date symbols from the end of data.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	private static String removeCurrentDateSymbols(String input) {

		return input.substring(0, input.length() - DATE_SYMBOLS_LEN);
	}

	/**
	 * Split each char of input string on 2 bytes to support UNICODE symbols.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	private static byte[] splitCharsToBytes(String input) {

		byte[] output = new byte[input.length() * 2];

		for (int i = 0; i < input.length(); i++) {

			char ch = input.charAt(i);
			output[i * 2] = (byte) ((ch & SECOND_LAST_BYTE_ENABLE) >>> BYTE_SIZE);
			output[i * 2 + 1] = (byte) (ch & LAST_BYTE_ENABLE);
		}

		return output;
	}

	/**
	 * Unit each 2 bytes of input byte array to 1 char to support UNICODE symbols.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	private static char[] unitBytesToChars(byte[] input) {

		char[] output = new char[input.length / 2];

		for (int i = 0; i < output.length; i++) {

			byte hiByte = input[i * 2];
			byte loByte = input[i * 2 + 1];
			output[i] = (char) (((hiByte & LAST_BYTE_ENABLE) << BYTE_SIZE) | (loByte & LAST_BYTE_ENABLE));
		}

		return output;
	}

	/**
	 * Split bytes by 6 bits.
	 * 3 bytes by 8 meaning bits -> 4 bytes by 6 meaning bits.
	 * Int value used as a buffer.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	private static byte[] splitBytes(byte[] input) {

		int outputLen = (int) Math.ceil((double) input.length * BYTE_SIZE / NUM_OF_MEANING_BITS);
		byte[] output = new byte[outputLen];
		int outputIndex = 0;

		for (int i = 0; i < input.length; i += MAGIC_NUMBER) {

			int bytesHolder = 0;
			int j = i;
			for (; j < input.length && j < i + MAGIC_NUMBER; j++) {

				bytesHolder <<= BYTE_SIZE;
				bytesHolder |= input[j] & LAST_BYTE_ENABLE;
			}

			int numOfShifts = (int) Math.ceil((double) ((j - i) * BYTE_SIZE) / NUM_OF_MEANING_BITS);
			for (int numOfShift = numOfShifts; numOfShift > 0; numOfShift--) {

				output[outputIndex++] = (byte) ((bytesHolder >>> ((numOfShift - 1) * NUM_OF_MEANING_BITS)) & LAST_SIX_BITS_ENABLE);
			}
		}

		return output;
	}

	/**
	 * Unit bytes with last 6 meaning bits.
	 * 4 bytes by 6 meaning bits -> 3 bytes by 8 meaning bits.
	 * Int value used as a buffer.
	 *
	 * @param input
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	private static byte[] unitBytes(byte[] input) {

		int outputLen = input.length * NUM_OF_MEANING_BITS / BYTE_SIZE;
		byte[] output = new byte[outputLen];
		int outputIndex = 0;

		for (int i = 0; i < input.length; i += MAGIC_NUMBER + 1) {

			int bytesHolder = 0;
			int j = i;
			for (; j < input.length && j < i + MAGIC_NUMBER + 1; j++) {
				bytesHolder <<= NUM_OF_MEANING_BITS;
				bytesHolder |= input[j] & LAST_BYTE_ENABLE;
			}

			int numOfShifts = (j - i) * NUM_OF_MEANING_BITS / BYTE_SIZE;
			for (int numOfShift = numOfShifts; numOfShift > 0; numOfShift--) {
				output[outputIndex + numOfShift - 1] = (byte) (bytesHolder & LAST_BYTE_ENABLE);
				bytesHolder = (bytesHolder >>> BYTE_SIZE);
			}
			outputIndex += numOfShifts;
		}

		return output;
	}
}
