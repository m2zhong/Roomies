package com.rip.roomies.activities.home;

import android.graphics.Point;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.duties.ListAllDuties;
import android.widget.Button;

import com.rip.roomies.activities.duties.ListMyDuties;
import com.rip.roomies.util.Images;

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

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);

		ImageView logo = (ImageView) findViewById(R.id.home_appname);
		logo.setImageBitmap(Images.getScaledDownBitmap(getResources(), R.mipmap.logowhite,
				(int) (size.x * IMAGE_WIDTH_RATIO), (int) (size.y * IMAGE_HEIGHT_RATIO)));
	}

	@Override
	public void onBackPressed() {
		// This does nothing
	}
}
