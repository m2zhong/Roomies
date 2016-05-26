package com.rip.roomies.activities.duties;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.duties.AddRotationListener;
import com.rip.roomies.events.duties.ModifyDutyListener;
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

		Button modifyDuty;
		Button addUser;
		EditText dutyName;
		EditText desc;
		UserContainer users;
		UserSpinner allUsers;

		/* Linking xml objects to java */
		dutyName = (EditText) findViewById(R.id.duty_name);
		desc = (EditText) findViewById(R.id.description);
		allUsers = (UserSpinner) findViewById(R.id.group_users_spinner);
		addUser = (Button) findViewById(R.id.add_user_btn);
		users = (UserContainer) findViewById(R.id.users_container);
		modifyDuty = (Button) findViewById(R.id.mod_duty_btn);

		for(User u : Group.getActiveGroup().getMembers()) {
			allUsers.addUser(u);
		}

		// todo change null to DutyView
		//modifyDuty.setOnClickListener(new ModifyDutyListener(this, null));
		//addUser.setOnClickListener(new AddRotationListener(this, users, allUsers));

	}


}
