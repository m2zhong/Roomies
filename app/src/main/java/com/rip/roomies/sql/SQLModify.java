package com.rip.roomies.sql;

import com.rip.roomies.models.Duty;
import com.rip.roomies.models.DutyLog;
import com.rip.roomies.models.User;
import com.rip.roomies.util.Exceptions;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SQLStrings;
import com.rip.roomies.util.WarningStrings;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class SQLModify {
	private static final Logger log = Logger.getLogger(SQLModify.class.getName());
	private static final int MAX_USERS_STRING_LENGTH = 1000;

	public static DutyLog completeDuty(Duty duty) {
		ResultSet rset;

		try {
			//debug statement
			log.info(InfoStrings.COMPLETEDUTY_SQL);

			// get the result table from query execution through sql
			rset = SQLQuery.execute(String.format(Locale.US, SQLStrings.COMPLETE_DUTY,
					duty.getId()));

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
				int dutyGroupId = rset.getInt("DutyGroupID");
				Date completeDate = rset.getDate("CompletionDate");
				int assigneeId = rset.getInt("AssigneeID");
				//add more columns?

				// debug statement
				log.info(String.format(Locale.US, InfoStrings.COMPLETEDUTY_SUCCESSFUL,
						resultId, resultName, resultDescription));

				return new DutyLog(resultId, resultName, resultDescription, dutyGroupId,
						completeDate, duty.getId(), assigneeId);
			}
		}
		catch (Exception e) {
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}

	public static Duty modifyDuty(Duty duty) {
		ResultSet rset;
		String usersString = "";

		try {
			// Turn users array into a delineated string
			for (User user : duty.getUsers()) {
				usersString += user.getId();
				usersString += SQLStrings.LIST_DELIMITER;
			}

			// Can only take max length of 1000, so truncate
			if (usersString.length() > MAX_USERS_STRING_LENGTH) {
				log.warning(String.format(Locale.US, WarningStrings.ADD_USERS_TO_GROUP_TRUNCATE,
						MAX_USERS_STRING_LENGTH));
				usersString = usersString.substring(0, MAX_USERS_STRING_LENGTH);
				usersString = usersString.substring(0, usersString.lastIndexOf(SQLStrings.LIST_DELIMITER) + 1);
			}
			//debug statement
			log.info(InfoStrings.MODIFYDUTY_SQL);

			// get the result table from query execution through sql
			rset = SQLQuery.execute(String.format(Locale.US, SQLStrings.MODIFY_DUTY,
					duty.getId(), duty.getName(), duty.getDescription(), usersString));

			// error happened when contacting sql server
			if(rset == null || !rset.next()) {
				// debug statement
				log.info(InfoStrings.MODIFYDUTY_FAILED);
				return null;
			}
			// if there is a rset
			else {
				//explain what each column corresponds to
				int resultId = rset.getInt("ID");
				String resultName = rset.getString("Name");
				String resultDescription = rset.getString("Description");
				int dutyGroupId = rset.getInt("DutyGroupID");

				// debug statement
				log.info(String.format(Locale.US, InfoStrings.MODIFYDUTY_SUCCESSFUL,
						resultId, resultName, resultDescription, dutyGroupId));

				return new Duty(resultId, resultName, resultDescription, dutyGroupId,
						duty.getUsers());
			}
		}
		catch (Exception e) {
			log.severe(Exceptions.stacktraceToString(e));
			return null;
		}
	}
}
