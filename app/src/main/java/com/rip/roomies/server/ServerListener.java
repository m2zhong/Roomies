package com.rip.roomies.server;

import android.app.Activity;

import com.rip.roomies.events.notification.GetCompletionDutyListener;
import com.rip.roomies.events.notification.GetReminderBillListener;
import com.rip.roomies.events.notification.GetReminderDutyListener;
import com.rip.roomies.util.SocketStrings;

import java.net.URISyntaxException;

/**
 * Created by haotuusa on 5/30/16.
 */
public class ServerListener {

	public static void activateCompleteDuty(Activity activity) throws URISyntaxException {
		Server.activateNotification(SocketStrings.COMPLETE_DUTY,
				new GetCompletionDutyListener(activity));
	}

	public static void activateRemindDuty(Activity activity) throws URISyntaxException {
		Server.activateNotification(SocketStrings.NOTIFICATION_DUTY,
				new GetReminderDutyListener(activity));
	}

	public static void activateRemindBill(Activity activity) throws URISyntaxException {
		Server.activateNotification(SocketStrings.NOTIFICATION_BILL,
				new GetReminderBillListener(activity));
	}

//	public static void activateCompleteCommonGood(Activity activity) throws URISyntaxException {
//		Server.activateNotification(SocketStrings.COMPLETE_CSG,
//				new GetCompletionDutyListener(activity));
//	}
//
//	public static void activateRemindCommonGood(Activity activity) throws URISyntaxException {
//		Server.activateNotification(SocketStrings.NOTIFICATION_CSG,
//				new GetCompletionDutyListener(activity));
//	}
}
