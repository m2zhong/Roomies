package com.rip.roomies.functions;

import com.rip.roomies.models.Group;

/**
 * An interface designed for objects that need to be able to add users to a group.
 */
public interface AddUsersToGroupFunction {
	void addUsersToGroupFail();
	void addUsersToGroupSuccess(Group group);
}
