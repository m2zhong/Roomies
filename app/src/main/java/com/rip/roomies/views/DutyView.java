package com.rip.roomies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.models.Duty;
import com.rip.roomies.util.InfoStrings;

import java.util.logging.Logger;

/**
 * This class is a displayable view that represents a Duty object. It will display
 * any necessary information as well as style once implemented.
 */
public class DutyView extends LinearLayout {
	private static final Logger log = Logger.getLogger(DutyView.class.getName());

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

		setLayoutParams(new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT));
		setOrientation(LinearLayout.VERTICAL);

		TextView name = new TextView(getContext());
		TextView description = new TextView(getContext());
		TextView assignee = new TextView(getContext());

		name.setText(duty.getName());
		description.setText(duty.getDescription());
		String fullName = duty.getAssignee().getFirstName() + " " + duty.getAssignee().getLastName();
		name.setText(fullName);

		addView(name);
		addView(description);
		addView(assignee);
	}
}
