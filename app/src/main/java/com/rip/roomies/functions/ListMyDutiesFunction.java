package com.rip.roomies.functions;

import com.rip.roomies.models.Duty;

/**
 * Created by Kanurame on 5/19/2016.
 */
public interface ListMyDutiesFunction {
	void listMyDutiesFail();
	void listMyDutiesSuccess(Duty[] duties);
}
