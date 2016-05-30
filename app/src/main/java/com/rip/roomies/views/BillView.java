package com.rip.roomies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.activities.bills.Bills;
import com.rip.roomies.events.bills.ModifyBillListener;
import com.rip.roomies.events.bills.RemoveBillListener;
import com.rip.roomies.models.Bill;
import com.rip.roomies.util.InfoStrings;

import java.text.DecimalFormat;
import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/21/16.
 */
public class BillView extends LinearLayout {

    private static final Logger log = Logger.getLogger(BillView.class.getName());

    Bills activity;

    private Bill bill;
    private BillContainer container;

    /**
     * @see android.view.View( Context )
     */
    public BillView(Context context) {
        super(context);
    }

    public BillView(Context context, Bills activity, BillContainer container) {
        super(context);
        this.activity = activity;
        this.container = container;
    }


    /**
     * @see android.view.View(Context, AttributeSet )
     */
    public BillView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * @see android.view.View(Context, AttributeSet, int)
     */
    public BillView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * Get the User object that this class represents
     *
     * @return The User object in question
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * Set the bill of this object whose information this view will display
     *
     * @param bill The bill object to display
     */
    public void setBill(Bill bill) {
        this.bill = bill;
        setupLayout();
    }

    /**
     * Get the BillContainer holding this BillView
     *
     * @return The BillContainer object in question
     */
    public BillContainer getContainer() {
        return container;
    }

    /**
     * Sets up the layout for this UserView.
     */
    private void setupLayout() {
        log.info(String.format(InfoStrings.VIEW_SETUP, BillView.class.getSimpleName()));

        setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT));
        setOrientation(LinearLayout.VERTICAL);




        TextView name = new TextView(getContext());
        TextView amount = new TextView(getContext());
        TextView description = new TextView(getContext());
        Button removeBill = new Button(getContext());
        Button editBill = new Button(getContext());

        removeBill.setText("Remove Bill");
        editBill.setText("Edit Bill");

        //set the removeBill/editbill listeners
        removeBill.setOnClickListener(new RemoveBillListener(this, bill, removeBill, editBill, name, amount, description));
        editBill.setOnClickListener(new ModifyBillListener(activity, bill, this, name, amount, description));


        name.setText(bill.getName());
        description.setText(bill.getDescription());

        DecimalFormat cash = new DecimalFormat("$#.##");
        cash.setMinimumFractionDigits(2);
        amount.setText(cash.format(Math.abs(bill.getAmount())));



        addView(name);
        addView(amount);
        addView(description);
        addView(removeBill);
        addView(editBill);
    }
}
