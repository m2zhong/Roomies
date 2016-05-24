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
	 * @param groupId The id to use to search for a duty on the database
	 * @return The full set of group duties, or null if none could not be found
	 */
	public static Duty[] getGroupDuties(int groupId) {
		ResultSet rs;

		try {
			// Log finding user
			log.info(InfoStrings.GET_GROUP_DUTIES_SQL);

			// Execute SQL
			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.GET_GROUP_DUTIES,
					groupId));

			//todo need to determine case of 0 duties or query failed
			// If no rows, then finding failed
			if (rs == null || !rs.next()) {
				log.info(InfoStrings.GET_GROUP_DUTIES_FAILED);
				return null;
			}
			else {
				ArrayList<Duty> duties = new ArrayList<>();

				do {
					int resultId = rs.getInt("ID");
					String resultName = rs.getString("Name");
					String resultDescription = rs.getString("Description");
					int resultGroup = rs.getInt("DutyGroupID");

					//todo need to change null to list of users
					duties.add(new Duty(resultId, resultName, resultDescription, resultGroup, null));
				} while(rs.next());

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
	 * @param groupId The group's id to use to search for a duty on the database
	 * @param userId The user's id to search for a duty on the database
	 * @return The full set of user's duties, or null if none could not be found
	 */
	public static Duty[] getUserDuties(int groupId, int userId) {
		ResultSet rs;

		try {
			// Log finding user
			log.info(InfoStrings.GET_USER_DUTIES_SQL);

			// Execute SQL
			rs = SQLQuery.execute(String.format(Locale.US, SQLStrings.GET_USER_DUTIES,
					groupId));

			//todo need to determine case of 0 duties or query failed
			// If no rows, then finding failed
			if (rs == null || !rs.next()) {
				log.info(InfoStrings.GET_USER_DUTIES_FAILED);
				return null;
			}
			else {
				ArrayList<Duty> duties = new ArrayList<>();

				do {
					int resultId = rs.getInt("ID");
					String resultName = rs.getString("Name");
					String resultDescription = rs.getString("Description");
					int resultGroup = rs.getInt("DutyGroupID");

					//todo need to change null to list of users
					duties.add(new Duty(resultId, resultName, resultDescription, resultGroup, null));
				} while(rs.next());

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
}