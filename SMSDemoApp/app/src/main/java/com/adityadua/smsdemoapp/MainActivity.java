package com.adityadua.smsdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phone,msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phone = (EditText)findViewById(R.id.editText);
        msg = (EditText)findViewById(R.id.editText2);

    }

    public void sendSMS(View v){
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phone.getText().toString(),null,msg.getText().toString(),null,null);

    }
}
