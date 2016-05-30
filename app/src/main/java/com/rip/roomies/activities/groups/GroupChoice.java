package com.rip.roomies.activities.groups;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;

public class GroupChoice extends GenericActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_join_group);
		Button joinBtn;
		Button createBtn;

		final Context self = this;
		joinBtn = (Button)findViewById(R.id.btnJoinGroup);
		createBtn = (Button)findViewById(R.id.btnCreateGroup);

		joinBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				self.startActivity(new Intent(self, JoinGroup.class));
			}
		});

		createBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				self.startActivity(new Intent(self, CreateGroup.class));
			}
		});
	}

	@Override
	public void onBackPressed() {
		// This is supposed to do nothing
	}
}
