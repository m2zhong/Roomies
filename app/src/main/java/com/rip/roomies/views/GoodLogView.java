package com.rip.roomies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.models.GoodLog;
import com.rip.roomies.util.InfoStrings;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Logger;

/**
 * Create a view that represents a good log.
 */
public class GoodLogView extends LinearLayout {

	private static final Logger log = Logger.getLogger(GoodLogView.class.getName());

	private GoodLog goodLog;

	/**
	 * @see android.view.View( Context )
	 */
	public GoodLogView(Context context) {
		super(context);
	}

	/**
	 * @see android.view.View(Context, AttributeSet )
	 */
	public GoodLogView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}


	/**
	 * @see android.view.View(Context, AttributeSet, int)
	 */
	public GoodLogView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
	}

	/**
	 * Get the Good object that this class represents
	 *
	 * @return The Good object in question
	 */
	public GoodLog getGoodLog() {
		return goodLog;
	}

	/**
	 * Set the good of this object whose information this view will display
	 *
	 * @param goodLog The good object to display
	 */
	public void setGoodLog(GoodLog goodLog) {
		this.goodLog = goodLog;
		setupLayout();
	}

	/**
	 * Sets up the layout for this GoodView.
	 */
	private void setupLayout() {
		log.info(String.format(InfoStrings.VIEW_SETUP, GoodLogView.class.getSimpleName()));

		setLayoutParams(new LayoutParams(
				LayoutParams.MATCH_PARENT,
				LayoutParams.WRAP_CONTENT));
		setOrientation(LinearLayout.HORIZONTAL);

		TextView name = new TextView(getContext());
		TextView description = new TextView(getContext());
		TextView assignee = new TextView(getContext());
		TextView completeDate = new TextView(getContext());
		LinearLayout innerLayout = new LinearLayout(getContext());

		innerLayout.setOrientation(LinearLayout.VERTICAL);

		name.setText(goodLog.getName());
		description.setText(goodLog.getDescription());

		String fullName = goodLog.getAssignee().getFirstName() + " " + goodLog.getAssignee().getLastName();
		assignee.setText(fullName);

		DateFormat compDate = new SimpleDateFormat("MM/dd/yyyy");
		String text = compDate.format(goodLog.getCompletion());
		completeDate.setText(text);

		innerLayout.addView(name);
		innerLayout.addView(description);
		innerLayout.addView(assignee);
		innerLayout.addView(completeDate);

		addView(innerLayout);
	}
}