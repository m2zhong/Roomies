package com.rip.roomies.activities.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.login.createuser.SubmitListener;
import com.rip.roomies.sql.SQLQuery;

import java.sql.SQLException;

import java.util.logging.Logger;

public class Login extends GenericActivity {
<<<<<<< HEAD
    Button login;
    Button create_user;
    EditText user_name;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        try {
            SQLQuery.execute("EXEC PROC CreateUser");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
=======
	private static final Logger log = Logger.getLogger(Login.class.getName());

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_login);
	}
>>>>>>> e93fc9c26712ad29c4ae31baa6682dbdddc56c20
}
