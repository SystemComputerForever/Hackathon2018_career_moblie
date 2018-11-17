package com.exercise.android.careergps.Function;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/**
 * Created by Benix on 17/11/2018.
 */

public class ConvertFunction {

    public ConvertFunction() {

    }

    public String encodeHashMap(HashMap<String, String> data) {
        String senddata = "";
        if (data.size() > 0) {
            for (String key : data.keySet()) {
                try {
                    senddata += URLEncoder.encode(key, "UTF-8") + "=" + URLEncoder.encode(data.get(key), "UTF-8") + "&";
                } catch (UnsupportedEncodingException ex) {
                }
            }
            senddata = senddata.substring(0, senddata.length() - 1);
        }
        return senddata;
    }

}
