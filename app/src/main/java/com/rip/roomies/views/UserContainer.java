package com.rip.roomies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.rip.roomies.models.User;

/**
 * This class represents a container for multiple UserView objects that can
 * be displayed in a dynamic group.
 */
public class UserContainer extends LinearLayout {
	/**
	 * @see android.view.View(Context)
	 */
	public UserContainer(Context context) {
		super(context);
	}

	/**
	 * @see android.view.View(Context, AttributeSet)
	 */
	public UserContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	/**
	 * @see android.view.View(Context, AttributeSet, int)
	 */
	public UserContainer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	/**
	 * Adds a new user to the UserContainer at the end of the list.
	 *
	 * @param newUser The new User to add
	 */
	public void addUser(User newUser) {
		UserView userView = new UserView(getContext());
		userView.setUser(newUser);
		addView(userView);
	}
}
