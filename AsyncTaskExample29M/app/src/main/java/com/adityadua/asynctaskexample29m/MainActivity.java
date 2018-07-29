package com.adityadua.asynctaskexample29m;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView iv;
    Button loadIcon,anotherButton;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView)findViewById(R.id.imageView);
        loadIcon = (Button)findViewById(R.id.button);
        anotherButton = (Button)findViewById(R.id.button2);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);


        loadIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new LoadIcon().execute(R.drawable.android_image);
            }
        });
        
        anotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "I'm Working !!!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    // Aysnc Task ::::

    class LoadIcon extends AsyncTask<Integer,Integer,Bitmap>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(ProgressBar.VISIBLE);
        }

        @Override
        protected Bitmap doInBackground(Integer... integers) {
            Bitmap bmp = BitmapFactory.decodeResource(getResources(),integers[0]);

            for(int i=0;i<10;i++){
                try{
                    Thread.sleep(1000);
                    publishProgress(i*10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return bmp;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            progressBar.setProgress(values[0]);
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            progressBar.setVisibility(ProgressBar.INVISIBLE);
            iv.setImageBitmap(bitmap);
        }
    }



}
