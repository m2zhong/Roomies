package com.rip.roomies.sql;

import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
import com.rip.roomies.util.InfoStrings;

import java.sql.ResultSet;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/1/2016.
 */
public class SQLCreate {
	private static final Logger log = Logger.getLogger(SQLCreate.class.getName());

	public static Group createGroup(Group group) {

		//declare the execution query code for TSQL to login
		final String queryStr = "EXEC CreateGroup @name = '"+ group.getName() +
				"', @description = '" + group.getDescription() + "'";

		ResultSet rset = null;

		try {
			// get the result table from query execution through sql
			rset = SQLQuery.execute(queryStr);

			// group already exist
			if(rset == null || rset.getRow() == 0) {
				//debug statement
				log.info(InfoStrings.CREATEGROUP_FAILED);
				return null;
			}
			//if there's a rset
			else {
				rset.next();
				//first column is id, second is lastname, third is firstname
				//so pass the column number accordingly to get the info about user
				String resultName = rset.getString(2);
				String resultDescription = rset.getString(3);

				//debug statement
				log.info(String.format(InfoStrings.CREATEGROUP_SUCCESSFULL,
						resultName, resultDescription));

				return new Group(resultName, resultDescription);

			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	public static User createUser(User user) {

		//declare the execution query code for TSQL to login
		final String queryStr = "EXEC CreateUser @firstName = '" + user.getFirstName() +
				"', @lastName = '" + user.getLastName() +
				"', @username = '" + user.getUsername() +
				"', @email= '" + user.getEmail() +
				"', @password = '" + user.getPassword() + "'";

		ResultSet rset = null;

		try {
			// get the result table from query execution through sql
			rset = SQLQuery.execute(queryStr);

			// group already exist
			if(rset == null || rset.getRow() == 0) {
				//debug statement
				log.info(InfoStrings.CREATEUSER_FAILED);
				return null;
			}
			//if there's a rset
			else {
				rset.next();
				//second column is lastname, third is firstname
				//so pass the column number accordingly to get the info about user
				String resultLastName = rset.getString(2);
				String resultFirstName = rset.getString(3);
				String resultUsername = rset.getString(4);
				String resultEmail = rset.getString(5);

				//debug statement
				log.info(String.format(InfoStrings.CREATEUSER_SUCCESSFULL, resultLastName,
						resultFirstName, resultUsername, resultEmail));

				return new User(resultFirstName, resultLastName, resultUsername, resultEmail, null);

			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
