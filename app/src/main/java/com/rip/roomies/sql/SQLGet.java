package com.rip.roomies.sql;

import com.rip.roomies.models.Duty;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
import com.rip.roomies.util.Exceptions;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SQLStrings;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * A class that contains static methods for executing database commands relating to getting.
 */
public class SQLGet {
	private static final Logger log = Logger.getLogger(SQLGet.class.getName());

	/**
	 * Finds a user from the database using unique keys only
	 * @param user The object to use to search for a user on the database
	 * @return The full user object, or null if the user could not be found
	 */
	public static Group[] getGroups(User user) {
		ResultSet rs;

		try {
			// Log finding user
			log.info(InfoStrings.GET_GROUPS_SQL);

			// Execute SQL
			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.GET_GROUPS,
					user.getId()));

			// If no rows, then finding failed
			if (rs == null || !rs.next()) {
				log.info(InfoStrings.GET_GROUPS_FAILED);
				return null;
			}
			else {
				ArrayList<Group> groups = new ArrayList<>();

				do {
					int id = rs.getInt("GroupID");
					groups.add(new Group(id, "", ""));
				} while(rs.next());

				//debug statement
				log.info(InfoStrings.GET_GROUPS_SUCCESSFUL);

				Group[] temp = new Group[groups.size()];

				// Return a new user object
				return groups.toArray(temp);
			}
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	/**
	 * Finds a duty from the database using unique keys only
	 * @param group The group to use to search for a duty on the database
	 * @return The full set of group duties, or null if none could not be found
	 */
	public static Duty[] getGroupDuties(Group group) {
		ResultSet rs;

		try {
			// Log finding user
			log.info(InfoStrings.GET_GROUP_DUTIES_SQL);

			// Execute SQL
			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.GET_GROUP_DUTIES,
					group.getId()));

			// If no rows, then finding failed
			if (rs == null) {
				log.info(InfoStrings.GET_GROUP_DUTIES_FAILED);
				return null;
			}
			else {
				ArrayList<Duty> duties = new ArrayList<>();

				while(rs.next()) {
					int resultId = rs.getInt("ID");
					String resultName = rs.getString("Name");
					String resultDescription = rs.getString("Description");
					int resultGroup = rs.getInt("DutyGroupID");


					Duty temp = new Duty(resultId, resultName, resultDescription, resultGroup, null);
					temp = temp.getRotation();

					duties.add(temp);

				}

				//debug statement
				log.info(InfoStrings.GET_GROUP_DUTIES_SUCCESSFUL);

				Duty[] temp = new Duty[duties.size()];

				// Return a new user object
				return duties.toArray(temp);
			}
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	/**
	 * Finds a duty from the database using unique keys only
	 * @param group The group the user belongs to
	 * @param user The user to search for a duty on the database
	 * @return The full set of user's duties, or null if none could not be found
	 */
	public static Duty[] getUserDuties(Group group, User user) {
		ResultSet rs;

		try {
			// Log finding user
			log.info(InfoStrings.GET_USER_DUTIES_SQL);

			// Execute SQL
			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.GET_USER_DUTIES,
					group.getId(), user.getId()));

			// If no rows, then finding failed
			if (rs == null) {
				log.info(InfoStrings.GET_USER_DUTIES_FAILED);
				return null;
			}
			else {
				ArrayList<Duty> duties = new ArrayList<>();

				while(rs.next()){
					int resultId = rs.getInt("ID");
					String resultName = rs.getString("Name");
					String resultDescription = rs.getString("Description");
					int resultGroup = rs.getInt("DutyGroupID");

					Duty temp = new Duty(resultId, resultName, resultDescription, resultGroup, null);
					temp = temp.getRotation();

					duties.add(temp);

				}

				//debug statement
				log.info(InfoStrings.GET_USER_DUTIES_SUCCESSFUL);

				Duty[] temp = new Duty[duties.size()];

				// Return a new user object
				return duties.toArray(temp);
			}
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	/**
	 * Finds a duty from the database using unique keys only
	 * @param duty The group the user belongs to
	 * @return The full set of user's duties, or null if none could not be found
	 */
	public static Duty getDutyUsers(Duty duty) {
		ResultSet rs;

		try {
			// Log finding user
			log.info(InfoStrings.GET_DUTY_USERS_SQL);

			// Execute SQL
			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.GET_DUTY_USERS,
					duty.getId()));

			// If no rows, then finding failed
			if (rs == null || !rs.next()) {
				log.info(InfoStrings.GET_DUTY_USERS_FAILED);
				return null;
			}
			else {
				ArrayList<User> users = new ArrayList<>();

				do {
					int id = rs.getInt("ID");
					String first = rs.getString("FirstName");
					String last = rs.getString("LastName");
					String username = rs.getString("Username");
					String email = rs.getString("Email");

					users.add(new User(id, first, last, username, email, null));
				} while(rs.next());

				//debug statement
				log.info(InfoStrings.GET_DUTY_USERS_SUCCESSFUL);

				User[] temp = new User[users.size()];

				// Return a new user object
				return new Duty(duty.getId(), duty.getName(), duty.getDescription(),
						duty.getGroupId(), temp);
			}
		}
		catch (Exception e) {
			// Log and return null on exception
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}
}