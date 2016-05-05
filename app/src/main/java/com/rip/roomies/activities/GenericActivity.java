package com.rip.roomies.activities;

import android.app.Activity;
import android.content.Intent;

import com.rip.roomies.activities.login.Login;

/**
 * This class generically represents all Activities that will exist in the Roomies application.
 * Its primary purpose is to define a set of transition methods for moving between activities.
 * These methods can be overriden if some extra functionality is needed.
 */
public abstract class GenericActivity extends Activity {
    /**
     * Transitions to the main login page.
     */
    public void toLogin() {
        startActivity(new Intent(this, Login.class));
    }

    /**
     * Transitions to the home screen.
     */
    public void toHome() {
        // TODO once home screen has been created
    }
}
