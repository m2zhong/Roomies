package com.rip.roomies.events.login;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.login.Login;
import com.rip.roomies.controllers.LoginController;
import com.rip.roomies.functions.PassRetrieveFunction;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class represents the listener for when the "Retrieve Password" button is pressed.
 */
public class PassRetrieveListener implements View.OnClickListener, PassRetrieveFunction {
	private static final Logger log = Logger.getLogger(PassRetrieveListener.class.getName());

	private GenericActivity context;
	private EditText email;

	public PassRetrieveListener(GenericActivity context, EditText email) {
		this.context = context;
		this.email = email;
	}

	@Override
	public void onClick(View v) {

		String errMsg = "";

		if (email.getText().toString().isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Email");
		}

		if (!errMsg.isEmpty()) {
			errMsg = errMsg.substring(0, errMsg.length() - 1);
			Toast.makeText(context, errMsg, Toast.LENGTH_SHORT).show();
			return;
		}

		log.info(InfoStrings.PASSRETRIEVE_EVENT);

		LoginController.getController().passRetrieve(this, email.getText().toString());
	}

	@Override
	public void passRetrieveFail() {
		Toast.makeText(context, DisplayStrings.PASS_RETRIEVE_FAIL, Toast.LENGTH_LONG).show();
	}

	@Override
	public void passRetrieveSuccess() {
		Toast.makeText(context, DisplayStrings.PASS_RETRIEVE_SUCCESS, Toast.LENGTH_SHORT).show();

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
