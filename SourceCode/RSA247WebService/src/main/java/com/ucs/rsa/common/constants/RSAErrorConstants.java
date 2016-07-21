package com.ucs.rsa.common.constants;

public class RSAErrorConstants {
	
	public static final String SYSTEM_ERROR_MSG = "SYSTEM_ERROR";
	public static final String SYSTEM_ERROR_KEY = "RSA_001";

	public static final String USERNAME_ALREADY_EXISTS_MSG = "USERNAME_ALREADY_EXISTS";
	public static final String USERNAME_ALREADY_EXISTS_KEY = "RSA_005";
	
	public static final String MANDATORY_PARAMS_MISSING_MSG = "MANDATORY_PARAMS_MISSING";
	public static final String MANDATORY_PARAMS_MISSING_KEY = "RSA_006";

	public static final String INVALID_INPUT_PARAM_MSG = "INVALID_INPUT_PARAM";
	public static final String INVALID_INPUT_PARAM_KEY = "RSA_007";
	
	public static enum ErrorCode {
		
		SYSTEM_ERROR("RSA_001", "SYSTEM_ERROR"),
		
		USERNAME_ALREADY_EXISTS_ERROR("RSA_005", "USERNAME_ALREADY_EXISTS"),
		
		MANDATORY_PARAMS_MISSING_ERROR("RSA_006", "MANDATORY_PARAMS_MISSING"),
		
		INVALID_INPUT_PARAM_ERROR("RSA_007", "INVALID_INPUT_PARAM");

		private String key;
		private String message;
		
		ErrorCode(final String iKey, final String iMessage) {
			this.key = iKey;
			this.message = iMessage;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

	}
}
