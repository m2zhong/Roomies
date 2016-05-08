package com.rip.roomies.util;

import java.util.logging.Logger;

/**
 * Created by Kanurame on 5/8/2016.
 */
public class InfoStrings {
	private static final Logger log = Logger.getLogger(InfoStrings.class.getName());

	public static final String SWITCH_ACTIVITY = "Switching to activity %s";
	public static final String SWITCH_ACTIVITY_DELAYED = "Switching to activity %s after %d ms delay";

	public static final String DATABASE_CONNECT = "Connecting to the database...";
	public static final String DATABASE_QUERY = "Querying database: \"%s\"";

	public static final String CONTAINER_ADD = "Adding view %s to container %s";

	public static final String VIEW_SETUP = "Setting up view %s";
}
