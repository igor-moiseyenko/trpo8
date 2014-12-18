package com.imoiseyenko.spastructure.backend.service.profile.converter;

import org.springframework.stereotype.Component;
import com.imoiseyenko.spastructure.backend.service.profile.vo.TokenInfoVO;
import com.imoiseyenko.spastructure.common.util.TokenInfo;

/**
 * Converter for the {@link TokenInfoVO} value object to the {@link TokenInfo} instance and vice
 * versa.
 * 
 * @author imoiseyenko93@gmail.com
 * @version Apr 27, 2014
 */
@Component
public class TokenInfoVOConverter {

	/**
	 * Convert {@link TokenInfo} instance to the {@link TokenInfoVO} value object.
	 * 
	 * @param tokenInfo
	 * @return
	 * @author imoiseyenko93@gmail.com
	 */
	public TokenInfoVO convertTokenInfoToVO (TokenInfo tokenInfo) {

		TokenInfoVO tokenInfoVO = null;

		if (tokenInfo != null) {

			tokenInfoVO = new TokenInfoVO();
			tokenInfoVO.setUsername(tokenInfo.getUsername());
			tokenInfoVO.setExpirationTime(tokenInfo.getExpirationTime());
		}

		return tokenInfoVO;
	}
}
