package com.rip.roomies.activities.home;

import android.content.Intent;
import android.os.Bundle;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.bills.Bills;

public class Home extends GenericActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		startActivity(new Intent(this, Bills.class));

	}

	@Override
	public void onBackPressed() {
		// This is supposed to do nothing
	}
}
