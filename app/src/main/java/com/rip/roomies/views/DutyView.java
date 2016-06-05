package com.rip.roomies.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.activities.duties.ListAllDuties;
import com.rip.roomies.activities.duties.ModifyDuty;

import com.rip.roomies.events.duties.CompleteDutyListener;
import com.rip.roomies.events.duties.PopUpDutyListener;
import com.rip.roomies.events.duties.RemindDutyListener;
import com.rip.roomies.functions.CompleteDutyFunction;
import com.rip.roomies.models.Duty;
import com.rip.roomies.models.User;
import com.rip.roomies.util.InfoStrings;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class is a displayable view that represents a Duty object. It will display
 * any necessary information as well as style once implemented.
 */
public class DutyView extends TaskView {
	private static final Logger log = Logger.getLogger(DutyView.class.getName());

	public static final int EDIT_DUTY = 1;
	public static final int VIEW_DUTY = 2;
	public static final int ADD_DUTY = 3;
	public static final int COMPLETE_GOOD = 4;

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
	protected void setupLayout() {
		log.info(String.format(InfoStrings.VIEW_SETUP, DutyView.class.getSimpleName()));

		removeAllViews();

		LinearLayout.LayoutParams w = new LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT);
		setLayoutParams(w);
		setOrientation(LinearLayout.VERTICAL);


		TextView name = new TextView(getContext());
		TextView description = new TextView(getContext());
		TextView assignee = new TextView(getContext());
		Button editBtn = new Button(getContext());
		Button actBtn = new Button(getContext());

		LinearLayout innerLayout = new LinearLayout(getContext());
		innerLayout.setLayoutParams(new LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, 1.0f));

		name.setTextColor(getResources().getColor(R.color.colorPrimary));
		name.setTextSize(25);

		description.setTextColor(Color.BLACK);
		description.setTextSize(15);

		assignee.setTextColor(getResources().getColor(R.color.black_overlay));
		assignee.setTextSize(15);

		innerLayout.setOrientation(LinearLayout.VERTICAL);
		innerLayout.setPadding(20, 20, 20, 20);

		name.setText(duty.getName());
		description.setText(duty.getDescription());
		String fullName = duty.getAssignee().getFirstName() + " " + duty.getAssignee().getLastName();
		assignee.setText(fullName);

		innerLayout.addView(name);
		innerLayout.addView(description);
		innerLayout.addView(assignee);

		editBtn.setText("Edit");
		editBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
		editBtn.setBackground(getResources().getDrawable(R.drawable.rec_border));
		editBtn.setPadding(20, 10, 20, 10);
		LinearLayout.LayoutParams p = new LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		p.gravity = Gravity.CENTER;
		p.setMargins(10, 50, 10, 50);
		editBtn.setLayoutParams(p);
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



		actBtn.setTextColor(getResources().getColor(R.color.colorPrimary));
		actBtn.setBackground(getResources().getDrawable(R.drawable.rec_border));
		LinearLayout.LayoutParams v = new LayoutParams(
				LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		v.gravity = Gravity.CENTER;
		v.setMargins(10, 50, 10, 50);
		actBtn.setLayoutParams(v);

		User currentAssignee = duty.getAssignee();
		if (currentAssignee.getId() == User.getActiveUser().getId()) {
			actBtn.setText("Complete");
			actBtn.setPadding(10, 20, 10 , 20);
		}
		else{
			actBtn.setText("Remind");
			actBtn.setPadding(10, 20, 10 , 20);
		}

		actBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				User currentAssignee = duty.getAssignee();
				if (currentAssignee.getId() == User.getActiveUser().getId()) {
					int popUpID = R.layout.activity_confirm_duty_comp;
					((Button) v).setOnClickListener(new PopUpDutyListener(
							(GenericActivity) getContext(), (CompleteDutyFunction) getContext(),
							((Button) v), popUpID, duty));
				}
				else{
					((Button) v).setOnClickListener(new RemindDutyListener(
							(GenericActivity) getContext(), currentAssignee.getId(), duty));
				}
			}
		});

		LinearLayout hline = new LinearLayout(getContext());
		hline.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1));
		hline.setBackgroundColor(Color.BLACK);

		LinearLayout outerLayout = new LinearLayout(getContext());
		outerLayout.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));
		outerLayout.setOrientation(LinearLayout.HORIZONTAL);

		outerLayout.addView(innerLayout);
		outerLayout.addView(editBtn);
		outerLayout.addView(actBtn);

		addView(hline);
		addView(outerLayout);
	}
}
