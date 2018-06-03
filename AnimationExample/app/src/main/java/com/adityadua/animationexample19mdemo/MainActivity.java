package com.adityadua.animationexample19mdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    Button startBtn;
    ImageView iView;
    private final String CLASS_NAME ="MainActivity";
    private String METHOD_NAME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        METHOD_NAME ="onCreate()";
        Log.i("Method Started",CLASS_NAME+" : "+METHOD_NAME+" :: STARTED");
        // i => Info Log , just for information
        // w => Warning Log
        // v => Verbose Logs
        // d => debug Logs
        // e= > Error Logs
        // wtf => what a terrible failure

        // 2 params : 1) Tag : Activity Name , function name : 23 Characters
        //            2) Info : Detailed Log

        /*Log.d("MainActivty.Java","My First Log");
        Log.w("MainActivty.Java","My First Log");
        Log.i("MainActivty.Java","My First Log");
        Log.v("MainActivty.Java","My First Log");
        Log.e("MainActivty.Java","My First Log");
        Log.wtf("MainActivty.Java","My First Log");*/

        textView = (TextView)findViewById(R.id.textView2);
        startBtn = (Button)findViewById(R.id.button);

        iView = (ImageView)findViewById(R.id.imageView);
        startBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                METHOD_NAME = "onClick";
                Log.i("Method STARTED",CLASS_NAME+" : "+METHOD_NAME+" :: STARTED");

                textView.setVisibility(TextView.VISIBLE);

                Animation fadeInAnimation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
                textView.startAnimation(fadeInAnimation);

                fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Toast.makeText(MainActivity.this, "Animation Started", Toast.LENGTH_SHORT).show();
                        startBtn.setText("END ANimation");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Toast.makeText(MainActivity.this, "Animation Ended", Toast.LENGTH_SHORT).show();
                        startBtn.setText("START ANimation");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });


                Log.i("Method ENDED",CLASS_NAME+" : "+METHOD_NAME+" :: ENDED");

            }
        });



        Log.i("Method ENDED",CLASS_NAME+" : "+METHOD_NAME+" :: ENDED");

    }


    public void scaleAnim(View v){

        ScaleAnimation scaleAnimation = new ScaleAnimation(1f,3.0f,1f,3.0f,iView.getWidth()/2f,iView.getHeight()/2f);
        scaleAnimation.setDuration(3000);



        iView.startAnimation(scaleAnimation);
        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                Toast.makeText(MainActivity.this, "Animation Started", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Toast.makeText(MainActivity.this, "Animation Ended", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    @Override
    protected void onPause() {
        METHOD_NAME = "onPause";
        Log.i("Method STARTED",CLASS_NAME+" : "+METHOD_NAME+" :: STARTED");
        super.onPause();

        Log.i("Method ENDED",CLASS_NAME+" : "+METHOD_NAME+" :: ENDED");
    }
}
