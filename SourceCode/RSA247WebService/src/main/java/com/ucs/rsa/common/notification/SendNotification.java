/*
 * Copy rights @ 2016, Uniqueware Consulting Pvt Ltd
 */
package com.ucs.rsa.common.notification;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Sender;


/**
 * @author Gururaj A M
 * @version 1.0
 * 
 *          The Class SendNotification.
 */
public class SendNotification
{

	/** The Constant SENDER_ID. */
	private static final String SENDER_ID = "AIzaSyCCbSAuWNM7p0U8pHLQq3I4JR5xQsM5XJ8";

	/**
	 * Send notification data.
	 *
	 * @param deviceId
	 *           the device id
	 * @param notifiyMessage
	 *           the notifiy message
	 * @return the string
	 */
	public String sendNotificationData(ArrayList<String> deviceId, String notifiyMessage)
	{
		String status = null;
		Sender sender = new Sender(SENDER_ID);

		// This Message object will hold the data that is being transmitted
		// to the Android client devices.  For this demo, it is a simple text
		// string, but could certainly be a JSON object.
		Message message = new Message.Builder().addData("message", notifiyMessage).collapseKey("").timeToLive(30)
				.delayWhileIdle(true).build();
		try
		{
			// use this for multicast messages.  The second parameter
			// of sender.send() will need to be an array of register ids.
			MulticastResult result = sender.send(message, deviceId, deviceId.size());

			if (result.getResults() != null)
			{
				int canonicalRegId = result.getCanonicalIds();
				System.out.println(canonicalRegId);
				if (canonicalRegId != 0)
				{
					Calendar cal = Calendar.getInstance();
					SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
					String time = sdf.format(cal.getTime());
					System.out.println("Send");
					status = "Send Notofication," + time;
				}
			}
			else
			{
				int error = result.getFailure();
				System.out.println("Broadcast failure: " + error);
				status = "Failure";
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return status;

	}

}
