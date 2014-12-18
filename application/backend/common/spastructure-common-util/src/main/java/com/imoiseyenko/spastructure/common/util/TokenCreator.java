package com.imoiseyenko.spastructure.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Token creator & parser.
 *
 * @author igor.moiseyenko@nasty-creatures.com 
 * @version 0.1 Apr 20, 2014
 */
public class TokenCreator {

	/** Expiration time date pattern. */
	private static final String DATE_PATTERN = "yyyyMMddHHmm";

	/** Expiration time date formatter. */
	private static final SimpleDateFormat SDF = new SimpleDateFormat(DATE_PATTERN);

	/**
	 * Create token.
	 *
	 * @param username
	 * @param expirationTimeDelta
	 * @param permissions
	 * @return
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	public static String createToken(String username, long expirationTimeDelta, Permissions permissions) {

		String expirationTime = SDF.format(System.currentTimeMillis() + expirationTimeDelta);
		String data = username + expirationTime + permissions;

		return ByteCoder.encode(data);
	}

	/**
	 * Parse token.
	 *
	 * @param token
	 * @return Token info as instance of {@link TokenInfo}.
	 * @throws ParseException
	 * @author igor.moiseyenko@nasty-creatures.com
	 */
	public static TokenInfo parseToken(String token) throws ParseException {

		String data = ByteCoder.decode(token);

		Permissions permissions = Permissions.valueOf(data.substring(data.length() - 1));
		Date expirationTime = SDF.parse(data.substring(data.length() - DATE_PATTERN.length() - 1, data.length() - 1));
		String username = data.substring(0, data.length() - DATE_PATTERN.length() - 1);

		TokenInfo tokenInfo = new TokenInfo();
		tokenInfo.setUsername(username);
		tokenInfo.setExpirationTime(expirationTime);
		tokenInfo.setPermissions(permissions);

		return tokenInfo;
	}
}
