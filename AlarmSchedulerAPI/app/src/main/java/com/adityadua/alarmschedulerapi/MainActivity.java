package com.adityadua.alarmschedulerapi;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.ToggleButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ToggleButton toggleButton;
    TimePicker alarmTimePicker;
    TextView alarmTextView;
    Button stopBtn;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;
    private static  MainActivity inst;

    public static MainActivity getInst(){
        return inst;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alarmTextView = (TextView)findViewById(R.id.textView);
        alarmTimePicker = (TimePicker)findViewById(R.id.timePicker);
        stopBtn = (Button)findViewById(R.id.button);
        toggleButton = (ToggleButton)findViewById(R.id.toggleButton);

        alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        toggleButton.setOnClickListener(this);

    }


    public  void setText(String message){
        alarmTextView.setText(message);
    }

    @Override
    public void onClick(View view) {
        if(((ToggleButton)view).isChecked()){
            // We will have to turn on the Alarm
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY,alarmTimePicker.getCurrentHour());
            calendar.set(Calendar.MINUTE,alarmTimePicker.getCurrentMinute());

            Intent myIntent = new Intent(MainActivity.this,AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,myIntent,0);
            alarmManager.set(AlarmManager.RTC,calendar.getTimeInMillis(),pendingIntent);


        }else{
            alarmManager.cancel(pendingIntent);
            setText("  ");

        }
    }
}
