package com.adityadua.contentproviderdemo19m;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.widget.Toast;

/**
 * Created by AdityaDua on 19/08/18.
 */

public class SMSReceiver extends BroadcastReceiver {

    SMSContentObserver contentObserver;

    @Override
    public void onReceive(Context context, Intent intent) {

        Uri uri = Uri.parse("content://sms/inbox");
        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");
        cursor.moveToLast();

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("From :"+cursor.getString(cursor.getColumnIndex("address")));
        stringBuilder.append("Message :"+cursor.getString(cursor.getColumnIndex("body")));

        cursor.close();
        String str = stringBuilder.toString();

        //Toast.makeText(context, "The OTP is ::"+str, Toast.LENGTH_SHORT).show();
    }
}
