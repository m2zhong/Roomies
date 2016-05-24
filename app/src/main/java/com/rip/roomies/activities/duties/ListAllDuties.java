package com.rip.roomies.activities.duties;

import android.os.Bundle;
import android.widget.Toast;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.DutyController;
import com.rip.roomies.functions.ListAllDutiesFunction;
import com.rip.roomies.models.Duty;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.views.DutyContainer;

/**
 * The activity of when the user wishes to view all the group's duties.
 */
public class ListAllDuties extends GenericActivity implements ListAllDutiesFunction {
	DutyContainer dc;

	@Override
	public void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.activity_list_all_duties);

		dc = (DutyContainer) findViewById(R.id.duty_list);

		DutyController.getController().listAllDuties(this);
	}

	/** @inheritDoc **/
	@Override
	public void listAllDutiesFail() {
		Toast.makeText(this, DisplayStrings.LIST_ALL_DUTIES_FAIL, Toast.LENGTH_LONG).show();
	}

	/** @inheritDoc **/
	@Override
	public void listAllDutiesSuccess(Duty[] duties) {
		for (Duty d : duties) {
			dc.addDuty(d);
		}
	}
}
