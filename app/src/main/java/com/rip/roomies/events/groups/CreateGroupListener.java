package com.rip.roomies.events.groups;

import android.view.View;
import android.widget.EditText;

import com.rip.roomies.activities.GenericActivity;
import com.rip.roomies.models.Group;
import com.rip.roomies.views.UserContainer;

import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/2/2016.
 */
public class CreateGroupListener implements View.OnClickListener {
	private static final Logger log = Logger.getLogger(CreateGroupListener.class.getName());

	public CreateGroupListener(GenericActivity context, EditText name, EditText description,
	                           UserContainer container) {

	}

	@Override
	public void onClick(View v) {

	}

	public void createGroupFail() {

	}

	public void createGroupSuccess(Group group) {

	}
}
