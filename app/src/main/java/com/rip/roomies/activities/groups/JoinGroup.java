package com.rip.roomies.activities.groups;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.groups.JoinGroupListener;

public class JoinGroup extends GenericActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_join_group);

		EditText name = (EditText) findViewById(R.id.group_name);
<<<<<<< HEAD
		Button submit = (Button) findViewById(R.id.join_group_btn);
=======
		Button submit = (Button) findViewById(R.id.join_group_submit);
>>>>>>> 2a34d35dc132dc2b07ba22bb70c722fc0e194030

		submit.setOnClickListener(new JoinGroupListener(this, name));
	}
}
