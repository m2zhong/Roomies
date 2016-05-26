package com.rip.roomies.activities.duties;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.duties.AddRotationListener;
import com.rip.roomies.events.duties.CompleteDutyListener;
import com.rip.roomies.events.duties.ModifyDutyListener;
import com.rip.roomies.models.Duty;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;
import com.rip.roomies.views.UserContainer;
import com.rip.roomies.views.UserSpinner;

import java.util.logging.Logger;

/**
 * This activity is intended for when a user modifies a duty.
 */
public class ViewDuty extends GenericActivity {
	private static final Logger log = Logger.getLogger(ModifyDuty.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_view_duty);

		Button completeDuty;
		TextView dutyName;
		TextView desc;
		UserContainer users;

		/* Linking xml objects to java */
		dutyName = (TextView) findViewById(R.id.duty_name);
		desc = (TextView) findViewById(R.id.description);
		users = (UserContainer) findViewById(R.id.users_container);
		completeDuty = (Button) findViewById(R.id.comp_duty_btn);

		// Populate the information
		Duty duty = getIntent().getExtras().getParcelable("Duty");

		if (duty != null) {
			dutyName.setText(duty.getName());
			desc.setText(duty.getDescription());

			for (User u : duty.getUsers()) {
				users.addUser(u);
			}
		}

		completeDuty.setOnClickListener(new CompleteDutyListener(this, duty));
	}


}
