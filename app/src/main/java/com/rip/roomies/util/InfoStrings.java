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
	public static final String LOGIN_MODEL = "Logging in based off the current object.";
	public static final String LOGIN_SQL = "Logging in...";

	public static final String CREATEUSER_SUCCESSFULL = "CreateUser successfull!! \n" +
			"ID: %d\nLastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s";
	public static final String CREATEUSER_FAILED = "CreateUser Failed!!";
	public static final String CREATEUSER_MODEL = "Creating a new user based off the current object.";
	public static final String CREATEUSER_SQL = "Creating user...";

	public static final String CREATEGROUP_SUCCESSFULL = "CreateGroup successfull!! \n" +
			"ID: %d\nName: %s\nDescription: %s";
	public static final String CREATEGROUP_FAILED = "CreateGroup Failed!!";
	public static final String CREATEGROUP_MODEL = "Creating a new group based off the current object.";
	public static final String CREATEGROUP_SQL = "Creating group...";

	public static final String LOGOFF = "Logging off.";

	public static final String PASSRETRIEVE_MODEL = "Retrieving a new password via email based off the current object.";

	public static final String ADD_USERS_TO_GROUP_SUCCESSFULL = "AddUsersToGroup successfull!! \n" +
			"ID: %d\nName: %s\nDescription: %s";
	public static final String ADD_USERS_TO_GROUP_FAILED = "AddUsersToGroup Failed!!";
	public static final String ADD_USERS_TO_GROUP_MODEL = "Adding users to an existing group based off the current objects.";
	public static final String ADD_USERS_TO_GROUP_SQL = "Adding users to group...";
}
