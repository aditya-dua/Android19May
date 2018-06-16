package com.adityadua.intentsdemo19m;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by AdityaDua on 09/06/18.
 */

public class ProfileActivity extends AppCompatActivity {

    TextView proTV;
    Button supportBtn,websiteBtn,profileBtn;
    ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_page);

        //Intent i  = getIntent();
        //String userName = i.getStringExtra("username");
        //Bundle b = i.getBundleExtra("username");

        Bundle b = getIntent().getExtras();
        if(b== null){

        }else{
            String userName = b.getString("userName");
            String email=b.getString("Email");

            Toast.makeText(this,
                    "UserName is :"+userName+" and Email is :"+email,
                    Toast.LENGTH_SHORT)
                    .show();

            proTV = (TextView)findViewById(R.id.profiletv);

            proTV.setText(proTV.getText().toString()+" for User :"+userName);
            // To go to another activty ,
            // you dont need to create a new bundle
            // simply you pass the existing one
           // Intent i = new Intent(ProfileActivity.this,MainActivity.class);
           // i.putExtras(b);

        }

        supportBtn = (Button)findViewById(R.id.Sprtbutton);
        supportBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent : for calling the Intent which would call the number
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9876543210"));
                //Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:9876543210"));

                startActivity(i);
            }
        });

        websiteBtn = (Button)findViewById(R.id.WBSbutton);
        websiteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.acadgild.com"));
                startActivity(i);
            }
        });

        profileBtn = (Button)findViewById(R.id.profilebutton);
        imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ic_launcher);
        profileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i,100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                Bundle imageBundle = data.getExtras();
                Bitmap imageBMP = (Bitmap) imageBundle.get("data");

                imageView.setImageBitmap(imageBMP);
            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "User Cancelled the operation", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
