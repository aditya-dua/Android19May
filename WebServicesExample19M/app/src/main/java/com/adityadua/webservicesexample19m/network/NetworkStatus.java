package com.adityadua.webservicesexample19m.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

/**
 * Created by AdityaDua on 18/08/18.
 */

public class NetworkStatus {

    static Context context;
    private static NetworkStatus instance = new NetworkStatus();
    ConnectivityManager connectivityManager;
    boolean connected = false;

    public static NetworkStatus getInstance(Context con){
        context = con;
        return instance;
    }

    public boolean isOnline(Context con){

        try{
            connectivityManager = (ConnectivityManager)con.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


            connected = networkInfo !=null && networkInfo.isAvailable() && networkInfo.isConnected();

            return connected;
            
        }catch (Exception e){
            e.printStackTrace();
            Toast.makeText(con, "Check YOur Internet Connection & try again", Toast.LENGTH_SHORT).show();
        }

        return connected;
    }

}
