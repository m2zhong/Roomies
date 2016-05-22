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
import com.rip.roomies.activities.bills.Bills;
import com.rip.roomies.events.login.LoginListener;

import java.util.logging.Logger;

/**
 * Login Activity
 */
public class Login extends GenericActivity {
	private static final Logger log = Logger.getLogger(Login.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Button login;
		Button createUser;
		TextView forgotPass;
		EditText username;
		EditText password;

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		startActivity(new Intent(this, Bills.class));


		/* Linking xml objects to java */
		username = (EditText) findViewById(R.id.username);
		password = (EditText) findViewById(R.id.password);
		login = (Button) findViewById(R.id.loginbtn);
		createUser = (Button) findViewById(R.id.regbtn);
		forgotPass = (TextView) findViewById(R.id.forgotpw);

		final Activity self = this;

		login.setOnClickListener(new LoginListener(this, username, password));

		createUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, CreateUser.class));
			}
		});

		forgotPass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, PassRetrieve.class));
			}
		});

	}

	@Override
	public void onBackPressed() {
		// This is supposed to do nothing
	}
}
