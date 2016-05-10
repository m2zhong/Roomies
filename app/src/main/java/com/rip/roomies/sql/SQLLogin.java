package com.rip.roomies.sql;

import com.rip.roomies.models.User;
import com.rip.roomies.util.Exceptions;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SQLStrings;

import java.sql.ResultSet;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class contains static methods for executing database procedures relating to login actions.
 */
public class SQLLogin {
	private static final Logger log = Logger.getLogger(SQLLogin.class.getName());

	/**
	 * Use SQLQuery class to create an connection and find the user's info from the database
	 * to log in, if is successful the User object will be returned, otherwise return null
	 *
	 * @param user The request User object to attempt to login with
	 * @return User - the User object with all the user info
	 */
	public static User login(User user) {
		ResultSet rset;

		try {
			// get the result table from query execution through sql
			rset = SQLQuery.execute(String.format(SQLStrings.LOGIN,
					user.getUsername(), user.getPassword()));

			//get the next row, kind of like scanner.nextLine()
			rset.next();
			// either username doesn't exist or password incorrect
			if (rset.getRow() == 0) {
				//debug statement
				log.info(InfoStrings.LOGIN_FAILED);
				return null;
			}
			//if there's a rset
			else {
				//second column is lastname, third is firstname
				//so pass the column number accordingly to get the info about user
				int resultID = rset.getInt(1);
				String resultLastName = rset.getString(2);
				String resultFirstName = rset.getString(3);
				String resultUsername = rset.getString(4);
				String resultEmail = rset.getString(5);

				//debug message
				log.info(String.format(Locale.US, InfoStrings.LOGIN_SUCCESSFULL, resultID, resultLastName,
						resultFirstName, resultUsername, resultEmail));

				return new User(resultID, resultFirstName, resultLastName,
						resultUsername, resultEmail, null);

			}
		}
		catch (Exception e) {
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	/**
	 * This method attempts to do a password retrieval by sending an email to the email address
	 * specified in the User parameter.
	 * @param user The user object with email to send recovery to
	 * @return True if successful, false otherwise
	 */
	public static boolean passRetrieve(User user) {
		// TODO
		return false;
	}
}
