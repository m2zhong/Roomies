package com.rip.roomies.events.bills;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.activities.bills.Bills;

/**
 * Created by VinnysMacOS on 5/20/16.
 */
public class ModifyBillListener implements View.OnClickListener {

    Bills activity;
    LinearLayout context;
    TextView name, description, amount;

    public ModifyBillListener(Bills activity, LinearLayout context, TextView name, TextView description, TextView amount) {
        this.activity = activity;
        this.context = context;
        this.name = name; this.description = description; this.amount = amount;
    }

    @Override
    public void onClick(View v) {
        //only if this is the creditor can the bill be modified

        activity.toEditBillScreen(name, description, amount);
    }

}
