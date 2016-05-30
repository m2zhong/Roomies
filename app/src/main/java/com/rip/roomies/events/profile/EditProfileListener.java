package com.rip.roomies.events.profile;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.ProfileController;
import com.rip.roomies.functions.UpdateProfileFunction;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;

import java.util.logging.Logger;

/**
 * Created by VinnysMacOS on 5/29/16.
 */
public class EditProfileListener implements View.OnClickListener, UpdateProfileFunction {
    private static final Logger log = Logger.getLogger(EditProfileListener.class.getName());

    GenericActivity activity;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etEmail;
    private EditText etGroupDescription;

    public EditProfileListener(GenericActivity activity, EditText etFirstName, EditText etLastName, EditText etEmail, EditText etGroupDescription) {
        this.activity = activity;
        this.etFirstName = etFirstName;
        this.etLastName = etLastName;
        this.etEmail = etEmail;
        this.etGroupDescription = etGroupDescription;

    }

    @Override
    public void onClick(View v) {
        //populate the DB with the changes
        ProfileController.getController().updateProfile(this, etFirstName.getText().toString(), etLastName.getText().toString(), etEmail.getText().toString(), etGroupDescription.getText().toString());

    }

    @Override
    public void updateProfileFailure() {
        Toast.makeText(activity, "Something went wrong", Toast.LENGTH_LONG).show();

    }

    @Override
    public void updateProfileSuccess() {
        //trim the whitespace off all the Strings
        String firstname = etFirstName.getText().toString().trim();
        String lastname = etLastName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();

        //update the active user
        User.setActiveUser(new User(User.getActiveUser().getId(), firstname,
                lastname, User.getActiveUser().getUsername(), email, ""));

        //update active group
        Group.setActiveGroupDescription(etGroupDescription.getText().toString());

    }
}
