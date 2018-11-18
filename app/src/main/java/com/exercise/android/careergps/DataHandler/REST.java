package com.exercise.android.careergps.DataHandler;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.exercise.android.careergps.Function.ConvertFunction;
import com.exercise.android.careergps.MyApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Benix on 17/11/2018.
 */

public class REST {

    public String ClientData(String link, HashMap<String, String> data, String MethodType) throws IOException {

        String response = "";
        ConvertFunction cf = new ConvertFunction();
        if (!isOnline(MyApplication.getAppContext())) {
            return "Lost Connectivity";
        }
        if (!ResponseCodeCheck(link)) {
            return "Server Maintenance";
        }
        try {
            String encodeddata = cf.encodeHashMap(data);
            if (MethodType.equals("GET")) {
                link += "?" + encodeddata;

            }
            Log.e("Log", link);
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setConnectTimeout(3000);
            if (MethodType.equals("POST")) {
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(
                        conn.getOutputStream());
                wr.write(encodeddata);
                wr.flush();
                wr.close();
            }
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();
            conn.disconnect();
            return response;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    private boolean isOnline(Context mContext) {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    private boolean ResponseCodeCheck(String link) throws IOException {

        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setConnectTimeout(3000);
        connection.connect();

        int code = connection.getResponseCode();
        if (code == 200) {
            connection.disconnect();
            return true;
        }
        connection.disconnect();
        return false;
    }
}
