package com.rip.roomies.activities.login;

import android.os.Bundle;
import android.os.Handler;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.util.InfoStrings;

import java.util.logging.Logger;

public class SplashScreen extends GenericActivity {
	private static final Logger log = Logger.getLogger(SplashScreen.class.getName());

	private static final long SPLASH_SCREEN_DELAY = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash_screen);

		log.info(String.format(InfoStrings.SWITCH_ACTIVITY_DELAYED,
				Login.class.getName(), SPLASH_SCREEN_DELAY));

		// Delayed switch to login screen
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				toLogin();
			}
		}, SPLASH_SCREEN_DELAY);
	}
}
