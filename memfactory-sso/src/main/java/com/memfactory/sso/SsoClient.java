package com.memfactory.sso;

import com.ineunet.knife.config.AppConfig;
import com.memfactory.sso.config.BaseSsoConfig;

/**
 * @author zhairp
 *createDate: 2018-09-03
 */
//@Configuration
public class SsoClient extends BaseSsoConfig {
	public static final String VERIFY_TOKEN_RUL = "sso.verifyToken.url";

	@Override
	public String getVerifyTokenUrl() {
		return AppConfig.getString(VERIFY_TOKEN_RUL);
	}

}
