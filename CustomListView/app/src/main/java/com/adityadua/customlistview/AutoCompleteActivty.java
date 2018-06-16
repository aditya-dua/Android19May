package com.adityadua.customlistview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

/**
 * Created by AdityaDua on 10/06/18.
 */

public class AutoCompleteActivty extends AppCompatActivity {

    String [] colors ={
            "Red","Black","Blue","Brown"
    };

    AutoCompleteTextView autoCompleteTextView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.auto_complete_main);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,colors);
        autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

        autoCompleteTextView.setAdapter(arrayAdapter);
    }
}
