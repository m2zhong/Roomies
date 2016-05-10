package com.rip.roomies.events.login;

import android.view.View;
import android.widget.EditText;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.models.User;

import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/1/2016.
 */
public class CreateUserListener implements View.OnClickListener {
	private static final Logger log = Logger.getLogger(CreateUserListener.class.getName());

	public CreateUserListener(GenericActivity context, EditText firstName,
	                          EditText lastName, EditText username, EditText email,
	                          EditText passwd, EditText confirm) {

	}

	@Override
	public void onClick(View v) {

	}

	public void createUserFail() {

	}

	public void createUserSuccess(User user) {

	}
}
