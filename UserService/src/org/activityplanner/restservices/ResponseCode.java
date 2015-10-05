package org.activityplanner.restservices;

public class ResponseCode {
	//Major Codes
	public static String SUCCESS = "000";
	public static String VALIDATION_FAILED = "001";
	public static String NETWORK_ERROR = "002";
	
	//Minor Codes
	public static String VALIDATION_ID_CARD_MUST_UNIQUE = "101";
	public static String VALIDATION_USER_ID_MUST_UNIQUE = "102";
	public static String VALIDATION_MAIL_ID_MUST_UNIQUE = "103";
}
