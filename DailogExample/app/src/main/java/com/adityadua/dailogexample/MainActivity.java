package com.adityadua.dailogexample;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends FragmentActivity {


    Button dButton;
    FragmentManager fm = getSupportFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dButton = (Button)findViewById(R.id.button);

        dButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DFragment dFragment= new DFragment();
                dFragment.show(fm,"D Fragment");
            }
        });

    }
}
