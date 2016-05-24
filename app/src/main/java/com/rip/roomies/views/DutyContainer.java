package com.rip.roomies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.rip.roomies.models.Duty;
import com.rip.roomies.util.InfoStrings;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * This class represents a container for multiple DutyView objects that can
 * be displayed in a dynamic group.
 */
public class DutyContainer extends ScrollView {
	private static final Logger log = Logger.getLogger(DutyContainer.class.getName());

	private ArrayList<Duty> duties = new ArrayList<>();
	private LinearLayout dutyLayout;

	/**
	 * @see android.view.View(Context)
	 */
	public DutyContainer(Context context) {
		super(context);
		dutyLayout = new LinearLayout(context);
		dutyLayout.setOrientation(LinearLayout.VERTICAL);
		addView(dutyLayout);
	}

	/**
	 * @see android.view.View(Context, AttributeSet)
	 */
	public DutyContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
		dutyLayout = new LinearLayout(context, attrs);
		dutyLayout.setOrientation(LinearLayout.VERTICAL);
		addView(dutyLayout);
	}

	/**
	 * @see android.view.View(Context, AttributeSet, int)
	 */
	public DutyContainer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		dutyLayout = new LinearLayout(context, attrs, defStyle);
		dutyLayout.setOrientation(LinearLayout.VERTICAL);
		addView(dutyLayout);
	}

	/**
	 * Adds a new duty to the DutyContainer at the end of the list.
	 *
	 * @param newDuty The new Duty to add
	 */
	public void addDuty(Duty newDuty) {
		log.info(String.format(InfoStrings.CONTAINER_ADD,
				DutyView.class.getSimpleName(), DutyContainer.class.getSimpleName()));

		duties.add(newDuty);

		DutyView dutyView = new DutyView(getContext());
		dutyView.setDuty(newDuty);
		dutyLayout.addView(dutyView);
	}

	/**
	 * Get the duties held by this DutyContainer
	 * @return An array of duties
	 */
	public Duty[] getDuties() {
		Duty[] temp = new Duty[duties.size()];
		return duties.toArray(temp);
	}
}
