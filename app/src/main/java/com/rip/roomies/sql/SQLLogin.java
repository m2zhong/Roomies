package com.rip.roomies.sql;

import com.rip.roomies.models.User;
import com.rip.roomies.util.InfoStrings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 4/25/2016.
 */
public class SQLLogin {
	private static final Logger log = Logger.getLogger(SQLLogin.class.getName());

	/**
	 * Use SQLQuery class to create an connection and find the user's info from the database
	 * to log in, if is successful the User object will be returned, otherwise return null
	 *
	 * @param user
	 * @return User - the User object with all the user info
	 * @throws Exception if the database cannot be connected to or statement fails
	 */
	public static User login(User user) {

		//declare the execution query code for TSQL to login
		final String queryStr = "EXEC Login @username = '" + user.getUsername() +
				"', @password = '" + user.getPassword() + "'";

		ResultSet rset = null;

		try {
			// get the result table from query execution through sql
			rset = SQLQuery.execute(queryStr);

			//get the next row, kind of like scanner.nextLine()
			rset.next();
			// either username doesn't exist or password incorrect
			if (rset == null || rset.getRow() == 0) {
				//debug statement
				log.info(InfoStrings.LOGIN_FAILED);
				return null;
			}
			//if there's a rset
			else {
				//second column is lastname, third is firstname
				//so pass the column number accordingly to get the info about user
				String resultLastName = rset.getString(2);
				String resultFirstName = rset.getString(3);
				String resultUsername = rset.getString(4);
				String resultEmail = rset.getString(5);

				//debug message
				log.info(String.format(InfoStrings.LOGIN_SUCCESSFULL, resultLastName,
						resultFirstName, resultUsername, resultEmail));

				return new User(resultFirstName, resultLastName, resultUsername, resultEmail, null);

			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean passRetrieve(User user) {
		return false;
	}
}
