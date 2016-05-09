package com.rip.roomies.events.login;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;

import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/1/2016.
 */
public class LoginListener implements View.OnClickListener {
	private static final Logger log = Logger.getLogger(LoginListener.class.getName());
	private EditText username;
	private EditText password;
	private GenericActivity activity;

	/**
	 * Login Listenr Constructor
	 * @param context Activity that is using the listener
	 * @param username Username entered by user
	 * @param passwd Password entered by user
	 */
	public LoginListener(GenericActivity context, EditText username, EditText passwd) {
		this.username = username;
		this.password = passwd;
		this.activity = context;
	}

	/**
	 * login.onClickListener
	 * @param v the View object passed in by Login activty
	 */

	public void onClick(View v) {
		/*String Buffer for Error Message*/
		StringBuffer errMessage = new StringBuffer();

		/* Check if user entered username*/
		if (username.getText().toString().isEmpty()) {
			errMessage.append("Empty Username" + '\n');
		}
		/*Check if user entered password*/
		if (password.getText().toString().isEmpty()) {
			errMessage.append("Empty Password" + '\n');
		}
		/* Check if error occured*/
		if (errMessage.length() != 0) {
			Toast.makeText(activity, errMessage, Toast.LENGTH_SHORT).show();
			return;
		}

		/* Login Activity*/


	}
}
