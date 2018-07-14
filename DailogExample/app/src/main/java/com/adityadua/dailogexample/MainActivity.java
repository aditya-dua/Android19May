package com.adityadua.dailogexample;

import android.content.DialogInterface;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

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

    @Override
    public void onBackPressed() {
        showExitDialog();
        //super.onBackPressed();

    }

    private void showExitDialog(){

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Exit The App");
        alertDialogBuilder.setMessage("Are you sure you want to exit");

        alertDialogBuilder.setPositiveButton("Yes , Exit !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Exiting the APp", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        alertDialogBuilder.setNegativeButton("Continue Using the App", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Conitune using the app", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDailog = alertDialogBuilder.create();
        alertDailog.show();

    }
}
