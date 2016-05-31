package com.rip.roomies.activities.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.nkzawa.socketio.client.Socket;
import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.bills.Bills;
import com.rip.roomies.activities.duties.ListAllDuties;
import com.rip.roomies.activities.duties.ListMyDuties;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
import com.rip.roomies.server.ServerListener;
import com.rip.roomies.server.ServerRequest;
import com.rip.roomies.util.Images;

import java.net.URISyntaxException;
import java.util.logging.Logger;


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Home extends GenericActivity {
	private static final Logger log = Logger.getLogger(Home.class.getName());
	private static final double IMAGE_WIDTH_RATIO = 3.0 / 10;
	private static final double IMAGE_HEIGHT_RATIO = 2.0 / 25;
	private Socket mSocket;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		TextView dutiesScreen;
		TextView billScreen;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		dutiesScreen = (TextView) findViewById(R.id.home_overallduties);
		billScreen = (TextView) findViewById(R.id.home_IOU);
		dutiesScreen = (TextView) findViewById(R.id.home_overallduties);

		final Activity self = this;

		billScreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, Bills.class));
			}
		});

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

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);

		ImageView logo = (ImageView) findViewById(R.id.home_appname);
		logo.setImageBitmap(Images.getScaledDownBitmap(getResources(), R.mipmap.logowhite,
				(int) (size.x * IMAGE_WIDTH_RATIO), (int) (size.y * IMAGE_HEIGHT_RATIO)));


		//listening to all the notification
		try {
			ServerRequest.subscribToRoom(Group.getActiveGroup().getId());
			ServerRequest.subscribToMyTopic(User.getActiveUser().getId());

			ServerListener.activateCompleteDuty(self);
			ServerListener.activateRemindDuty(self);
//			ServerListener.activateCompleteCommonGood(self);
//			ServerListener.activateRemindCommonGood(self);
		}
		catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void onBackPressed() {
		// This does nothing
	}
}
