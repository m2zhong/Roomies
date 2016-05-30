package com.rip.roomies.events.goods;

import android.view.View;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.models.Duty;
import com.rip.roomies.models.Good;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.util.SocketStrings;

import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Created by johndoney on 5/30/16.
 */
public class RemindGoodListener implements View.OnClickListener {
	private static final Logger log = Logger.getLogger(RemindGoodListener.class.getName());

	private int receiverID;
	private GenericActivity activity;
	private Good good;

	/**
	 * Complete Good Listener Constructor
	 *
	 * @param context  Activity that is using the listener
	 * @param receiverID  The ID of the person you want to remind
	 * @param good The good to be reminded of
	 */
	public RemindGoodListener(GenericActivity context, int receiverID, Good good) {
		this.receiverID = receiverID;
		this.activity = context;
		this.good = good;
	}

	/**
	 * completeGood.onClickListener
	 *
	 * @param v the View object passed in by ViewGood activity
	 */
	@Override
	public void onClick(View v) {

		Socket mSocket;
		try {
			//connection to the node.js server
			mSocket = IO.socket(SocketStrings.SERVER_URL);
			mSocket.connect();
			//make it start listening to reminder
			mSocket.emit(SocketStrings.NOTIFICATION_CSG, receiverID, good.getName());
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
		log.info(InfoStrings.REMIND_GOOD_EVENT);
	}

}
