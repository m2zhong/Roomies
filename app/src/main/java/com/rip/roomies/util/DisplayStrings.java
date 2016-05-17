package com.rip.roomies.util;

/**
 * A class containing a list of static strings meant to be displayed to the user.
 */
public class DisplayStrings {
	public static final long TOAST_SHORT_LENGTH = 2000;
	public static final long TOAST_LONG_LENGTH = 3500;

	public static final String MISSING_FIELD = "Required field missing: %s\n";
	public static final String FIELD_MISMATCH = "Fields %s and %s do not match.\n";

	public static final String CREATE_GROUP_FAIL = "Could not create a new group.\n" +
			"Check the logs for error.";
	public static final String CREATE_GROUP_SUCCESS = "Group \"%s\" successfully created.\n" +
			"Transferring to home page...";

	public static final String JOIN_GROUP_FAIL = "Could not join group.\n" +
			"Check the logs for error.";
	public static final String JOIN_GROUP_SUCCESS = "Group \"%s\" successfully joined.\n" +
			"Transferring to home page...";

	public static final String CREATE_USER_FAIL = "Could not create a new user.\n" +
			"Check the logs for error.";
	public static final String CREATE_USER_SUCCESS = "User \"%s\" successfully created.\n" +
			"Transferring to login page...";

	public static final String LOGIN_FAIL = "Login failed. Make sure your credentials are correct.";

	public static final String PASS_RETRIEVE_FAIL = "Could not retrieve password.\n" +
			"Check the logs for error.";
	public static final String PASS_RETRIEVE_SUCCESS = "Password reset successful.\n" +
			"Please check your email for your temporary password.";

	public static final String FIND_USER_FAIL = "Could not find that user.\n" +
			"Make sure the username entered is correct.";
}
