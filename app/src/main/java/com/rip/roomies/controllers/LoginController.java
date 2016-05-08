package com.rip.roomies.controllers;

import com.rip.roomies.models.User;

import java.util.logging.Logger;

/**
 * Created by Kanurame on 4/25/2016.
 */
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class.getName());

	private static LoginController controller;

	public static LoginController getController() {
		if (controller == null) {
			controller = new LoginController();
		}

		return controller;
	}

	public User createUser(String firstName, String lastName, String username,
	                       String email, String passwd) {
		return null;
	}

	public User login(String username, String passwd) {
		return null;
	}

	public void logoff() {

	}

	public boolean passRetrieve(String email) {
		return false;
	}
}
