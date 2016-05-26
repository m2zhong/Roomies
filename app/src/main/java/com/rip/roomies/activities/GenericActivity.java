package com.rip.roomies.activities;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.rip.roomies.activities.home.Home;
import com.rip.roomies.activities.login.Login;
import com.rip.roomies.util.InfoStrings;

import java.util.logging.Logger;

/**
 * This class generically represents all Activities that will exist in the Roomies application.
 * Its primary purpose is to define a set of transition methods for moving between activities.
 * These methods can be overriden if some extra functionality is needed.
 */
public abstract class GenericActivity extends Activity {
	private static final Logger log = Logger.getLogger(GenericActivity.class.getName());

	/**
	 * Transitions to the main login page.
	 */
	public void toLogin() {
		log.info(String.format(InfoStrings.SWITCH_ACTIVITY, Login.class.getName()));

		
		startActivity(new Intent(this, Login.class));
	}

	/**
	 * Transitions to the home screen.
	 */
	public void toHome() {
		log.info(String.format(InfoStrings.SWITCH_ACTIVITY, Home.class.getName()));

		startActivity(new Intent(this, Home.class));
	}
}
