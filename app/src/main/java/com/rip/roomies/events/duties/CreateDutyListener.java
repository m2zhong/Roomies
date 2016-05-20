package com.rip.roomies.events.duties;

import android.view.View;

import com.rip.roomies.functions.CreateDutyFunction;
import com.rip.roomies.models.Duty;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class CreateDutyListener implements View.OnClickListener, CreateDutyFunction {
	@Override
	public void onClick(View v) {

	}

	@Override
	public void createDutyFail() {

	}

	@Override
	public void createDutySuccess(Duty duty) {

	}
}
