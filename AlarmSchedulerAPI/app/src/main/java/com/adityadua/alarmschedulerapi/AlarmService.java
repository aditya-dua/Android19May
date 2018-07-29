package com.adityadua.alarmschedulerapi;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by AdityaDua on 29/07/18.
 */

public class AlarmService extends IntentService {

    private NotificationManager alarmNotificationManager;

    public AlarmService(String name) {
        super("AlarmService");
    }
    public AlarmService() {
        super("AlarmService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sendNotification("Wake Up Alarm");
    }

    private void sendNotification(String message){

        alarmNotificationManager = (NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        PendingIntent contentIntent = PendingIntent.getActivity(this,0,new Intent (this,MainActivity.class),0);


        NotificationCompat.Builder alarmNotifcationBuilder = new NotificationCompat.Builder(this)
                .setContentTitle("Alarm")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText(message)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message));

        alarmNotifcationBuilder.setContentIntent(contentIntent);
        alarmNotificationManager.notify(1,alarmNotifcationBuilder.build());
        Log.d("sendNotification","Notification Sent");


    }
}
