package com.rip.roomies.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.activities.duties.ModifyDuty;
import com.rip.roomies.activities.duties.ViewDuty;
import com.rip.roomies.models.Duty;
import com.rip.roomies.util.InfoStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class is a displayable view that represents a Duty object. It will display
 * any necessary information as well as style once implemented.
 */
public class DutyView extends LinearLayout {
	private static final Logger log = Logger.getLogger(DutyView.class.getName());
	public static final int EDIT_DUTY = 1;
	public static final int VIEW_DUTY = 2;

	private Duty duty;

	/**
	 * @see android.view.View(Context)
	 */
	public DutyView(Context context) {
		super(context);
	}

	/**
	 * @see android.view.View(Context, AttributeSet )
	 */
	public DutyView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * @see android.view.View(Context, AttributeSet, int)
	 */
	public DutyView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	/**
	 * Get the Duty object that this class represents
	 *
	 * @return The Duty object in question
	 */
	public Duty getDuty() {
		return duty;
	}

	/**
	 * Set the duty of this object whose information this view will display
	 *
	 * @param duty The duty object to display
	 */
	public void setDuty(Duty duty) {
		this.duty = duty;
		setupLayout();
	}

	/**
	 * Sets up the layout for this DutyView.
	 */
	private void setupLayout() {
		log.info(String.format(InfoStrings.VIEW_SETUP, DutyView.class.getSimpleName()));

		setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		setOrientation(LinearLayout.HORIZONTAL);

		TextView name = new TextView(getContext());
		TextView description = new TextView(getContext());
		TextView assignee = new TextView(getContext());
		Button viewBtn = new Button(getContext());
		Button editBtn = new Button(getContext());
		LinearLayout innerLayout = new LinearLayout(getContext());

		innerLayout.setOrientation(LinearLayout.VERTICAL);

		name.setText(duty.getName());
		description.setText(duty.getDescription());
		String fullName = duty.getAssignee().getFirstName() + " " + duty.getAssignee().getLastName();
		assignee.setText(fullName);

		innerLayout.addView(name);
		innerLayout.addView(description);
		innerLayout.addView(assignee);

		viewBtn.setText("View");
		viewBtn.setLayoutParams(new LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT, 1.0f));
		viewBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				log.info(String.format(Locale.US, InfoStrings.SWITCH_ACTIVITY,
						ViewDuty.class.getSimpleName()));

				Intent i = new Intent(getContext(), ViewDuty.class);
				i.putExtra("Duty", duty);
				((Activity) getContext()).startActivityForResult(i, VIEW_DUTY);
			}
		});

		editBtn.setText("Edit");
		editBtn.setLayoutParams(new LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.MATCH_PARENT, 1.0f));
		editBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				log.info(String.format(Locale.US, InfoStrings.SWITCH_ACTIVITY,
						ModifyDuty.class.getSimpleName()));

				Intent i = new Intent(getContext(), ModifyDuty.class);
				i.putExtra("Duty", duty);
				((Activity) getContext()).startActivityForResult(i, EDIT_DUTY);
			}
		});

		addView(innerLayout);
		addView(viewBtn);
		addView(editBtn);
	}
}
