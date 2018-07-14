package com.adityadua.widgetdemo19m;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;
import android.widget.Toast;

/**
 * Created by AdityaDua on 08/07/18.
 */

public class MyAppWidgetProvider extends AppWidgetProvider {

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for(int i=0;i<appWidgetIds.length;i++){
            int currentWidgetId = appWidgetIds[i];
            String url = "http://www.acadgild.com";

            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setData(Uri.parse(url));

            PendingIntent pendingIntent = PendingIntent.getActivity(context,0,intent,0);
            RemoteViews remoteViews  = new RemoteViews(context.getPackageName(),R.layout.activity_main);

            remoteViews.setOnClickPendingIntent(R.id.button,pendingIntent);
            appWidgetManager.updateAppWidget(currentWidgetId,remoteViews);

            Toast.makeText(context, "Widget has been added", Toast.LENGTH_SHORT).show();




        }

       // super.onUpdate(context, appWidgetManager, appWidgetIds);
    }
}
