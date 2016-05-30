package com.rip.roomies.activities.profile;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.rip.roomies.R;
import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.events.profile.EditProfileListener;
import com.rip.roomies.events.profile.LeaveGroupListener;
import com.rip.roomies.models.Group;
import com.rip.roomies.models.User;

public class Profile extends GenericActivity implements View.OnClickListener {

    private TextView tvTapToEdit;
    private EditText etFirstName;
    private EditText etLastName;
    private EditText etEmail;
    private EditText etGroupDescription;
    private Button btChangePassword;
    private Button btSaveChanges;
    private Button btLeaveGroup;
    private User thisUser;
    private Group thisUsersGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //assures the keyboard only pops up when an edit text is clicked
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        //xml->java
        tvTapToEdit = (TextView) findViewById(R.id.settings_tap_hint);
        etFirstName = (EditText) findViewById(R.id.settings_firstname);
        etLastName = (EditText) findViewById(R.id.settings_lastname);
        etEmail = (EditText) findViewById(R.id.settings_email);
        etGroupDescription = (EditText) findViewById(R.id.settings_description);
        btChangePassword = (Button) findViewById(R.id.settings_changepassword);
        btSaveChanges = (Button) findViewById(R.id.settings_submitbtn);
        btLeaveGroup = (Button) findViewById(R.id.settings_leavebtn);

        //lock the editable fields
        etFirstName.setEnabled(false); etLastName.setEnabled(false);
        etEmail.setEnabled(false); etGroupDescription.setEnabled(false);

        //Load the information for this user
        thisUser = User.getActiveUser();
        thisUsersGroup = Group.getActiveGroup();

        if (thisUser != null && thisUsersGroup != null) {
            etFirstName.setText(thisUser.getFirstName());
            etLastName.setText(thisUser.getLastName());
            etEmail.setText(thisUser.getEmail());
            etGroupDescription.setText(thisUsersGroup.getDescription());
        }

        etFirstName.setBackgroundColor(Color.WHITE);
        etFirstName.setBackgroundColor(Color.WHITE);
        etLastName.setBackgroundColor(Color.WHITE);
        etEmail.setBackgroundColor(Color.WHITE);
        etGroupDescription.setBackgroundColor(Color.WHITE);


        //set the listeners for the leavegroup button/submit changes button
        btSaveChanges.setOnClickListener(new EditProfileListener(this, etFirstName, etLastName, etEmail, etGroupDescription));
        btLeaveGroup.setOnClickListener(new LeaveGroupListener(this));
        btChangePassword.setOnClickListener(this);


        tvTapToEdit.setOnClickListener(this);

    }


    /**
     * IS called when the taptoedit textview is pressed on this view
     *
     * @param v
     */
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.settings_tap_hint:

                //change background color to light gray
                etFirstName.setBackgroundColor(Color.LTGRAY);
                etLastName.setBackgroundColor(Color.LTGRAY);
                etEmail.setBackgroundColor(Color.LTGRAY);
                etGroupDescription.setBackgroundColor(Color.LTGRAY);

                etFirstName.setEnabled(true);
                etLastName.setEnabled(true);
                etEmail.setEnabled(true);
                etGroupDescription.setEnabled(true);
                break;
            case R.id.settings_changepassword:
                startActivity(new Intent(this, ChangePassword.class));
                break;
        }

    }
}
