package com.adityadua.contentproviderdemo19m;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    SMSContentObserver contentObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textViewMessage);
        contentObserver = new SMSContentObserver(this,handler);

        Uri uri = Uri.parse("content://sms/inbox");

        getContentResolver().registerContentObserver(uri,true,contentObserver);

    }

    Handler handler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            String str = (String)msg.obj;
            textView.setText(str);
            String otp = fetchOTP(str);

            Toast.makeText(MainActivity.this, "The OTP Read is::"+otp, Toast.LENGTH_SHORT).show();
        }
    };

    // Fetching the OTP from the Message in handler

    public static String fetchOTP(String inputMessage){
        String msgString = inputMessage.substring(inputMessage.indexOf("Message"),inputMessage.length());

        Pattern p = Pattern.compile("(\\d){6}");
        Matcher m = p.matcher(msgString);

        if(m.find()){
            return m.group(0);
        }
        return  "";
    }
}
