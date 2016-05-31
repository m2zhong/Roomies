package com.rip.roomies.events.notification;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.github.nkzawa.emitter.Emitter;
import com.rip.roomies.util.InfoStrings;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;
import java.util.logging.Logger;

/**
 * Created by haotuusa on 5/30/16.
 */
public class GetReminderBillListener implements Emitter.Listener{

	private static final Logger log = Logger.getLogger(GetReminderDutyListener.class.getName());

	Activity activity;

	/** Constructor
	 *  pass in activity to display toast for now
	 */
	public GetReminderBillListener(Activity activity){
		this.activity = activity;
	}

	/** Method
	 *  override call method from socket.io api's emitter listener
	 *  it gets the json object from server, needed to be retrieve manually
	 */
	@Override
	public void call(final Object... args) {

		activity.runOnUiThread(new Runnable() {
			@Override
			public void run() {

				log.info(String.format(Locale.US, InfoStrings.GET_REMINDER_BILL_LISTENER));
				JSONObject data = (JSONObject) args[0];
				String ownerName;
				float amount;
				String description;

				try {

					ownerName = data.getString("user");
					amount = (float)data.getDouble("amount");
					description = data.getString("description");
				} catch (JSONException e) {
					return;
				}

				//make toast to display the notification message for now
				Context context = activity.getApplicationContext();
				CharSequence text = "You still owe "+ ownerName + " " + amount + " dollars\n" +
						"Description: " + description;
				int duration = Toast.LENGTH_SHORT;
				Toast toast = Toast.makeText(context, text, duration);
				toast.show();

				//commented code later implement as notification manager when have time
//				sendNotification("remind you to do the " + duty);
			}
		});
	}

	//might use later
//	private void sendNotification(String messageBody) {
//		Intent intent = new Intent(activity, MainActivity.class);
//		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//				PendingIntent.FLAG_ONE_SHOT);
//
//		Uri defaultSoundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
//		NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
//				.setSmallIcon(R.drawable.ic_stat_ic_notification)
//				.setContentTitle("FCM Message")
//				.setContentText(messageBody)
//				.setAutoCancel(true)
//				.setSound(defaultSoundUri)
//				.setContentIntent(pendingIntent);
//
//		NotificationManager notificationManager =
//				(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//
//		notificationManager.notify(0 /* ID of notification */, notificationBuilder.build());
//	}
}
