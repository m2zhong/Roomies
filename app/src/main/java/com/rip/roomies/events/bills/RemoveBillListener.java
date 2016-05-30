package com.rip.roomies.events.bills;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.controllers.BillController;
import com.rip.roomies.models.Bill;
import com.rip.roomies.views.BillView;

/**
 * Created by VinnysMacOS on 5/20/16.
 */
public class RemoveBillListener implements View.OnClickListener {

    private LinearLayout context;
    private Button removeBill, editBill;
    private TextView name, amount,description;
    private Bill selectedBill;
    private LinearLayout innerLayout;
    private LinearLayout underline;

    public RemoveBillListener(LinearLayout context, Bill selectedBill, Button removeBill, Button editBill,
                              TextView name, TextView description, TextView amount, LinearLayout innerLayout,
                              LinearLayout underline) {
        this.context = context;
        this.removeBill = removeBill; this.editBill = editBill;
        this.name = name; this.description = description; this.amount = amount;
        this.selectedBill = selectedBill;
        this.innerLayout=innerLayout;
        this.underline=underline;
    }

    @Override
    public void onClick(View v) {
        //first remove the selectedBill from the DB
        BillController.getController().removeBill(selectedBill.getRowID(), ((BillView)context).getContainer());

        //now remove its contents from the view.
        context.removeView(removeBill); context.removeView(editBill);
        context.removeView(name); context.removeView(amount); context.removeView(description);
        context.removeView(editBill); context.removeView(removeBill);
        context.removeView(innerLayout); context.removeView(underline);
    }
}
