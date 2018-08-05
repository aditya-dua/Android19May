package com.adityadua.broadcastreciver19mdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.widget.Toast;

/**
 * Created by AdityaDua on 04/08/18.
 */

public class ExampleBroadcastReciver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        Toast.makeText(context, "Broadcast Fired For Action :"+action, Toast.LENGTH_SHORT).show();

        // Now lets create a Notification :

        NotificationCompat.Builder nBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(context.getApplicationContext())
                .setContentText("Notification For Action :"+action)
                .setContentTitle("Date & Time Changes")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true);

        Intent resultIntent = new Intent(context,MainActivity.class);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(context.getApplicationContext());
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(resultIntent);

        PendingIntent PI = PendingIntent.getActivity(context,0,resultIntent,0);
        nBuilder.setContentIntent(PI);

        NotificationManager nm = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(100,nBuilder.build());
    }
}
