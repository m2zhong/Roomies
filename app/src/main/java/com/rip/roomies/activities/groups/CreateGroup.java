package com.rip.roomies.activities.groups;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.groups.CreateGroupListener;
import com.rip.roomies.events.login.AddInviteeListener;
import com.rip.roomies.views.UserContainer;

import java.util.logging.Logger;

public class CreateGroup extends GenericActivity {
	private static final Logger log = Logger.getLogger(CreateGroup.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_create_group);

		EditText name = (EditText) findViewById(R.id.group_name);
		EditText description = (EditText) findViewById(R.id.group_description);
		EditText inviteeField = (EditText) findViewById(R.id.invitee_add_field);
		UserContainer inviteeContainer = (UserContainer) findViewById(R.id.invitee_container);
		Button addInvitee = (Button) findViewById(R.id.invitee_add_btn);
		Button submit = (Button) findViewById(R.id.create_group_submit);

		addInvitee.setOnClickListener(new AddInviteeListener(this, inviteeContainer, inviteeField));
		submit.setOnClickListener(new CreateGroupListener(this, name, description, inviteeContainer));
	}
}
