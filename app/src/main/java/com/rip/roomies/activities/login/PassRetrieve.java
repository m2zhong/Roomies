package com.rip.roomies.activities.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.login.PassRetrieveListener;

import java.util.logging.Logger;

public class PassRetrieve extends GenericActivity {
	private static final Logger log = Logger.getLogger(PassRetrieve.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_pass_retrieve);

		EditText email = (EditText) findViewById(R.id.pass_retrieve_email);
		Button submit = (Button) findViewById(R.id.pass_retrieve_submit);

		submit.setOnClickListener(new PassRetrieveListener(this, email));
	}
}
