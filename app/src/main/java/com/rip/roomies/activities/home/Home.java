package com.rip.roomies.activities.home;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.duties.ListAllDuties;
import com.rip.roomies.activities.duties.ListMyDuties;
import com.rip.roomies.events.Sockets.GetCompletionDutyListener;
import com.rip.roomies.events.Sockets.GetReminderDutyListener;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
import com.rip.roomies.util.SocketStrings;

import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Home extends GenericActivity {

	private static final Logger log = Logger.getLogger(Home.class.getName());

	private Socket mSocket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		TextView dutiesScreen = (TextView) findViewById(R.id.home_overallduties);

		final Activity self = this;

		dutiesScreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, ListAllDuties.class));
			}
		});

		Button toMyDuties = (Button) findViewById(R.id.to_view_my_duties);
		toMyDuties.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				self.startActivity(new Intent(self, ListMyDuties.class));
			}
		});

		try {
			//connection to the node.js server
			mSocket = IO.socket(SocketStrings.SERVER_URL);
			mSocket.connect();
			//make it start listening to reminder
			log.info("listening to notification, " + User.getActiveUser().getId());
			mSocket.emit(SocketStrings.NOTIFICATION_LISTEN, User.getActiveUser().getId());
			mSocket.emit(SocketStrings.COMPLETION_LISTEN, Group.getActiveGroup().getId());
			mSocket.on(SocketStrings.NOTIFICATION_DUTY, new GetReminderDutyListener(self));
			mSocket.on(SocketStrings.COMPLETE_DUTY, new GetCompletionDutyListener(self));
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onBackPressed() {
		// This does nothing
	}

}
