package com.adityadua.webservicesexample19m.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by AdityaDua on 18/08/18.
 */

public class CallAddr extends AsyncTask<String,Void,String> {

    Context context;
    String result="";
    FormEncodingBuilder formBody;
    String url;
    OnWebServiceResult resultListener;
    CommonUtilities.SERVICE_TYPE service_type;
    Request request;

    public Request getRequest() {
        return request;
    }

    public CallAddr(Context context, String url, FormEncodingBuilder formBody, CommonUtilities.SERVICE_TYPE service_type, OnWebServiceResult resultListener) {
        this.context = context;
        this.url = url;
        this.formBody = formBody;
        this.service_type = service_type;
        this.resultListener = resultListener;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(String... params) {
        OkHttpClient client = new OkHttpClient();
        client.setConnectTimeout(120, TimeUnit.SECONDS);
        client.setReadTimeout(120,TimeUnit.SECONDS);

        RequestBody body = formBody.build();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Log.d("Call Addr","Url :"+url+" :: Request ::"+request+" ::Params::");
        try{

            Response response = client.newCall(request).execute();
            if(!response.isSuccessful()){
                result = response.toString();
            }

            result = response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        resultListener.getWebResponse(s,service_type);

    }
}
