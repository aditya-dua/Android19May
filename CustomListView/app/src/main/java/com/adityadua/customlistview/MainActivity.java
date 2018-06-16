package com.adityadua.customlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String [] title ={
            "Android 5.0","Android 6.0","Android 7.0","Android 8.0"
    };

    String [] subTitle ={
            "Lollipop","Marshmallow","Nougat","Oreo"
    };

    Integer [] imgResId={
            R.drawable.android_lolipop,R.drawable.android_marshmallow,
            R.drawable.android_nougat,R.drawable.android_oreo
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyCustomAdapter adapter =
                new MyCustomAdapter(this,title,subTitle,imgResId);
        ListView list = (ListView)findViewById(R.id.customList);
        list.setAdapter(adapter);
    }
}
