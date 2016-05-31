package com.rip.roomies.events.duties;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.DutyController;
import com.rip.roomies.functions.CompleteDutyFunction;
import com.rip.roomies.models.Duty;
import com.rip.roomies.models.User;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SocketStrings;

import java.net.URISyntaxException;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class represents the listener for when a duty is marked as completed.
 */
public class CompleteDutyListener implements View.OnClickListener, CompleteDutyFunction {
	private static final Logger log = Logger.getLogger(CompleteDutyListener.class.getName());

	private Duty duty;
	private GenericActivity activity;
	private PopupWindow popupWindow;

	/**
	 * Complete Duty Listener Constructor
	 *
	 * @param context  Activity that is using the listener
	 * @param duty  The existing duty object in a view
	 */
	public CompleteDutyListener(GenericActivity context, Duty duty, PopupWindow popUpWindow) {
		this.duty = duty;
		this.activity = context;
		this.popupWindow=popUpWindow;
	}

	/**
	 * completeDuty.onClickListener
	 *
	 * @param v the View object passed in by ViewDuty activity
	 */
	@Override
	public void onClick(View v) {

		popupWindow.dismiss();
		/*String Buffer for Error Message*/
		StringBuilder errMessage = new StringBuilder();

		/* Check if duty is null*/
		if (duty == null) {
			errMessage.append(String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Duty"));
		}
		/* Check if error occurred*/
		if (errMessage.length() != 0) {
			String errMsg = errMessage.substring(0, errMessage.length() - 1);
			Toast.makeText(activity, errMsg, Toast.LENGTH_SHORT).show();
			return;
		}

		log.info(InfoStrings.COMPLETE_DUTY_EVENT);
		/* Complete Duty Activity*/
		DutyController.getController().completeDuty(this, duty.getId());



		//after actually completed back from controller, call the and remind everyone
		Socket mSocket;
		try {
			//connection to the node.js server
			mSocket = IO.socket(SocketStrings.SERVER_URL);
			mSocket.connect();
			//make it start listening to reminder
			mSocket.emit(SocketStrings.COMPLETE_DUTY,
					User.getActiveUser().getFirstName(), duty.getName());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}


	}

	@Override
	public void completeDutyFail() {
		Toast.makeText(activity, DisplayStrings.COMPLETE_DUTY_FAIL, Toast.LENGTH_LONG).show();
	}

	@Override
	public void completeDutySuccess(Duty duty) {
		Intent i = activity.getIntent();
		i.putExtra("Duty", duty);
		activity.setResult(Activity.RESULT_OK, i);
		activity.finish();
	}
}
