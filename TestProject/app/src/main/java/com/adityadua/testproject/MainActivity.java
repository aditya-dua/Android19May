package com.adityadua.testproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String role = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(role.equals("student")){
            setContentView(R.layout.student_main);
        }else if(role.equals("admin")){
            setContentView(R.layout.admin_main);
        }else if(role.equals("trainer")){
            setContentView(R.layout.activity_main);
        }else {
            setContentView(R.layout.error404);
        }


        Toast.makeText(this, "THis is my App : onCreate", Toast.LENGTH_SHORT).show();
    }



    @Override
    protected void onPause() {
        super.onPause();

        Toast.makeText(this, "in onPause", Toast.LENGTH_SHORT).show();
    }
}
