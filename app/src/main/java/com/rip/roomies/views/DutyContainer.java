package com.rip.roomies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/**
 * Created by Kanurame on 5/19/2016.
 */
public class DutyContainer extends ScrollView {
	private LinearLayout dutyLayout;

	public DutyContainer(Context context) {
		super(context);
		dutyLayout = new LinearLayout(context);
		addView(dutyLayout);
	}

	public DutyContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
		dutyLayout = new LinearLayout(context, attrs);
		addView(dutyLayout);
	}

	public DutyContainer(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		dutyLayout = new LinearLayout(context, attrs, defStyleAttr);
		addView(dutyLayout);
	}
}
