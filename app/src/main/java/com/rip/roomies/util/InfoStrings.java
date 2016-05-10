package com.rip.roomies.util;

/**
 * A class containing a list of strings for logging.
 */
public class InfoStrings {
	public static final String SWITCH_ACTIVITY = "Switching to activity %s";
	public static final String SWITCH_ACTIVITY_DELAYED = "Switching to activity %s after %d ms delay";

	public static final String DATABASE_CONNECT = "Connecting to the database...";
	public static final String DATABASE_QUERY = "Querying database: \"%s\"";

	public static final String CONTAINER_ADD = "Adding view %s to container %s";

	public static final String VIEW_SETUP = "Setting up view %s";

	public static final String LOGIN_SUCCESSFULL = "Login successfull!! \n" +
			"ID: %d\nLastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s";
	public static final String LOGIN_FAILED = "Login FAILED!!";

	public static final String CREATEUSER_SUCCESSFULL = "CreateUser successfull!! \n" +
			"ID: %d\nLastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s";
	public static final String CREATEUSER_FAILED = "CreateUser Failed!!";

	public static final String CREATEGROUP_SUCCESSFULL = "CreateGroup successfull!! \n" +
			"ID: %d\nName: %s\nDescription: %s";
	public static final String CREATEGROUP_FAILED = "CreateGroup Failed!!";

}
