package com.rip.roomies.activities.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.bills.Bills;
import com.rip.roomies.activities.duties.ListAllDuties;
import com.rip.roomies.activities.duties.ListMyDuties;

public class Home extends GenericActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		startActivity(new Intent(this, Bills.class));

		Button allDuties = (Button) findViewById(R.id.to_view_all_duties);
		Button myDuties = (Button) findViewById(R.id.to_view_my_duties);

		final Context self = this;
		allDuties.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(self, ListAllDuties.class));
			}
		});

		myDuties.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(self, ListMyDuties.class));
			}
		});
	}

	@Override
	public void onBackPressed() {
		// This is supposed to do nothing
	}
}
