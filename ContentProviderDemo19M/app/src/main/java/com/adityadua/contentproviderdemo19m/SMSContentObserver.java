package com.adityadua.contentproviderdemo19m;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.widget.Toast;

/**
 * Created by AdityaDua on 19/08/18.
 */

public class SMSContentObserver extends ContentObserver {

    Context context;
    Handler handler;

    public SMSContentObserver(Context c,Handler handler) {
        super(handler);
        context= c;
        this.handler = handler;
    }

    @Override
    public void onChange(boolean selfChange) {
        super.onChange(selfChange);

        Toast.makeText(context, "In Content Observer :: onChange()", Toast.LENGTH_SHORT).show();

        Uri uri = Uri.parse("content://sms/inbox");

        Cursor cursor = context.getContentResolver().query(uri,null,null,null,"date ASC");

        cursor.moveToLast();

        StringBuilder builder = new StringBuilder();

        builder.append("From :"+cursor.getString(cursor.getColumnIndex("address")));
        builder.append("Message :"+cursor.getString(cursor.getColumnIndex("body")));

        cursor.close();
        String str = builder.toString();
        handler.obtainMessage(1,str).sendToTarget();

    }
}
