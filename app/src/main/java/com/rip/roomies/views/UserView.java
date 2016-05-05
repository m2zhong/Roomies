package com.rip.roomies.views;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rip.roomies.models.User;

/**
 * This class is a displayable view that represents a User object. It will display
 * any necessary information as well as style once implemented.
 */
public class UserView extends LinearLayout {
    private User user;

    /**
     * Creates a new UserView based on the User object given.
     * @param context The activity that is displaying this object
     * @param user The user whose properties are to be displayed on the screen
     */
    public UserView(Context context, User user) {
        super(context);
        this.user = user;
        setupLayout();
    }

    /**
     * Get the User object that this class represents
     * @return The User object in question
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets up the layout for this UserView.
     */
    private void setupLayout() {
        setOrientation(LinearLayout.VERTICAL);

        TextView name = new TextView(getContext());
        TextView username = new TextView(getContext());
        TextView email = new TextView(getContext());

        name.setText(user.getFirstName() + " " + user.getLastName());
        username.setText(user.getUsername());
        email.setText(user.getEmail());

        addView(name);
        addView(username);
        addView(email);
    }
}
