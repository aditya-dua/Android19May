package com.adityadua.menuexample28m;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    // Already a function is present in the actvity class


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();

        menuInflater.inflate(R.menu.my_home_menu,menu);
        menuInflater.inflate(R.menu.main,menu);
        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();

        if(menuId == R.id.profile){
            Toast.makeText(this, "Navigating the the OPTION in menu", Toast.LENGTH_SHORT).show();
        }
        if(menuId == R.id.Logout){
            Toast.makeText(this, "Logging you out", Toast.LENGTH_SHORT).show();
            this.finish();
        }
        if(menuId == R.id.visitWebsite){
            Intent openSite = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.acadgild.com"));
            startActivity(openSite);
        }
        if(menuId == R.id.shareFeedback){
            Intent i = new Intent(MainActivity.this,FeedbackActivity.class);
            startActivity(i);
        }




        return true;
    }
}
