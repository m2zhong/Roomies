package com.rip.roomies.util;

/**
 * Created by haotuusa on 5/27/16.
 */
public class SocketStrings {

	//connection url
	public static final String SERVER_URL = "https://cse110-fcmtest.herokuapp.com";

	//Strings for all the event android side listen from and emit to server, name has to be exact
	public static final String COMPLETE_DUTY = "complete duty";
	public static final String NOTIFICATION_DUTY = "notification duty";
	public static final String COMPLETE_CSG = "complete common good";
	public static final String NOTIFICATION_CSG= "notification common good";

	//Strings for all the socket subscribtion android send to sever to join room
	public static final String NOTIFICATION_LISTEN =  "listen to notification";
	public static final String COMPLETION_LISTEN = "listen to completion";

}
