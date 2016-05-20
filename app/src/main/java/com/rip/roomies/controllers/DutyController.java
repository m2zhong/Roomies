package com.rip.roomies.controllers;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class DutyController {
	private static DutyController controller;

	public static DutyController getController() {
		if (controller == null) {
			return new DutyController();
		}

		return controller;
	}
}
