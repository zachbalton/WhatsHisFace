package com.skylarkingstudios.whatshisface.util;

import android.content.Context;
import android.net.ConnectivityManager;

public class NetworkUtil {

    public static boolean isConnected(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        return (connectivityManager.getActiveNetworkInfo() != null);
    }

}
