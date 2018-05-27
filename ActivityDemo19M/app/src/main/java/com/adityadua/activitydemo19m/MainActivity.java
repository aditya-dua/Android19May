package com.adityadua.activitydemo19m;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView sampleTextView;
    RelativeLayout relativeLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "In OnCreate()", Toast.LENGTH_SHORT).show();

        // The Id that you have passed in the findViewByID Method
        // this id gives you :: Int value
        // Since I know the value belongs to a TextView
        // I convert or typecast this value to a TextView
        // The object to which is assigned is of type TextView


        sampleTextView = (TextView) findViewById(R.id.textviewTV);

        sampleTextView.setText("My First Java Text");


        relativeLayout = (RelativeLayout) findViewById(R.id.activity_main);

        relativeLayout.setBackgroundResource(R.drawable.download);

        // By Identificing the element :

       /* try {
            Thread.sleep(2000);

            setContentView(R.layout.second_main);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }


    @Override
    protected void onStart() {
        super.onStart();

        Toast.makeText(this, "in onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "in onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "in onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "in onstop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "in on destroy", Toast.LENGTH_SHORT).show();
    }
}
