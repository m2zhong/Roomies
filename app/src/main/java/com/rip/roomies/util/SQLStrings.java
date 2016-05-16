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
}
