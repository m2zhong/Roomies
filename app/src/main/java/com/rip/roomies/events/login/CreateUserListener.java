package com.rip.roomies.events.login;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.login.Login;
import com.rip.roomies.controllers.UserController;
import com.rip.roomies.models.User;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class represents the listener for when the "Create User" button is pressed.
 */
public class CreateUserListener implements View.OnClickListener {
	private static final Logger log = Logger.getLogger(CreateUserListener.class.getName());

	private GenericActivity context;
	private EditText firstName;
	private EditText lastName;
	private EditText username;
	private EditText email;
	private EditText passwd;
	private EditText confirm;

	public CreateUserListener(GenericActivity context, EditText firstName,
	                          EditText lastName, EditText username, EditText email,
	                          EditText passwd, EditText confirm) {
		this.context = context;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.email = email;
		this.passwd = passwd;
		this.confirm = confirm;
	}

	@Override
	public void onClick(View v) {
		String errMsg = "";
		String fName = firstName.getText().toString();
		String lName = lastName.getText().toString();
		String uname = username.getText().toString();
		String emailAddr = email.getText().toString();
		String password = passwd.getText().toString();
		String conf = confirm.getText().toString();

		if (fName.isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "First Name");
		}
		if (lName.isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Last Name");
		}
		if (uname.isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Username");
		}
		if (emailAddr.isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Email");
		}
		if (password.isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Password");
		}
		if (conf.isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Confirm Password");
		}

		if (!password.isEmpty() && !conf.isEmpty() &&
				!password.equals(conf)) {

			errMsg += String.format(Locale.US, DisplayStrings.FIELD_MISMATCH,
					"Password", "Confirm Password");
		}

		if (!errMsg.isEmpty()) {
			errMsg = errMsg.substring(0, errMsg.length() - 1);
			Toast.makeText(context, errMsg, Toast.LENGTH_SHORT).show();
			return;
		}

		log.info(InfoStrings.CREATEUSER_EVENT);

		UserController.getController().createUser(this, fName, lName, uname, emailAddr, password);
	}

	public void createUserFail() {
		Toast.makeText(context, DisplayStrings.CREATE_USER_FAIL, Toast.LENGTH_LONG).show();
	}

	public void createUserSuccess(User user) {
		Toast.makeText(context, String.format(Locale.US, DisplayStrings.CREATE_USER_SUCCESS,
				user.getUsername()), Toast.LENGTH_SHORT).show();

		log.info(String.format(Locale.US, InfoStrings.SWITCH_ACTIVITY_DELAYED,
				Login.class.getName(), DisplayStrings.TOAST_SHORT_LENGTH));

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				context.toLogin();
			}
		}, DisplayStrings.TOAST_SHORT_LENGTH);
	}
}
