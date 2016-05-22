package com.rip.roomies.events.bills;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by VinnysMacOS on 5/20/16.
 */
public class RemoveBillListener implements View.OnClickListener {

    private LinearLayout context;
    private Button removeBill, editBill;
    private TextView name, amount,description;

    public RemoveBillListener(LinearLayout context, Button removeBill, Button editBill,
                              TextView name, TextView description, TextView amount) {
        this.context = context;
        this.removeBill = removeBill; this.editBill = editBill;
        this.name = name; this.description = description; this.amount = amount;
    }

    @Override
    public void onClick(View v) {
        //check to see if this is a creditor or debtor, if its a creditor, meaning some1 owes this money
        //and this creditor is saying remove bill, dont display a toast, otherwise
        context.removeView(removeBill); context.removeView(editBill);
        context.removeView(name); context.removeView(amount); context.removeView(description);
    }
}
