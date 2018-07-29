package com.adityadua.alarmschedulerapi;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.content.WakefulBroadcastReceiver;

/**
 * Created by AdityaDua on 29/07/18.
 */

public class AlarmReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
       // MainActivity inst = MainActivity.getInst();
      //  inst.setText("Its Time To Wake Up");

        Uri alarmURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        if(alarmURI == null){
            alarmURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        }
        Ringtone ringtone = RingtoneManager.getRingtone(context,alarmURI);
        ringtone.play();


        ComponentName componentName = new ComponentName(context.getPackageName(),AlarmService.class.getName());

        startWakefulService(context,(intent.setComponent(componentName)));

        setResultCode(Activity.RESULT_OK);
    }
}
