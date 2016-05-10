package com.rip.roomies.activities.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.login.CreateUserListener;
import com.rip.roomies.events.login.LoginListener;
import com.rip.roomies.sql.SQLQuery;

import java.sql.SQLException;

import java.util.logging.Logger;

/**
 * Login Activity
 */
public class Login extends GenericActivity {
	private static final Logger log = Logger.getLogger(Login.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Button login;
		Button create_user;
		TextView forgot_pass;
		EditText user_name;
		EditText password;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		/* Linking xml objects to java */
		user_name = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.loginbtn);
		create_user = (Button) findViewById(R.id.regbtn);
		forgot_pass = (TextView) findViewById(R.id.forgotpw);

		login.setOnClickListener(new LoginListener(this, user_name, password));

		final Activity self = this;
		create_user.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, CreateUser.class));
			}
		});

		forgot_pass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, PassRetrieve.class));
			}
		});

	}
}
