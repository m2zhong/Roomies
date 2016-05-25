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

	public static final String GET_GROUPS = "EXEC GetGroups " +
			"@userId = %d";

	public static final String CREATE_BILL = "EXEC CreateBill " +
			"@owner_id = %d, " +
			"@name = '%s', @description = '%s', @amount = %.2f;";

	public static final String DELETE_BILL = "EXEC DeleteBill " +
			"@ID = %d;";


	public static final String MODIFY_BILL_SQL = "EXEC ModifyBill " +
			"@id = %d, @name = '%s', @description = '%s', @amount = %.2f;";

}
