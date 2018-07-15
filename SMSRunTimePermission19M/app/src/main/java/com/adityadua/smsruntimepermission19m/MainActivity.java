package com.adityadua.smsruntimepermission19m;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button submitBtn;
    EditText ed1,ed2;
    TextView statusTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        submitBtn = (Button)findViewById(R.id.button2);
        ed1 = (EditText)findViewById(R.id.editText);
        ed2 = (EditText)findViewById(R.id.editText2);
        statusTV = (TextView)findViewById(R.id.textView2);

        /*
        Check For Permission
         */

        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){

            Toast.makeText(this, "Permission Not Granted !", Toast.LENGTH_SHORT).show();

            ActivityCompat.requestPermissions(this,new String []{Manifest.permission.SEND_SMS},123);
            submitBtn.setEnabled(true);

        }else{
            submitBtn.setEnabled(true);
            Toast.makeText(this, "Permission is Already Granted !", Toast.LENGTH_SHORT).show();
            statusTV.setText("Status : Permission Granted");
        }
        submitBtn.setOnClickListener(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode == 123){
            if(grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                statusTV.setText("Status : Permission Granted");
                submitBtn.setEnabled(true);
            }else{
                statusTV.setText("Status : Permission Not Granted");
                submitBtn.setEnabled(false);
            }

        }
    }


    @Override
    public void onClick(View view) {
        // On Click
        if(view.getId() == R.id.button2){
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(ed1.getText().toString(),null,ed2.getText().toString(),null,null);
            statusTV.setText("Status : Message Sent Successfully !");
        }
    }
}
