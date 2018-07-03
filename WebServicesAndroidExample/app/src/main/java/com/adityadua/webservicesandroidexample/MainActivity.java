package com.adityadua.webservicesandroidexample;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    String result;
    String name[] = new String[10];

    TextView statusTV;
    ListView lv;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView)findViewById(R.id.listView1);

        statusTV   = (TextView)findViewById(R.id.statusTextView);

    }

    public void callWSBtnClicked(View v){

        String url = "https://api.themoviedb.org/3/movie/550?api_key=17d99bf38e7ffbebabfc4d9713b679a8";
        new MyAsynTask().execute(url);



    }

    class MyAsynTask extends AsyncTask<String,Integer,String>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "In onPre Execute", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... strings) {
            // So Request will be build here
            OkHttpClient client = new OkHttpClient();
            client.setReadTimeout(120, TimeUnit.SECONDS);
            client.setConnectTimeout(120,TimeUnit.SECONDS);

            FormEncodingBuilder formBuilder = new FormEncodingBuilder();
            formBuilder.add("page","1");

            RequestBody body = formBuilder.build();
            Request request = new Request.Builder()
                    .url(strings[0])
                    .build();
            Log.d("URL is ::",strings[0]);


            try{
                Response response = client.newCall(request).execute();

                if(response.isSuccessful()){
                    result = response.toString();
                    
                    if(result.equals("")||result.equalsIgnoreCase("null") || result.length() == 0){
                        Toast.makeText(MainActivity.this, "Error In Sending Request", Toast.LENGTH_SHORT).show();
                    }
                    result = response.body().string();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Toast.makeText(MainActivity.this, "In POST Execute", Toast.LENGTH_SHORT).show();

            try {
                JSONObject jObj = new JSONObject(s);
                JSONArray jArr = jObj.getJSONArray("production_companies");

                Log.d("Array For jArr",jArr.toString());

                JSONObject iJOBJ;
                for(int i=0;i<jArr.length();i++){
                    iJOBJ = jArr.getJSONObject(i);
                    Log.d("Array For i",i+ " "+iJOBJ.toString());

                    name[i] = iJOBJ.getString("name");
                }

                statusTV.setText(name[0]);
                arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,name);
                if(lv == null){
                    Toast.makeText(MainActivity.this, "List Value is NULL", Toast.LENGTH_SHORT).show();
                }

                lv.setAdapter(arrayAdapter);

            }catch (JSONException je){
                je.printStackTrace();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
