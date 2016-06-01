package com.rip.roomies.events.bills;

import android.view.View;
import android.widget.LinearLayout;

import com.rip.roomies.models.Bill;
import com.rip.roomies.models.User;
import com.rip.roomies.server.ServerRequest;

import java.net.URISyntaxException;

/**
 * Created by michaelzhong on 5/29/16.
 */


public class RemindBillListener implements View.OnClickListener{
	private Bill bill;
	private String oweeID;

	public RemindBillListener(LinearLayout context, Bill bill, String oweeID) {
		this.bill=bill;
		this.oweeID=oweeID;
	}

	@Override
	public void onClick(View v) {
		/* INSER REMINDER FUNCTION CALL HERE (HAO) */
		try {
			ServerRequest.remindBill(Integer.parseInt(oweeID), User.getActiveUser().getFirstName(),
					bill.getAmount(), bill.getDescription());
		}
		catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
}
