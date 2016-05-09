package com.rip.roomies.activities.login;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.login.CreateUserListener;
import com.rip.roomies.events.login.LoginListener;
import com.rip.roomies.sql.SQLQuery;

import java.sql.SQLException;

import java.util.logging.Logger;

public class Login extends GenericActivity {
    private static final Logger log = Logger.getLogger(Login.class.getName());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button login;
        Button create_user;
        EditText user_name;
        EditText password;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user_name = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.loginbtn);
        create_user = (Button) findViewById(R.id.regbtn);

        login.setOnClickListener(new LoginListener(this,user_name,password));

        try {
            SQLQuery.execute("EXEC PROC CreateUser");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void switch_regscreen(){



    }
}
