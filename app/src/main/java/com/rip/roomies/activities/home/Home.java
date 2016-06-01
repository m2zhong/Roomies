package com.rip.roomies.activities.home;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.QuickContactBadge;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;
import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.bills.Bills;
import com.rip.roomies.activities.duties.ListAllDuties;
import com.rip.roomies.activities.goods.ListAllGoods;
import com.rip.roomies.activities.profile.Profile;
import com.rip.roomies.activities.tasks.ListMyTasks;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
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

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		TextView dutiesScreen;
		TextView billScreen;
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		//right when load in home screen update the token
		try {
			ServerRequest.refreshToken(User.getActiveUser().getId(), FirebaseInstanceId.getInstance().getToken());
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}


		dutiesScreen = (TextView) findViewById(R.id.home_overallduties);
		TextView goodsScreen = (TextView) findViewById(R.id.home_shareditem);
		billScreen = (TextView) findViewById(R.id.home_IOU);

		final Activity self = this;

		QuickContactBadge profileBadge = (QuickContactBadge) findViewById(R.id.home_profilepicture);

		profileBadge.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, Profile.class));
			}
		});


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


		goodsScreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, ListAllGoods.class));
			}
		});
		
		TextView toMyDuties = (TextView) findViewById(R.id.to_view_my_duties);
		toMyDuties.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View view){
				startActivity(new Intent(self, ListMyTasks.class));
			}
		}
		);

		toMyDuties.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				self.startActivity(new Intent(self, ListMyTasks.class));
			}
		});

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);

		ImageView logo = (ImageView) findViewById(R.id.home_appname);
		logo.setImageBitmap(Images.getScaledDownBitmap(getResources(), R.mipmap.logo2,
				(int) (size.x * IMAGE_WIDTH_RATIO), (int) (size.y * IMAGE_HEIGHT_RATIO)));

		//make server listening to all the notification
		try {
			ServerRequest.subscribToRoom(Group.getActiveGroup().getId());
			ServerRequest.subscribToMyTopic(User.getActiveUser().getId());
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
