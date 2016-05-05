package com.rip.roomies.activities.login;

import android.os.Bundle;
import android.os.Handler;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;

public class SplashScreen extends GenericActivity {
    private static final long SPLASH_SCREEN_DELAY = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // Delayed switch to login screen
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                toLogin();
            }
        }, SPLASH_SCREEN_DELAY);
    }
}
