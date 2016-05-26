package com.rip.roomies.activities.duties;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.DutyController;
import com.rip.roomies.functions.ListAllDutiesFunction;
import com.rip.roomies.models.Duty;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.views.DutyContainer;
import com.rip.roomies.views.DutyView;

import java.util.logging.Logger;

/**
 * The activity of when the user wishes to view all the group's duties.
 */
public class ListAllDuties extends GenericActivity implements ListAllDutiesFunction {
	private static final Logger log = Logger.getLogger(ListAllDuties.class.getName());
	DutyContainer dc;

	@Override
	public void onCreate(Bundle savedInstance) {
		Button addDuty;

		super.onCreate(savedInstance);
		setContentView(R.layout.activity_list_all_duties);

		/* Linking xml objects to java */
		dc = (DutyContainer) findViewById(R.id.duty_list);
		addDuty = (Button) findViewById(R.id.duty_addbtn);

		final Activity self = this;

		DutyController.getController().listAllDuties(this);

		addDuty.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				startActivity(new Intent(self, CreateDuty.class));
			}
		});
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

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == DutyView.EDIT_DUTY && resultCode == RESULT_OK) {
			Duty duty = data.getExtras().getParcelable("Duty");
			boolean toRemove = data.getExtras().getBoolean("toRemove");

			if (toRemove) {
				dc.removeDuty(duty);
			}
			else {
				dc.modifyDuty(duty);
			}
		}
		else if (requestCode == DutyView.VIEW_DUTY && resultCode == RESULT_OK) {
			Duty duty = data.getExtras().getParcelable("Duty");
			dc.modifyDuty(duty);
		}
	}
}
