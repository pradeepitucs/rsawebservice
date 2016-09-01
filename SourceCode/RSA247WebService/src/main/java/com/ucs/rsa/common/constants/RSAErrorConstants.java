/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.constants;

/**
 * The Class RSAErrorConstants.
 *
 * @author Gururaj A M
 * @version 1.0
 * 
 */
public class RSAErrorConstants
{

	/** The Constant SYSTEM_ERROR_MSG. */
	public static final String SYSTEM_ERROR_MSG = "SYSTEM_ERROR";

	/** The Constant SYSTEM_ERROR_KEY. */
	public static final String SYSTEM_ERROR_KEY = "RSA_001";

	/** The Constant USER_NOT_FOUND_MSG. */
	public static final String USER_NOT_FOUND_MSG = "USER_NOT_FOUND";

	/** The Constant USER_NOT_FOUND_KEY. */
	public static final String USER_NOT_FOUND_KEY = "RSA_004";

	/** The Constant USER_ALREADY_EXISTS_MSG. */
	public static final String USER_ALREADY_EXISTS_MSG = "USER_ALREADY_EXISTS";

	/** The Constant USER_ALREADY_EXISTS_KEY. */
	public static final String USER_ALREADY_EXISTS_KEY = "RSA_005";

	/** The Constant MANDATORY_PARAMS_MISSING_MSG. */
	public static final String MANDATORY_PARAMS_MISSING_MSG = "MANDATORY_PARAMS_MISSING";

	/** The Constant MANDATORY_PARAMS_MISSING_KEY. */
	public static final String MANDATORY_PARAMS_MISSING_KEY = "RSA_006";

	/** The Constant INVALID_INPUT_PARAM_MSG. */
	public static final String INVALID_INPUT_PARAM_MSG = "INVALID_INPUT_PARAM";

	/** The Constant INVALID_INPUT_PARAM_KEY. */
	public static final String INVALID_INPUT_PARAM_KEY = "RSA_007";

	/** The Constant INVALID_VEHICLE_INFORMATION_MODEL_MSG. */
	public static final String INVALID_VEHICLE_INFORMATION_MODEL_MSG = "INVALID_VEHICLE_INFORMATION_MODEL";

	/** The Constant INVALID_VEHICLE_INFORMATION_MODEL_KEY. */
	public static final String INVALID_VEHICLE_INFORMATION_MODEL_KEY = "RSA_008";

	/** The Constant INVALID_VEHICLE_MODEL_MSG. */
	public static final String INVALID_VEHICLE_MODEL_MSG = "INVALID_VEHICLE_INFORMATION_MODEL";

	/** The Constant INVALID_VEHICLE_MODEL_KEY. */
	public static final String INVALID_VEHICLE_MODEL_KEY = "RSA_009";

	/** The Constant INVALID_VEHICLE_TYPE_MODEL_MSG. */
	public static final String INVALID_VEHICLE_TYPE_MODEL_MSG = "INVALID_VEHICLE_INFORMATION_MODEL";

	/** The Constant INVALID_VEHICLE_TYPE_MODEL_KEY. */
	public static final String INVALID_VEHICLE_TYPE_MODEL_KEY = "RSA_010";

	/** The Constant INVALID_VEHICLE_FUEL_TYPE_MODEL_MSG. */
	public static final String INVALID_VEHICLE_FUEL_TYPE_MODEL_MSG = "INVALID_VEHICLE_FUEL_TYPE_MODEL";

	/** The Constant INVALID_VEHICLE_FUEL_TYPE_MODEL_KEY. */
	public static final String INVALID_VEHICLE_FUEL_TYPE_MODEL_KEY = "RSA_011";

	/** The Constant INVALID_VEHICLE_MANUFACTURER_MODEL_MSG. */
	public static final String INVALID_VEHICLE_MANUFACTURER_MODEL_MSG = "INVALID_VEHICLE_MANUFACTURER_MODEL";

	/** The Constant INVALID_VEHICLE_MANUFACTURER_MODEL_KEY. */
	public static final String INVALID_VEHICLE_MANUFACTURER_MODEL_KEY = "RSA_012";

