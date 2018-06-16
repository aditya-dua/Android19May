package com.adityadua.listviewdemoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String [] country = {
            "India",
            "Nepal",
            "Sri Lanka",
            "BanglaDesh",
            "Pakistan"
    };

    String [] indiaCity={"Delhi","Lucknow","Noida","Gurgoan","Faridabad"};

    String [] nepalCity={"Kathmandu","Patan","Bharatpur"};

    String [] sriLankaCity = {"Colombo","Kandy","Galle"};



    ArrayAdapter<String> arrayAdapter,stateArrayAdapter;
    ListView listView,stateListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listview);
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),
                            android.R.layout.simple_list_item_1,country);

        stateListView = (ListView)findViewById(R.id.stateListView);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             *
             * @param adapterView => stateAdapter & array Adpater
             * @param view => which element inside the adpater is clicked
             * @param i => position of the element which is clicked
             * @param l => Row Id of the element which is clicked
             */

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Item Clicked is:"+country[i], Toast.LENGTH_SHORT).show();

                if(i==0){
                    // India
                    stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,indiaCity);
                }else if(i==1){
                    // Nepal
                    stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,nepalCity);
                }else if(i==2){
                    // Sri Lanka
                    stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,sriLankaCity);
                }else{
                    stateArrayAdapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,indiaCity);
                }

                stateListView.setAdapter(stateArrayAdapter);


            }
        });
    }


}
