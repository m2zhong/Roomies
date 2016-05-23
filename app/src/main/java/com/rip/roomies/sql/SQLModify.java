package com.rip.roomies.sql;

import com.rip.roomies.models.Duty;
import com.rip.roomies.util.Exceptions;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SQLStrings;

import java.sql.ResultSet;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class SQLModify {
	private static final Logger log = Logger.getLogger(SQLModify.class.getName());

	public static DutyLog completeDuty(Duty duty) {
		ResultSet rset;

		//
		//TODO : make sure fields match SQL database table values
		//
		try {
			//debug statement
			log.info(InfoStrings.COMPLETEDUTY_SQL);

			// get the result table from query execution through sql
			rset = SQLQuery.execute(String.format(Locale.US, SQLStrings.COMPLETE_DUTY,
					null);

			// error happened when contacting sql server
			if(rset == null || !rset.next()) {
				// debug statement
				log.info(InfoStrings.COMPLETEDUTY_FAILED);
				return null;
			}
			// if there is a rset
			else {
				//explain what each column corresponds to
				int resultId = rset.getInt("ID");
				String resultName = rset.getString("Name");
				String resultDescription = rset.getString("Description");
				//add more columns?

				// debug statement
				log.info(String.format(Locale.US, InfoStrings.CREATEDUTY_SUCCESSFUL,
						resultId, resultName, resultDescription));

				return new DutyLog();
			}
		}
		catch (Exception e) {
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}
}