	/** The Constant INVALID_USER_MODEL_MSG. */
	public static final String INVALID_USER_MODEL_MSG = "INVALID_USER_MODEL";

	/** The Constant INVALID_USER_MODEL_KEY. */
	public static final String INVALID_USER_MODEL_KEY = "RSA_013";

	/** The Constant TRANSACTION_FAILED_MSG. */
	public static final String TRANSACTION_FAILED_MSG = "SIGNATURE_VERFICATION_FAILED";

	/** The Constant TRANSACTION_FAILED_KEY. */
	public static final String TRANSACTION_FAILED_KEY = "RSA_015";


	/**
	 * The Enum ErrorCode.
	 */
	public static enum ErrorCode
	{

		/** The system error. */
		SYSTEM_ERROR("RSA_001", "SYSTEM_ERROR"),

		/** The user not found error. */
		USER_NOT_FOUND_ERROR("RSA_004", "USER_NOT_FOUND"),

		/** The user already exists error. */
		USER_ALREADY_EXISTS_ERROR("RSA_005", "USER_ALREADY_EXISTS"),

		/** The mandatory params missing error. */
		MANDATORY_PARAMS_MISSING_ERROR("RSA_006", "MANDATORY_PARAMS_MISSING"),

		/** The invalid input param error. */
		INVALID_INPUT_PARAM_ERROR("RSA_007", "INVALID_INPUT_PARAM"),

		/** The invalid vehicle information model id error. */
		INVALID_VEHICLE_INFORMATION_MODEL_ID_ERROR("RSA_008", "INVALID_VEHICLE_INFORMATION_MODEL"),

		/** The invalid vehicle model id error. */
		INVALID_VEHICLE_MODEL_ID_ERROR("RSA_009", "INVALID_VEHICLE_MODEL"),

		/** The invalid vehicle type model id error. */
		INVALID_VEHICLE_TYPE_MODEL_ID_ERROR("RSA_010", "INVALID_VEHICLE_TYPE_MODEL"),

		/** The invalid vehicle fuel type model id error. */
		INVALID_VEHICLE_FUEL_TYPE_MODEL_ID_ERROR("RSA_011", "INVALID_VEHICLE_FUEL_TYPE_MODEL"),

		/** The invalid vehicle manufacturer model id error. */
		INVALID_VEHICLE_MANUFACTURER_MODEL_ID_ERROR("RSA_012", "INVALID_VEHICLE_MANUFACTURER_MODEL"),

		/** The invalid user model id error. */
		INVALID_USER_MODEL_ID_ERROR("RSA_013", "INVALID_USER_MODEL"),

		/** The vehicle information already exists for this user error. */
		VEHICLE_INFORMATION_ALREADY_EXISTS_FOR_THIS_USER_ERROR("RSA_014", "VEHICLE_INFORMATION_ALREADY_EXISTS_FOR_THIS_USER"),

		TRANSACTION_FAILED_ERROR("RSA_015", "SIGNATURE_VERFICATION_FAILED");

		/** The key. */
		private String key;

		/** The message. */
		private String message;

		/**
		 * Instantiates a new error code.
		 *
		 * @param iKey
		 *           the i key
		 * @param iMessage
		 *           the i message
		 */
		ErrorCode(final String iKey, final String iMessage)
		{
			this.key = iKey;
			this.message = iMessage;
		}

		/**
		 * Gets the key.
		 *
		 * @return the key
		 */
		public String getKey()
		{
			return key;
		}

		/**
		 * Sets the key.
		 *
		 * @param key
		 *           the new key
		 */
		public void setKey(String key)
		{
			this.key = key;
		}

		/**
		 * Gets the message.
		 *
		 * @return the message
		 */
		public String getMessage()
		{
			return message;
		}

		/**
		 * Sets the message.
		 *
		 * @param message
		 *           the new message
		 */
		public void setMessage(String message)
		{
			this.message = message;
		}

	}
}
