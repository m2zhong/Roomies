package com.rip.roomies.events.groups;

import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.controllers.GroupController;
import com.rip.roomies.functions.CreateGroupFunction;
import com.rip.roomies.models.Group;
import com.rip.roomies.util.DisplayStrings;
import com.rip.roomies.util.InfoStrings;
import com.rip.roomies.views.UserContainer;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * This class represents the listener for when the "Create Group" button is pressed.
 */
public class CreateGroupListener implements View.OnClickListener, CreateGroupFunction {
	private static final Logger log = Logger.getLogger(CreateGroupListener.class.getName());

	private GenericActivity context;
	private EditText name;
	private EditText description;
	private UserContainer container;

	public CreateGroupListener(GenericActivity context, EditText name, EditText description,
	                           UserContainer container) {
		this.context = context;
		this.name = name;
		this.description = description;
		this.container = container;
	}

	@Override
	public void onClick(View v) {
		String errMsg = "";

		if (name.getText().toString().isEmpty()) {
			errMsg += String.format(Locale.US, DisplayStrings.MISSING_FIELD, "Name");
		}

		if (!errMsg.isEmpty()) {
			errMsg = errMsg.substring(0, errMsg.length() - 1);
			Toast.makeText(context, errMsg, Toast.LENGTH_SHORT).show();
			return;
		}

		log.info(InfoStrings.CREATEGROUP_EVENT);

		GroupController.getController().createGroup(this, name.getText().toString(),
				description.getText().toString());
	}

	@Override
	public void createGroupFail() {
		Toast.makeText(context, DisplayStrings.CREATE_GROUP_FAIL, Toast.LENGTH_LONG).show();
	}

	@Override
	public void createGroupSuccess(Group group) {
		Toast.makeText(context, String.format(Locale.US, DisplayStrings.CREATE_GROUP_SUCCESS,
				group.getName()), Toast.LENGTH_SHORT).show();

		log.info(String.format(Locale.US, InfoStrings.SWITCH_ACTIVITY_DELAYED,
				"[Home Class Goes Here]", DisplayStrings.TOAST_LONG_LENGTH));

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				context.toHome();
			}
		}, DisplayStrings.TOAST_SHORT_LENGTH);
	}
}
