package com.rip.roomies.activities.login;

<<<<<<< HEAD
import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
=======
import android.app.Activity;
import android.content.Intent;
>>>>>>> 3f4e2710b08e05934869937962403cafa980b2ba
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.login.LoginListener;

import java.util.logging.Logger;

/**
 * Login Activity
 */
<<<<<<< HEAD
public class Login extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
    }
=======
public class Login extends GenericActivity {
	private static final Logger log = Logger.getLogger(Login.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		/* Linking xml objects to java */
		EditText username = (EditText) findViewById(R.id.username);
		EditText password = (EditText) findViewById(R.id.password);
		Button login = (Button) findViewById(R.id.loginbtn);
		Button createUser = (Button) findViewById(R.id.regbtn);
		TextView forgotPass = (TextView) findViewById(R.id.forgotpw);

		final Activity self = this;

		login.setOnClickListener(new LoginListener(this, username, password));

		createUser.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, CreateUser.class));
			}
		});

		forgotPass.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, PassRetrieve.class));
			}
		});

	}

	@Override
	public void onBackPressed() {
		// This is supposed to do nothing
	}
>>>>>>> 3f4e2710b08e05934869937962403cafa980b2ba
}
