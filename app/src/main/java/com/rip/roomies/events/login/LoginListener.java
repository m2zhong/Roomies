package com.rip.roomies.events.login;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.LoginController;
import com.rip.roomies.functions.LoginFunction;
import com.rip.roomies.models.User;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class represents the listener for when the "Login" button is pressed.
 */
public class LoginListener implements View.OnClickListener, LoginFunction {
	private static final Logger log = Logger.getLogger(LoginListener.class.getName());

	private EditText username;
	private EditText password;
	private GenericActivity activity;

	/**
	 * Login Listenr Constructor
	 *
	 * @param context  Activity that is using the listener
	 * @param username Username entered by user
	 * @param passwd   Password entered by user
	 */
	public LoginListener(GenericActivity context, EditText username, EditText passwd) {
		this.username = username;
		this.password = passwd;
		this.activity = context;
	}

	/**
	 * login.onClickListener
	 *
	 * @param v the View object passed in by Login activty
	 */

	@Override
	public void onClick(View v) {
		/*String Buffer for Error Message*/
		StringBuilder errMessage = new StringBuilder();

		/* Check if user entered username*/
		if (username.getText().toString().isEmpty()) {
			errMessage.append(String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Username"));
		}
		/*Check if user entered password*/
		if (password.getText().toString().isEmpty()) {
			errMessage.append(String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Password"));
		}
		/* Check if error occured*/
		if (errMessage.length() != 0) {
			String errMsg = errMessage.substring(0, errMessage.length() - 1);
			Toast.makeText(activity, errMsg, Toast.LENGTH_SHORT).show();
			return;
		}

		log.info(InfoStrings.LOGIN_EVENT);

		/* Login Activity*/
		LoginController.getController().login(this, username.getText().toString(),
				password.getText().toString());
	}

	@Override
	public void loginFail() {
		Toast.makeText(activity, DisplayStrings.LOGIN_FAIL, Toast.LENGTH_LONG).show();
	}

	@Override
	public void loginSuccess(User user) {
		activity.toHome();
	}
}
