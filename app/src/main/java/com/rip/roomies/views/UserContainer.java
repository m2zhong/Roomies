package com.rip.roomies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.rip.roomies.models.User;
import com.rip.roomies.util.InfoStrings;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 * This class represents a container for multiple UserView objects that can
 * be displayed in a dynamic group.
 */
public class UserContainer extends ScrollView {
	private static final Logger log = Logger.getLogger(UserContainer.class.getName());

	private ArrayList<User> users = new ArrayList<>();
	private LinearLayout userLayout;

	/**
	 * @see android.view.View(Context)
	 */
	public UserContainer(Context context) {
		super(context);
		userLayout = new LinearLayout(context);
		addView(userLayout);
	}

	/**
	 * @see android.view.View(Context, AttributeSet)
	 */
	public UserContainer(Context context, AttributeSet attrs) {
		super(context, attrs);
		userLayout = new LinearLayout(context, attrs);
		addView(userLayout);
	}

	/**
	 * @see android.view.View(Context, AttributeSet, int)
	 */
	public UserContainer(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		userLayout = new LinearLayout(context, attrs, defStyle);
		addView(userLayout);
	}

	/**
	 * Adds a new user to the UserContainer at the end of the list.
	 *
	 * @param newUser The new User to add
	 */
	public void addUser(User newUser) {
		log.info(String.format(InfoStrings.CONTAINER_ADD,
				UserView.class.getSimpleName(), UserContainer.class.getSimpleName()));

		users.add(newUser);

		UserView userView = new UserView(getContext());
		userView.setUser(newUser);
		userLayout.addView(userView);
	}

	/**
	 * Get the users held by this UserContainer
	 * @return An array of users
	 */
	public User[] getUsers() {
		User[] temp = new User[users.size()];
		return users.toArray(temp);
	}
}
