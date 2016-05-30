package com.rip.roomies.util;

/**
 * A class containing a list of static SQL strings.
 */
public class SQLStrings {
	public static final String LOGIN = "EXEC Login " +
			"@username = '%s', @password = '%s'";

	public static final String CREATE_GROUP = "EXEC CreateGroup " + "" +
			"@name = '%s', @description = '%s', @userId = %d";
	public static final String CREATE_USER = "EXEC CreateUser " +
			"@firstName = '%s', @lastName = '%s', @username = '%s', " +
			"@email= '%s', @password = '%s'";

	public static final String ADD_USERS_TO_GROUP = "EXEC AddUsersToGroup " +
			"@groupId = %d, @userIds = '%s'";

	public static final char LIST_DELIMITER = '|';

	public static final String FIND_USER = "EXEC FindUser " +
			"@id = %d, @username = '%s', @email = '%s'";

	public static final String LEAVE_GROUP = "EXEC LeaveGroup " +
			"@groupId = %d, @userId = %d";

	public static final String FIND_GROUP = "EXEC FindGroup " +
			"@id = %d, @name = '%s'";

	public static final String GET_GROUP_USERS = "EXEC GetGroupUsers " +
			"@groupId = %d";

	public static final String GET_GROUPS = "EXEC GetGroups " +
			"@userId = %d";

	public static final String CREATE_DUTY = "EXEC CreateDuty " +
			"@name = '%s', @desc = '%s', @group = %d, @userIds = '%s'";

	public static final String COMPLETE_DUTY = "EXEC CompleteDuty " +
			"@dutyid = %d";

	public static final String REMOVE_DUTY = "EXEC RemoveDuty " +
			"@dutyID = %d";

	public static final String MODIFY_DUTY = "EXEC ModifyDuty " +
			"@dutyID = %d, @name = '%s', @desc = '%s', @userIds = '%s'";

	public static final String GET_GROUP_DUTIES = "EXEC GetGroupDuties " +
			"@groupID = %d";

	public static final String GET_GROUP_DUTY_LOGS = "EXEC GetGroupDutyLogs " +
			"@groupID = %d";

	public static final String GET_USER_DUTIES = "EXEC GetUserDuties " +
			"@groupID = %d, @userID = %d";

	public static final String GET_DUTY_USERS = "EXEC GetDutyUsers " +
			"@dutyId = %d";

	public static final String GET_USER_BY_ID = "EXEC GetUserById " +
			"@userId = %d";
}
