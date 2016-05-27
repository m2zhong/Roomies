package com.rip.roomies.util;

/**
 * A class containing a list of strings for logging.
 */
public class InfoStrings {
	public static final String SWITCH_ACTIVITY = "Switching to activity %s";
	public static final String SWITCH_ACTIVITY_DELAYED = "Switching to activity %s after %d ms delay";

	public static final String DATABASE_CONNECT = "Connecting to the database...";
	public static final String DATABASE_CONNECTED = "Connected to the database!";
	public static final String DATABASE_QUERY = "Querying database: \"%s\"";

	public static final String CONTAINER_ADD = "Adding view %s to container %s";
	public static final String CONTAINER_MODIFY = "Modifying view %s in container %s";
	public static final String CONTAINER_REMOVE = "Removing view %s from container %s";

	public static final String VIEW_SETUP = "Setting up view %s";

	public static final String LOGIN_SUCCESSFULL = "Login successfull!! \n" +
			"ID: %d\nLastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s";
	public static final String LOGIN_FAILED = "Login FAILED!!";
	public static final String LOGIN_MODEL = "Logging in based off the current object.";
	public static final String LOGIN_SQL = "Logging in...";
	public static final String LOGIN_CONTROLLER = "Logging in from user input:\n" +
			"Username: %s\nPassword: XXXXXXXX";
	public static final String LOGIN_EVENT = "Validation passed. Attempting to login.";

	public static final String CREATEUSER_SUCCESSFULL = "CreateUser successfull!! \n" +
			"ID: %d\nLastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s";
	public static final String CREATEUSER_FAILED = "CreateUser Failed!!";
	public static final String CREATEUSER_MODEL = "Creating a new user based off the current object.";
	public static final String CREATEUSER_SQL = "Creating user...";
	public static final String CREATEUSER_CONTROLLER = "Creating user from user given fields:\n" +
			"LastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s\nPassword: XXXXXXXX";
	public static final String CREATEUSER_EVENT = "Validation passed. Attempting to create a new user.";

	public static final String CREATEGROUP_SUCCESSFULL = "CreateGroup successfull!! \n" +
			"ID: %d\nName: %s\nDescription: %s";
	public static final String CREATEGROUP_FAILED = "CreateGroup Failed!!";
	public static final String CREATEGROUP_MODEL = "Creating a new group based off the current object.";
	public static final String CREATEGROUP_SQL = "Creating group...";
	public static final String CREATEGROUP_CONTROLLER = "Creating group from user given fields:\n" +
			"Name: %s\nDescription: %s";
	public static final String CREATEGROUP_EVENT = "Validation passed. Attempting to create a new group.";

	public static final String LOGOFF = "Logging off.";

	public static final String PASSRETRIEVE_MODEL = "Retrieving a new password via email based off the current object.";
	public static final String PASSRETRIEVE_CONTROLLER = "Retrieving password from user input:\n" +
			"Email: %s";
	public static final String PASSRETRIEVE_EVENT = "Validation passed. Attempting to retreieve password.";

	public static final String ADD_USERS_TO_GROUP_SUCCESSFULL = "AddUsersToGroup successfull!! \n" +
			"ID: %d\nName: %s\nDescription: %s";
	public static final String ADD_USERS_TO_GROUP_FAILED = "AddUsersToGroup Failed!!";
	public static final String ADD_USERS_TO_GROUP_MODEL = "Adding users to an existing group based off the current objects.";
	public static final String ADD_USERS_TO_GROUP_SQL = "Adding users to group...";
	public static final String ADD_USERS_TO_GROUP_CONTROLLER = "Adding users to group from user given list:\n" +
			"Group ID: %d\nGroup Name: %s\nUsers: %s";

	public static final String FIND_USER_SUCESSFUL = "FindUser sucessful!! \n" +
			"ID: %d\nLastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s";
	public static final String FIND_USER_FAILED = "FindUser Failed!!";
	public static final String FIND_USER_MODEL = "Finding user based off the current object as a search key.";
	public static final String FIND_USER_SQL = "Finding user...";
	public static final String FIND_USER_CONTROLLER = "Finding user based on a unique parameter from user:" +
			"ID: %d\nUsername: %s\nEmail: %s";
	public static final String FIND_USER_EVENT = "Validation passed. Attempting to find user.";

	public static final String REMOVE_USER_FROM_GROUP_SQL = "Removing user from group...";
	public static final String REMOVE_USER_FROM_GROUP_SUCCESSFUL = "LeaveGroup successfull! \n" +
			"ID: %d\nLastName: %s\nFirstName: %s\nUsername: %s\nEmail: %s";
	public static final String REMOVE_USER_FROM_GROUP_FAILED = "LeaveGroup failed!!";

	public static final String FIND_GROUP_SUCESSFUL = "FindGroup sucessful!! \n" +
			"ID: %d\nName: %s\nDescription: %s";
	public static final String FIND_GROUP_FAILED = "FindGroup Failed!!";
	public static final String FIND_GROUP_SQL = "Finding group...";

	public static final String INVITE_USERS = "Inviting user(s)...";

