package com.rip.roomies.events.duties;

import android.view.View;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.DutyController;
import com.rip.roomies.functions.RemoveDutyFunction;
import com.rip.roomies.models.Duty;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.views.DutyView;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class represents the listener for when a duty is deleted.
 */
public class RemoveDutyListener implements View.OnClickListener, RemoveDutyFunction {
	private static final Logger log = Logger.getLogger(CompleteDutyListener.class.getName());

	private DutyView duty;
	private GenericActivity activity;

	/**
	 * Remove Duty Listener Constructor
	 *
	 * @param context  Activity that is using the listener
	 * @param duty  The existing duty object in a view
	 */
	public RemoveDutyListener(GenericActivity context, DutyView duty) {
		this.duty = duty;
		this.activity = context;
	}

	/**
	 * removeDuty.onClickListener
	 *
	 * @param v the View object passed in by ViewDuty activity
	 */
	@Override
	public void onClick(View v) {
		/*String Buffer for Error Message*/
		StringBuilder errMessage = new StringBuilder();

		/* Check if duty is null*/
		if (duty == null || duty.getDuty() == null) {
			errMessage.append(String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Duty"));
		}
		/* Check if error occurred*/
		if (errMessage.length() != 0) {
			String errMsg = errMessage.substring(0, errMessage.length() - 1);
			Toast.makeText(activity, errMsg, Toast.LENGTH_SHORT).show();
			return;
		}

		log.info(InfoStrings.REMOVE_DUTY_EVENT);

		/* Remove Duty Activity*/
		DutyController.getController().removeDuty(this, duty.getDuty().getId());
	}

	@Override
	public void removeDutyFail() {
		Toast.makeText(activity, DisplayStrings.REMOVE_DUTY_FAIL, Toast.LENGTH_LONG).show();
	}

	@Override
	public void removeDutySuccess(Duty duty) {
		Toast.makeText(activity, DisplayStrings.REMOVE_DUTY_SUCCESS, Toast.LENGTH_LONG).show();
	}
}
