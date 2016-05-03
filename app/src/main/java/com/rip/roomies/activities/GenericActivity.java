package com.rip.roomies.activities;

import android.app.Activity;
import android.content.Intent;

import com.rip.roomies.activities.login.Login;

/**
 * Created by Kanurame on 5/1/2016.
 */
public abstract class GenericActivity extends Activity {
    public void toLogin() {
        startActivity(new Intent(this, Login.class));
    }

    public void toHome() {

    }
}
