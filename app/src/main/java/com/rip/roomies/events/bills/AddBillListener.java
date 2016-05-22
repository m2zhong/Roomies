package com.rip.roomies.events.bills;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rip.roomies.activities.bills.Bills;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.views.BillContainer;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/21/16.
 */
public class AddBillListener implements View.OnClickListener {
    private static final Logger log = Logger.getLogger(AddBillListener.class.getName());

    private Bills activity;
    private BillContainer container;

    public AddBillListener(Bills activity, BillContainer container) {
        this.activity = activity;
        this.container = container;
    }

    @Override
    public void onClick(View v) {

        log.info(String.format(Locale.US, InfoStrings.INVITE_USERS));

        //grab the 3 edit texts from xml->java

        activity.toAddBillScreen();

//        for (int i = 0; i < 10; i++) {
//            container.addBill(new Bill("Tony", "he lent me money for gas" + i, 5));
//
//        }

    }
}
