package com.rip.roomies.sql;

import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
import com.rip.roomies.util.Exceptions;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SQLStrings;

import java.sql.ResultSet;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * A class that contains static methods for executing database commands relating to removing objects
 * or properties to existing objects.
 */
public class SQLRemove {
	private static final Logger log = Logger.getLogger(SQLRemove.class.getName());
	private static final int MAX_USERS_STRING_LENGTH = 1000;

	// group object and user object
	public static User leaveGroup(Group group, User user) {

		try {
			//take current user's group id # and user id #
			ResultSet rs;
			int groupId = group.getId();
			int userId = user.getId();

			// Log removing user from group
			log.info(InfoStrings.REMOVE_USER_FROM_GROUP_SQL);

			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.LEAVE_GROUP,
					groupId, userId));

			// Get results of SQL statement. Columns are ID, last name, first name
			// username, and email.
			int resultID = rs.getInt("ID");
			String resultLastName = rs.getString("LastName");
			String resultFirstName = rs.getString("FirstName");
			String resultUsername = rs.getString("Username");
			String resultEmail = rs.getString("Email");

			//debug statement
			log.info(String.format(Locale.US, InfoStrings.REMOVE_USER_FROM_GROUP_SUCCESSFUL,
					resultID, resultLastName, resultFirstName, resultUsername, resultEmail));

			// Return a new user object
			return new User(resultID, resultFirstName, resultLastName, resultUsername,
					resultEmail, null);
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}
}
