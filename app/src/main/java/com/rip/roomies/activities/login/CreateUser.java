package com.rip.roomies.activities.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.login.CreateUserListener;

import java.util.logging.Logger;

public class CreateUser extends GenericActivity {
	private static final Logger log = Logger.getLogger(CreateUser.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Button create_user;
		EditText first_name;
		EditText last_name;
		EditText user_name;
		EditText email;
		EditText password;
		EditText confirm_password;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_user);

		/* Linking xml objects to java */
		first_name = (EditText) findViewById(R.id.firstName);
		last_name = (EditText) findViewById(R.id.lastName);
		user_name = (EditText) findViewById(R.id.username);
		email = (EditText) findViewById(R.id.email);
		password = (EditText) findViewById(R.id.password);
		confirm_password = (EditText) findViewById(R.id.confirmPass);
		create_user = (Button) findViewById(R.id.btnsubmit);


		create_user.setOnClickListener(
				new CreateUserListener(this, first_name, last_name, user_name, email, password, confirm_password));
	}
}
