package com.rip.roomies.activities.login;

import android.os.Bundle;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;

import java.util.logging.Logger;

public class CreateUser extends GenericActivity {
	private static final Logger log = Logger.getLogger(CreateUser.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_create_user);
	}
}
