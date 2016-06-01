package com.rip.roomies.events.profile;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.ProfileController;
import com.rip.roomies.functions.ChangePassFunction;
import com.rip.roomies.util.Validation;

/**
 * Created by VinnysMacOS on 5/29/16.
 */
public class ChangePasswordListener implements View.OnClickListener, ChangePassFunction {

    GenericActivity activity;
    EditText previousPassword;
    EditText newPassword;

    public ChangePasswordListener(GenericActivity activity, EditText previousPassword, EditText newPassword) {
        this.activity = activity;
        this.previousPassword = previousPassword;
        this.newPassword = newPassword;
    }

    @Override
    public void onClick(View v) {
        //attempt logging in based of the previouspassword they entered

        //if it was successful
            //perform new password checks....display toast if failed and blank out new password edittext

        //else if it wasnt successful blank out the edit texts and return



        StringBuilder errMessage = new StringBuilder();
        errMessage.append(Validation.validate(newPassword, Validation.ParamType.Password, "Password"));

		/* Check if error occured*/
        if (errMessage.length() != 0) {
            String errMsg = errMessage.substring(0, errMessage.length() - 1);
            Toast.makeText(activity, errMsg, Toast.LENGTH_SHORT).show();
            newPassword.setText("");
            return;
        }



        //at this point new password works therefore update the password in the DB
        ProfileController.getController().changePassword(this, newPassword.getText().toString(), previousPassword.getText().toString());

    }

    @Override
    public void changePassSuccess() {
        Toast.makeText(activity, "Successfully changed password!!!", Toast.LENGTH_SHORT).show();
        activity.finish();
    }

    @Override
    public void changePassFailure() {
        String errorMessage = "Incorrect Previous Password";

        Toast.makeText(activity, errorMessage, Toast.LENGTH_LONG).show();
        previousPassword.setText("");
        newPassword.setText("");
    }


}
