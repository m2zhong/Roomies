package com.rip.roomies.sql;

import com.rip.roomies.models.Bill;

import com.rip.roomies.models.Duty;
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

			// error happened when contacting sql server
			if(rs == null || !rs.next()) {
				// debug statement
				log.info(InfoStrings.REMOVE_USER_FROM_GROUP_FAILED);
				return null;
			}
			// if there is a rs
			else {

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
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	// duty
	public static Duty removeDuty(Duty duty) {

		try {
			ResultSet rs;

			// Log removing user from group
			log.info(InfoStrings.REMOVEDUTY_SQL);

			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.REMOVE_DUTY,
					duty.getId()));

			// error happened when contacting sql server
			if(rs == null || !rs.next()) {
				// debug statement
				log.info(InfoStrings.REMOVEDUTY_FAILED);
				return null;
			}
			// if there is a rs
			else {
				//explain what each column corresponds to
				int resultId = rs.getInt("DutyID");
				String resultName = rs.getString("Name");
				String resultDescription = rs.getString("Description");
				int resultGroup = rs.getInt("DutyGroupID");

				User u = new User(
						rs.getInt("ID"),
						rs.getString("FirstName"),
						rs.getString("LastName"),
						rs.getString("Username"),
						rs.getString("Email"),
						null
				);

				// debug statement
				log.info(String.format(Locale.US, InfoStrings.REMOVEDUTY_SUCCESSFUL,
						resultId, resultName, resultDescription, resultGroup));

				return new Duty(resultId, resultName, resultDescription, resultGroup,
						u, duty.getUsers());
			}
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	public static Bill removeBill(int rowID) {

		try {
			ResultSet rs;

			// Log removing bill from sql
			log.info(InfoStrings.REMOVE_BILL_FROM_TABLE_SQL);

			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.DELETE_BILL,
					rowID));

			rs.next();

			// Get results of SQL statement.
			int resultID = rs.getInt("ID");
			int resultOwnerID = rs.getInt("OwnerID");
			String resultName = rs.getString("name");
			String resultDescription = rs.getString("Description");
			float resultAmount = rs.getFloat("Amount");

			//debug statement
			log.info(String.format(Locale.US, InfoStrings.REMOVE_BILL_FROM_TABLE_SUCCESS,
					resultID, resultOwnerID, resultName, resultDescription, resultAmount));

			// Return a new user object
			return new Bill(resultID, resultOwnerID, resultName, resultDescription, resultAmount);
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}


}
