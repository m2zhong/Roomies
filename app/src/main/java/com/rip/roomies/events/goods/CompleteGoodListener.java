package com.rip.roomies.events.goods;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.GoodController;
import com.rip.roomies.functions.CompleteGoodFunction;
import com.rip.roomies.models.Good;
import com.rip.roomies.models.User;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SocketStrings;

import java.net.URISyntaxException;
import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by johndoney on 5/30/16.
 */
public class CompleteGoodListener implements View.OnClickListener, CompleteGoodFunction {
	private static final Logger log = Logger.getLogger(CompleteGoodListener.class.getName());

	private Good good;
	private GenericActivity activity;

	/**
	 * Complete Good Listener Constructor
	 *
	 * @param context  Activity that is using the listener
	 * @param good  The existing good object in a view
	 */
	public CompleteGoodListener(GenericActivity context, Good good) {
		this.good = good;
		this.activity = context;
	}

	/**
	 * completeDuty.onClickListener
	 *
	 * @param v the View object passed in by ViewDuty activity
	 */
	@Override
	public void onClick(View v) {
		/*String Buffer for Error Message*/
		StringBuilder errMessage = new StringBuilder();

		/* Check if duty is null*/
		if (good == null) {
			errMessage.append(String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Good"));
		}
		/* Check if error occurred*/
		if (errMessage.length() != 0) {
			String errMsg = errMessage.substring(0, errMessage.length() - 1);
			Toast.makeText(activity, errMsg, Toast.LENGTH_SHORT).show();
			return;
		}

		log.info(InfoStrings.COMPLETE_GOOD_EVENT);
		/* Complete Good Activity*/
		GoodController.getController().completeGood(this, good.getId());



		//after actually completed back from controller, call the and remind everyone
		Socket mSocket;
		try {
			//connection to the node.js server
			mSocket = IO.socket(SocketStrings.SERVER_URL);
			mSocket.connect();
			//make it start listening to reminder
			mSocket.emit(SocketStrings.COMPLETE_CSG,
					User.getActiveUser().getFirstName(), good.getName());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}


	}

	@Override
	public void completeGoodFail() {
		Toast.makeText(activity, DisplayStrings.COMPLETE_GOOD_FAIL, Toast.LENGTH_LONG).show();
	}

	@Override
	public void completeGoodSuccess(Good good) {
		Intent i = activity.getIntent();
		i.putExtra("Good", good);
		activity.setResult(Activity.RESULT_OK, i);
		activity.finish();
	}
}
