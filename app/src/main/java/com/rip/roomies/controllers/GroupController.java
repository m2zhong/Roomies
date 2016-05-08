package com.rip.roomies.controllers;

import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;

import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/2/2016.
 */
public class GroupController {
	private static final Logger log = Logger.getLogger(GroupController.class.getName());

	private static GroupController controller;

	public static GroupController getController() {
		if (controller == null) {
			controller = new GroupController();
		}

		return controller;
	}

	public Group createGroup(String name, String description, User[] invitees) {
		return null;
	}
}
