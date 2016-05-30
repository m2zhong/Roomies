package com.rip.roomies.views;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.R;
import com.rip.roomies.activities.bills.Bills;
import com.rip.roomies.events.bills.ModifyBillListener;
import com.rip.roomies.events.bills.RemindBillListener;
import com.rip.roomies.events.bills.RemoveBillListener;
import com.rip.roomies.models.Bill;
import com.rip.roomies.util.InfoStrings;

import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/21/16.
 */
public class BillView extends LinearLayout {

	private static final Logger log = Logger.getLogger(BillView.class.getName());

	Bills activity;

	private Bill bill;
	private String oweeID;


	/**
	 * @see android.view.View( Context )
	 */
	public BillView(Context context) {
		super(context);
	}

	public BillView(Context context, Bills activity, String oweeID) {
		super(context);
		this.activity = activity;
		this.oweeID = oweeID;
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
	 * Sets up the layout for this UserView.
	 */
	private void setupLayout() {
		log.info(String.format(InfoStrings.VIEW_SETUP, BillView.class.getSimpleName()));

		setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		setOrientation(LinearLayout.VERTICAL);

        /* Horizontal Container for Buttons*/
		LinearLayout innerLayout = new LinearLayout(getContext());
		innerLayout.setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));

		LinearLayout underline = new LinearLayout(getContext());
		underline.setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT, 1));

		underline.setBackgroundColor(getResources().getColor(R.color.black));

		innerLayout.setOrientation(LinearLayout.HORIZONTAL);

		TextView name = new TextView(getContext());
		TextView amount = new TextView(getContext());
		TextView description = new TextView(getContext());
		Button removeBill = new Button(getContext());
		Button editBill = new Button(getContext());
		Button remindBill = new Button(getContext());

		/* Setting text Size */
		name.setTextSize(20);
		amount.setTextSize(20);
		description.setTextSize(20);

        /* set layout_gravity for Buttons. Prepping for Linear Layout*/


        /* Setting text Color */
		name.setTextColor(getResources().getColor(R.color.black));
		amount.setTextColor(getResources().getColor(R.color.black));
		description.setTextColor(getResources().getColor(R.color.black));

		removeBill.setText("Remove");
		editBill.setText("Edit");
		remindBill.setText("Remind");

		removeBill.setTextSize(15);
		editBill.setTextSize(15);
		remindBill.setTextSize(15);

		/* Setting Font */
		removeBill.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));
		editBill.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));
		remindBill.setTypeface(Typeface.create("sans-serif-light", Typeface.NORMAL));

		removeBill.setTextColor(getResources().getColor(R.color.pink));
		editBill.setTextColor(getResources().getColor(R.color.colorPrimary));
		remindBill.setTextColor(getResources().getColor(R.color.colorPrimary));



        /* Changing Gray buttons to Blue bordered ones */
		removeBill.setBackground(getResources().getDrawable(R.drawable.rec_border_pink));
		editBill.setBackground(getResources().getDrawable(R.drawable.rec_border));
		remindBill.setBackground(getResources().getDrawable(R.drawable.rec_border));

		//set the removeBill/editbill listeners
		removeBill.setOnClickListener(new RemoveBillListener(this, bill, removeBill,
				editBill, name,
				amount, description, innerLayout, underline));

		editBill.setOnClickListener(new ModifyBillListener(activity, bill,
				this, name,
				amount, description));

		remindBill.setOnClickListener(new RemindBillListener(this, bill, oweeID));

		/* Getting User's Information from bill*/
		name.setText(bill.getName());
		amount.setText(String.valueOf(bill.getAmount()));
		description.setText(bill.getDescription());

		/* Accenting the name of each bill. Better to differentiate*/
		name.setTypeface(Typeface.DEFAULT_BOLD);
		description.setTextColor(getResources().getColor(R.color.black_overlay));

		/* Removing negative sign in amount in YouOwe */
		if (bill.getAmount()< 0)
			amount.setText('$' + String.valueOf(bill.getAmount()).substring(1));
		else
			amount.setText('$' + String.valueOf(bill.getAmount()));



		/* Setting up Layout Parameters for the buttons and bill info */

		LinearLayout.LayoutParams editBill_lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT,
				0.33f);

		LinearLayout.LayoutParams removeBill_lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT,
				0.33f);

		LinearLayout.LayoutParams remindBill_lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT,
				0.33f);

		LinearLayout.LayoutParams billInfo_lp = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.MATCH_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);

		billInfo_lp.setMargins(40, 0, 0, 0);

		/* Adding space between Buttons */
		editBill_lp.setMargins(20,15,10,20);
		removeBill_lp.setMargins(10,15,20,20);
		remindBill_lp.setMargins(10,15,10,20);


		/* Setting Buttons in LinearView Horizontal for owe you */
		innerLayout.addView(editBill, editBill_lp);

		/* Removing negative sign in owe you before display */
		if(bill.getAmount()>0)
			innerLayout.addView(remindBill, remindBill_lp);

		innerLayout.addView(removeBill, removeBill_lp);
		innerLayout.setGravity(Gravity.CENTER);
		addView(name, billInfo_lp);
		addView(amount, billInfo_lp);
		addView(description, billInfo_lp);
		addView(innerLayout);
		addView(underline);
		setPadding(0,0,0,5);

	}
}
