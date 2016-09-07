package com.ucs.rsa.common.constants;

public class RSAErrorConstants {

	public static final String SYSTEM_ERROR_MSG = "SYSTEM_ERROR";
	public static final String SYSTEM_ERROR_KEY = "RSA_001";

	public static final String USER_NOT_FOUND_MSG = "USER_NOT_FOUND";
	public static final String USER_NOT_FOUND_KEY = "RSA_004";
	
	public static final String USER_ALREADY_EXISTS_MSG = "USER_ALREADY_EXISTS";
	public static final String USER_ALREADY_EXISTS_KEY = "RSA_005";
	
	public static final String MANDATORY_PARAMS_MISSING_MSG = "MANDATORY_PARAMS_MISSING";
	public static final String MANDATORY_PARAMS_MISSING_KEY = "RSA_006";

	public static final String INVALID_INPUT_PARAM_MSG = "INVALID_INPUT_PARAM";
	public static final String INVALID_INPUT_PARAM_KEY = "RSA_007";

	public static final String INVALID_VEHICLE_INFORMATION_MODEL_MSG = "INVALID_VEHICLE_INFORMATION_MODEL";
	public static final String INVALID_VEHICLE_INFORMATION_MODEL_KEY = "RSA_008";

	public static final String INVALID_VEHICLE_MODEL_MSG = "INVALID_VEHICLE_INFORMATION_MODEL";
	public static final String INVALID_VEHICLE_MODEL_KEY = "RSA_009";

	public static final String INVALID_VEHICLE_TYPE_MODEL_MSG = "INVALID_VEHICLE_INFORMATION_MODEL";
	public static final String INVALID_VEHICLE_TYPE_MODEL_KEY = "RSA_010";

	public static final String INVALID_VEHICLE_FUEL_TYPE_MODEL_MSG = "INVALID_VEHICLE_FUEL_TYPE_MODEL";
	public static final String INVALID_VEHICLE_FUEL_TYPE_MODEL_KEY = "RSA_011";

	public static final String INVALID_VEHICLE_MANUFACTURER_MODEL_MSG = "INVALID_VEHICLE_MANUFACTURER_MODEL";
	public static final String INVALID_VEHICLE_MANUFACTURER_MODEL_KEY = "RSA_012";

	public static final String INVALID_USER_MODEL_MSG = "INVALID_USER_MODEL";
	public static final String INVALID_USER_MODEL_KEY = "RSA_013";
	/** The Constant TRANSACTION_FAILED_MSG. */
	public static final String TRANSACTION_FAILED_MSG = "SIGNATURE_VERFICATION_FAILED";

	/** The Constant TRANSACTION_FAILED_KEY. */
	public static final String TRANSACTION_FAILED_KEY = "RSA_015";

	public static enum ErrorCode {

		SYSTEM_ERROR("RSA_001", "SYSTEM_ERROR"),

		USER_NOT_FOUND_ERROR("RSA_004", "USER_NOT_FOUND"),
		
		USER_ALREADY_EXISTS_ERROR("RSA_005", "USER_ALREADY_EXISTS"),
		
		MANDATORY_PARAMS_MISSING_ERROR("RSA_006", "MANDATORY_PARAMS_MISSING"),

		INVALID_INPUT_PARAM_ERROR("RSA_007", "INVALID_INPUT_PARAM"),

		INVALID_VEHICLE_INFORMATION_MODEL_ID_ERROR("RSA_008", "INVALID_VEHICLE_INFORMATION_MODEL"),

		INVALID_VEHICLE_MODEL_ID_ERROR("RSA_009", "INVALID_VEHICLE_MODEL"),

		INVALID_VEHICLE_TYPE_MODEL_ID_ERROR("RSA_010", "INVALID_VEHICLE_TYPE_MODEL"),

		INVALID_VEHICLE_FUEL_TYPE_MODEL_ID_ERROR("RSA_011", "INVALID_VEHICLE_FUEL_TYPE_MODEL"),

		INVALID_VEHICLE_MANUFACTURER_MODEL_ID_ERROR("RSA_012", "INVALID_VEHICLE_MANUFACTURER_MODEL"),

		INVALID_USER_MODEL_ID_ERROR("RSA_013",
				"INVALID_USER_MODEL"), 
		/** The vehicle information already exists for this user error. */
		VEHICLE_INFORMATION_ALREADY_EXISTS_FOR_THIS_USER_ERROR("RSA_014", "VEHICLE_INFORMATION_ALREADY_EXISTS_FOR_THIS_USER"),

		TRANSACTION_FAILED_ERROR("RSA_015", "SIGNATURE_VERFICATION_FAILED"),
		
		INVALID_SERVICE_PROVIDER_ID("RSA_016", "INVALID_SERVICE_PROVIDER_ID"),
		
		INVALID_EMAIL("RSA_017", "INVALID_EMAIL"),
		
		SERVICE_PROVIDER_ALREADY_EXISTS_ERROR("RSA_017", "SERVICE_PROVIDER_ALREADY_EXISTS_ERROR");
		
		

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
