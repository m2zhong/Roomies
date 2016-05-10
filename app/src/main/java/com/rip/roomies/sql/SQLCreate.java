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
 * A class that contains static methods for executing database comands relating to creation.
 */
public class SQLCreate {
	private static final Logger log = Logger.getLogger(SQLCreate.class.getName());

	/**
	 * Use SQLQuery class to create an connection and insert a group into the group table on the
	 * database, if is successful the User object will be returned, otherwise return null
	 *
	 * @param group The group that should be created on the database
	 * @return Group - the Group object with all the group info just been created
	 */
	public static Group createGroup(Group group) {
		ResultSet rset;

		try {
			//debug statement
			log.info(InfoStrings.CREATEGROUP_SQL);

			// get the result table from query execution through sql
			rset = SQLQuery.execute(String.format(Locale.US, SQLStrings.CREATE_GROUP,
					group.getName(), group.getDescription()));

			rset.next();
			// group already exist
			if (rset.getRow() == 0) {
				//debug statement
				log.info(InfoStrings.CREATEGROUP_FAILED);
				return null;
			}
			//if there's a rset
			else {
				//first column is id, second is lastname, third is firstname
				//so pass the column number accordingly to get the info about user
				int resultID = rset.getInt("ID");
				String resultName = rset.getString("Name");
				String resultDescription = rset.getString("Description");

				//debug statement
				log.info(String.format(Locale.US, InfoStrings.CREATEGROUP_SUCCESSFULL,
						resultID, resultName, resultDescription));

				return new Group(resultID, resultName, resultDescription);

			}
		}
		catch (Exception e) {
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	/**
	 * Use SQLQuery class to create an connection and insert a user into the user table on the
	 * database, if is successful the User object will be returned, otherwise return null
	 *
	 * @param user The user to be created on the database
	 * @return User - the User object with all the user info just been created
	 */
	public static User createUser(User user) {
		ResultSet rset;

		try {
			log.info(InfoStrings.CREATEUSER_SQL);

			// get the result table from query execution through sql
			rset = SQLQuery.execute(String.format(Locale.US, SQLStrings.CREATE_USER,
					user.getFirstName(), user.getLastName(), user.getUsername(),
					user.getEmail(), user.getPassword()));

			rset.next();
			// group already exist
			if (rset.getRow() == 0) {
				//debug statement
				log.info(InfoStrings.CREATEUSER_FAILED);
				return null;
			}
			//if there's a rset
			else {

				//second column is lastname, third is firstname
				//so pass the column number accordingly to get the info about user
				int resultID = rset.getInt("ID");
				String resultLastName = rset.getString("LastName");
				String resultFirstName = rset.getString("FirstName");
				String resultUsername = rset.getString("Username");
				String resultEmail = rset.getString("Email");

				//debug statement
				log.info(String.format(Locale.US, InfoStrings.CREATEUSER_SUCCESSFULL, resultID,
						resultLastName, resultFirstName, resultUsername, resultEmail));

				return new User(resultID, resultFirstName,
						resultLastName, resultUsername, resultEmail, null);

			}
		}
		catch (Exception e) {
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}
}
