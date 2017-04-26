package com.benjaminsklar.myandroid310;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

public class ConnectivityReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        if (activeNetwork != null){
            boolean isConnected = activeNetwork.isConnectedOrConnecting();

            Log.d("ConnectivityReceiver", "Connectivity: " + Boolean.toString(isConnected));

            boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;

            Log.d("isWiFi", Boolean.toString(isWiFi));

            boolean isMobile = activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE;

            Log.d("isMobile", Boolean.toString(isMobile));
        }
        else{
            Log.d("ConnectivityReceiver", "Connectivity: off");
        }

    }
}
