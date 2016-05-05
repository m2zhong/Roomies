package com.rip.roomies.views;

import android.content.Context;
import android.widget.LinearLayout;

import com.rip.roomies.models.User;

/**
 * This class represents a container for multiple UserView objects that can
 * be displayed in a dynamic group.
 */
public class UserContainer extends LinearLayout {
    /**
     * Creates a new default UserContainer.
     * @param context The activity that is displaying this View
     */
    public UserContainer(Context context) {
        super(context);
    }

    /**
     * Adds a new user to the UserContainer at the end of the list.
     * @param newUser The new User to add
     */
    public void addUser(User newUser) {
        UserView userView = new UserView(getContext(), newUser);
        addView(userView);
    }
}
