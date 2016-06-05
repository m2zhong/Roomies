package com.rip.roomies.server;

import com.rip.roomies.util.SocketStrings;

import java.net.URISyntaxException;
import java.util.logging.Logger;

/**
 * Created by haotuusa on 5/30/16.
 */
public class ServerRequest {

	private static final Logger log = Logger.getLogger(ServerRequest.class.getName());


	public static void subscribToRoom(int groupId) throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.COMPLETION_LISTEN, groupId);
	}

	public static void subscribToMyTopic(int userId) throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.NOTIFICATION_LISTEN, userId);
	}
	/**
	 * send message to the server to retrieve password
	 * @param userId the user id
	 * @throws Exception if the database cannot be connected to or statement fails
	 */
	public static void passwordRetrieve(int userId, String userEmail) throws URISyntaxException {
		Server.getConnection().emit(SocketStrings.PASSWORD_RETRIEVE, userId, userEmail);
	}

	public static void completeDuty(String receiverName, String dutyName)throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.COMPLETE_DUTY, receiverName, dutyName);
	}

	public static void completeCommonGood(String receiverName, String csgName)throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.COMPLETE_CSG, receiverName, csgName);
	}

	public static void remindDuty(int receiverId, String dutyName)throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.NOTIFICATION_DUTY, receiverId, dutyName);
	}

	public static void remindCommonGood(int receiverId, String csgName)throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.NOTIFICATION_CSG, receiverId, csgName);
	}

	public static void remindBill(int receiverId, String ownerName,
	                              float amount, String description) throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.NOTIFICATION_BILL,
						receiverId, ownerName, amount, description);
	}

	public static void payBill(int receiverId, String oweeName,
	                              float amount, String description) throws URISyntaxException{
		Server.getConnection().emit(SocketStrings.NOTIFICATION_BILL,
				receiverId, oweeName, amount, description);
	}
	

	public static void refreshToken(int userID, String token) throws  URISyntaxException{
		Server.getConnection().emit(SocketStrings.REFRESH_TOKEN, userID, token);
	}

}
