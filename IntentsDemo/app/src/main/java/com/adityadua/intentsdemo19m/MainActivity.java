package com.adityadua.intentsdemo19m;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText username,password;
    Button signinBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText)findViewById(R.id.UNeditText);
        password = (EditText) findViewById(R.id.PWDeditText);

        signinBtn = (Button)findViewById(R.id.button);


        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userN = username.getText().toString();
                String pwd = password.getText().toString();


                if(userN.equalsIgnoreCase("abc") && pwd.equals("ABC")){
                    // Start my Intent Code

                    // Intent has 2 params :
                    // 1. Param is your the Activity from where your intent is triggered
                    // 2. Your target Activity
                    // 1. You pas the context with Current activity
                    // 2. The target activty is a class file which is compiled from the
                    // .java

                    // How do I pass the data from 1 page to other
                    // To pass the data : you have 2 ways
                    // First way is use of Bundle


                    Intent newActivtityIntent = new Intent(MainActivity.this,
                            ProfileActivity.class);
                    Bundle b = new Bundle();
                    b.putString("userName",userN);
                    b.putString("Email","aditya.dua@aditya.com");
                    newActivtityIntent.putExtras(b);
                    //newActivtityIntent.putExtra("username",userN);
                    startActivity(newActivtityIntent);
                    //startService()

                }
            }
        });

    }
}
