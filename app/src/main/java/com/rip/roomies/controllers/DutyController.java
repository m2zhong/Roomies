package com.rip.roomies.controllers;

import android.os.AsyncTask;

import com.rip.roomies.functions.CompleteDutyFunction;
import com.rip.roomies.functions.CreateDutyFunction;
import com.rip.roomies.functions.ListAllDutiesFunction;
import com.rip.roomies.functions.ListMyDutiesFunction;
import com.rip.roomies.functions.ModifyDutyFunction;
import com.rip.roomies.functions.RemoveDutyFunction;
import com.rip.roomies.models.Duty;
import com.rip.roomies.models.DutyLog;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
import com.rip.roomies.util.InfoStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class DutyController {
	private static final Logger log = Logger.getLogger(DutyController.class.getName());
	private static DutyController controller;

	public static DutyController getController() {
		if (controller == null) {
			return new DutyController();
		}

		return controller;
	}

	/**
	 * Attempts to create a duty with the specified parameters.
	 * @param funct The funct to post results to
	 * @param name The name of the duty in the database
	 * @param description The description of the duty
	 * @param groupId The ID of the group this duty is associated with
	 * @param users The list of Users on the rotation for this duty
	 */
	public void createDuty(final CreateDutyFunction funct, final String name, final String
			description, final int groupId, final User[] users) {
		// Create and run a new thread
		new AsyncTask<Void, Void, Duty>() {
			@Override
			public Duty doInBackground(Void... v) {
				log.info(String.format(Locale.US, InfoStrings.CREATE_DUTY_CONTROLLER, name,
						description, groupId, users.length));

				// Create request user and get response from login()
				Duty request = new Duty(name, description, groupId, users);
				Duty response = request.create();

				//need proper return type
				return response;
			}

			// If fail, call fail callback. Otherwise, call success callback
			@Override
			public void onPostExecute(Duty response) {
				if (response == null) {
					funct.createDutyFail();
				}
				else {
					funct.createDutySuccess(response);
				}
			}
		}.execute();
	}

	/**
	 * Attempts to display all duties for this group.
	 * @param funct The funct to post results to
	 */
	public void listAllDuties(final ListAllDutiesFunction funct) {
		// Create and run a new thread
		new AsyncTask<Void, Void, Duty[]>() {
			@Override
			public Duty[] doInBackground(Void... v) {
				log.info(String.format(Locale.US, InfoStrings.GET_GROUP_DUTIES_CONTROLLER));

				// Create request user and get response from login()
				Duty[] response = Group.getActiveGroup().getDuties();

				//need proper return type
				return response;
			}

			// If fail, call fail callback. Otherwise, call success callback
			@Override
			public void onPostExecute(Duty[] response) {
				if (response == null) {
					funct.listAllDutiesFail();
				}
				else {
					funct.listAllDutiesSuccess(response);
				}
			}
		}.execute();
	}

	/**
	 * Attempts to display all duties for this group.
	 * @param funct The funct to post results to
	 */
	public void listMyDuties(final ListMyDutiesFunction funct, final int groupId) {
		// Create and run a new thread
		new AsyncTask<Void, Void, Duty[]>() {
			@Override
			public Duty[] doInBackground(Void... v) {
				log.info(String.format(Locale.US, InfoStrings.GET_USER_DUTIES_CONTROLLER));

				// Create request user and get response from login()
				Duty[] response = User.getActiveUser().getDuties(groupId);

				//need proper return type
				return response;
			}

			// If fail, call fail callback. Otherwise, call success callback
			@Override
			public void onPostExecute(Duty[] response) {
				if (response == null) {
					funct.listMyDutiesFail();
				}
				else {
					funct.listMyDutiesSuccess(response);
				}
			}
		}.execute();
	}

	/**
	 * Attempts to modify the duty with the specified parameters.
	 * @param funct The funct to post results to
	 * @param id The unique id of this duty in the database
	 * @param name The name of the duty in the database
	 * @param description The description of the duty
	 * @param users The list of Users on the rotation for this duty
	 */
	public void modifyDuty(final ModifyDutyFunction funct, final int id, final String name, final
		String description, final User[] users) {
		// Create and run a new thread
		new AsyncTask<Void, Void, Duty>() {
			@Override
			public Duty doInBackground(Void... v) {
				log.info(String.format(Locale.US, InfoStrings.MODIFY_DUTY_CONTROLLER, id, name,
						description, users));

				// Create request user and get response from login()
				Duty request = new Duty(id, name, description, users);
				Duty response = request.modify();

				//need proper return type
				return response;
			}

			// If fail, call fail callback. Otherwise, call success callback
			@Override
			public void onPostExecute(Duty response) {
				if (response == null) {
					funct.modifyDutyFail();
				}
				else {
					funct.modifyDutySuccess(response);
				}
			}
		}.execute();
	}

	/**
	 * Attempts to remove the duty with the specified id.
	 * @param funct The funct to post results to
	 * @param id The unique id of this duty in the database
	 */
	public void removeDuty(final RemoveDutyFunction funct, final int id) {
		// Create and run a new thread
		new AsyncTask<Void, Void, Duty>() {
			@Override
			public Duty doInBackground(Void... v) {
				log.info(String.format(Locale.US, InfoStrings.REMOVE_DUTY_CONTROLLER, id));

				// Create request user and get response from login()
				Duty request = new Duty(id);
				Duty response = request.remove();

				//need proper return type
				return response;
			}

			// If fail, call fail callback. Otherwise, call success callback
			@Override
			public void onPostExecute(Duty response) {
				if (response == null) {
					funct.removeDutyFail();
				}
				else {
					funct.removeDutySuccess(response);
				}
			}
		}.execute();
	}

	/**
	 * Attempts to mark the duty with the specified id as completed.
	 * @param funct The funct to post results to
	 * @param id The unique id of this duty in the database
	 */
	public void completeDuty(final CompleteDutyFunction funct, final int id) {
		// Create and run a new thread
		new AsyncTask<Void, Void, DutyLog>() {
			@Override
			public DutyLog doInBackground(Void... v) {
				log.info(String.format(Locale.US, InfoStrings.COMPLETE_DUTY_CONTROLLER, id));

				// Create request user and get response from login()
				Duty request = new Duty(id);
				DutyLog response = request.complete();

				//need proper return type
				return response;
			}

			// If fail, call fail callback. Otherwise, call success callback
			@Override
			public void onPostExecute(DutyLog response) {
				if (response == null) {
					funct.completeDutyFail();
				}
				else {
					funct.completeDutySuccess(response);
				}
			}
		}.execute();
	}
}
