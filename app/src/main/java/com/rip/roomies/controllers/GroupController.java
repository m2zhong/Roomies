package com.rip.roomies.controllers;

import com.rip.roomies.events.groups.CreateGroupListener;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;

import java.util.logging.Logger;

/**
 * The controller to handle group related events.
 */
public class GroupController {
	private static final Logger log = Logger.getLogger(GroupController.class.getName());

	private static GroupController controller;

	/**
	 * Gets the static controller singleton object for this controller.
	 * @return The singleton controller
	 */
	public static GroupController getController() {
		if (controller == null) {
			controller = new GroupController();
		}

		return controller;
	}

	/**
	 * Creates a new group with the parameters specified, and adds the current user
	 * along with all the invitees afterwards.
	 * @param listener The listener to post the results to
	 * @param name The name of the group to create
	 * @param description The description of the group to create
	 * @param invitees The list of invitees exclusing the active user
	 */
	public void createGroup(final CreateGroupListener listener, final String name,
	                         final String description, final User[] invitees) {
		// Create and run a new thread
		new Thread() {
			@Override
			public void run() {
				// Create request group and get response from createGroup()
				Group request = new Group(name, description);
				Group response = request.createGroup();

				// If fail, call fail callback. Otherwise, call success callback
				if (response == null) {
					listener.createGroupFail();
				}
				else {
					// Add the current user and all invitees to the newly created group
					User.getActiveUser().addToGroup(response.getId());

					for (User req : invitees) {
						req.addToGroup(response.getId());
					}

					listener.createGroupSuccess(response);
				}
			}
		}.start();
	}
}
