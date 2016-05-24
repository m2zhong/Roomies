package com.rip.roomies.events.duties;

import android.view.View;

import com.rip.roomies.functions.CompleteDutyFunction;
import com.rip.roomies.functions.CreateDutyFunction;
import com.rip.roomies.models.Duty;
import com.rip.roomies.models.DutyLog;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class CompleteDutyListener implements View.OnClickListener, CompleteDutyFunction {
	@Override
	public void onClick(View v) {

	}

	@Override
	public void completeDutyFail() {

	}

	@Override
	public void completeDutySuccess(DutyLog duty) {

	}
}