	public static final String JOINGROUP_EVENT = "Validation passed. Attempting to join group.";
	public static final String JOINGROUP_MODEL = "Joining a group based off the current object.";

	public static final String GET_GROUP_USERS_MODEL = "Getting group members based off of current group.";
	public static final String GET_GROUP_USERS_SQL = "Getting group...";
	public static final String GET_GROUP_USERS_SUCCESSFUL = "GetGroup successful!";
	public static final String GET_GROUP_USERS_FAILED = "GetGroup failed!!";

	public static final String GET_GROUPS_SQL = "Getting groups...";
	public static final String GET_GROUPS_SUCCESSFUL = "GetGroups successful!";
	public static final String GET_GROUPS_FAILED = "GetGroups failed!!";


	public static final String CREATEDUTY_SQL = "Creating duty...";
	public static final String CREATEDUTY_SUCCESSFUL = "CreateDuty successful!! \n" +
			"ID: %d\nName: %s\nDescription: %s\nGroup Id: %d";
	public static final String CREATEDUTY_FAILED = "CreateDuty failed!!";

	public static final String COMPLETEDUTY_SQL = "Completing duty...";
	public static final String COMPLETEDUTY_SUCCESSFUL = "CompleteDuty successful!! \n" +
			"ID: %d\nName: %s\nDescription: %s\nGroup Id: %d";
	public static final String COMPLETEDUTY_FAILED = "CompleteDuty failed!!";

	public static final String REMOVEDUTY_SQL = "Removing duty...";
	public static final String REMOVEDUTY_SUCCESSFUL = "RemoveDuty successful!! \n" +
			"ID: %d\nName: %s\nDescription: %s\nGroup Id: %d";
	public static final String REMOVEDUTY_FAILED = "RemoveDuty failed!!";

	public static final String MODIFYDUTY_SQL = "Modifying duty...";
	public static final String MODIFYDUTY_SUCCESSFUL = "ModifyDuty successful!! \n" +
			"ID: %d\nName: %s\nDescription: %s\nGroup Id: %d";
	public static final String MODIFYDUTY_FAILED = "ModifyDuty failed!!";

	public static final String GET_GROUP_DUTIES_SQL = "Getting group duties...";
	public static final String GET_GROUP_DUTIES_SUCCESSFUL = "GetGroupDuties successful!!";
	public static final String GET_GROUP_DUTIES_FAILED = "GetGroupDuties failed!!";

	public static final String GET_GROUP_DUTY_LOGS_SQL = "Getting group duty logs...";
	public static final String GET_GROUP_DUTY_LOGS_SUCCESSFUL = "GetGroupDutyLogs successful!!";
	public static final String GET_GROUP_DUTY_LOGS_FAILED = "GetGroupDutyLogs failed!!";

	public static final String GET_USER_DUTIES_SQL = "Getting user duties...";
	public static final String GET_USER_DUTIES_SUCCESSFUL = "GetUserDuties successful!!";
	public static final String GET_USER_DUTIES_FAILED = "GetUserDuties failed!!";

	public static final String GET_DUTY_USERS_SQL = "Getting duty users...";
	public static final String GET_DUTY_USERS_SUCCESSFUL = "GetDutyUsers successful!!";
	public static final String GET_DUTY_USERS_FAILED = "GetDutyUsers failed!!";

	public static final String CREATE_DUTY_EVENT = "Validation passed. Attempting to create duty.";
	public static final String CREATE_DUTY_MODEL = "Creating a duty based off the current object.";
	public static final String CREATE_DUTY_CONTROLLER = "Creating duty from user given fields:\n" +
			"Name: '%s'\nDescription: '%s'\nGroupID: '%s'\nUsers: '%d'";

	public static final String MODIFY_DUTY_EVENT = "Validation passed. Attempting to modify duty.";
	public static final String MODIFY_DUTY_MODEL = "Modifying a duty based off the current object.";
	public static final String MODIFY_DUTY_CONTROLLER = "Modifying duty from user given fields:\n" +
			"ID: '%s'\nName: '%s'\nDescription: '%s'";

	public static final String REMOVE_DUTY_EVENT = "Validation passed. Attempting to remove duty.";
	public static final String REMOVE_DUTY_MODEL = "Removing a duty based off the current object.";
	public static final String REMOVE_DUTY_CONTROLLER = "Removing a duty with the id %d.\n";

	public static final String COMPLETE_DUTY_EVENT = "Validation passed. Attempting to complete duty.";
	public static final String COMPLETE_DUTY_MODEL = "Completing a duty based off the current object.";
	public static final String COMPLETE_DUTY_CONTROLLER = "Completing a duty with the id %d.\n";

	public static final String GET_GROUP_DUTIES_MODEL = "Getting a list of duties for a group.";
	public static final String GET_GROUP_DUTIES_CONTROLLER = "Viewing all duties from the group" +
			"with group id: %d.\n";

	public static final String GET_USER_DUTIES_MODEL = "Getting a list of duties for a user.";
	public static final String GET_USER_DUTIES_CONTROLLER = "Viewing all duties from user with " +
			"user id: %d and group id: %d\n";

	public static final String GET_ROTATION_MODEL = "Getting the list of users on the duty's rotation.";
}
