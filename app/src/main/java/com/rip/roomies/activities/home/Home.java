package com.rip.roomies.activities.home;
import android.os.Bundle;
import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Home extends GenericActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_home);
	}

	@Override
	public void onBackPressed() {
		// This does nothing
	}
}
