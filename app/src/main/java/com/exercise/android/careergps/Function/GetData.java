package com.exercise.android.careergps.Function;

import android.util.Log;

import com.exercise.android.careergps.Controller.RestController;
import com.exercise.android.careergps.MyApplication;

import java.io.File;
import java.util.HashMap;

/**
 * Created by Benix on 17/11/2018.
 */

public class GetData implements CallBackFunction{
    private FileHandler fh = new FileHandler();
    private String filename = "";
    private RestController tpc;
    private HashMap<String, String> data = new HashMap<>();

    public GetData() {

    }

    public void GetCountry() {
        filename = "country";
        tpc = new RestController(null, null, null, "https://hackathon-718718.appspot.com/location/countries", data, this);
        tpc.execute();
    }

    @Override
    public void done(String result) {
        File directory = new File(MyApplication.getAppContext().getFilesDir()+"/rawdata");
        Log.e("Checkdirectory", directory.getAbsolutePath());
        if (!directory.exists())
            directory.mkdir();
        fh.saveFile(MyApplication.getAppContext().getFilesDir()+"/rawdata/" + filename, result);
    }
}
