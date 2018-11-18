package com.exercise.android.careergps.Function;

import android.util.Log;

import com.exercise.android.careergps.MyApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by Benix on 17/11/2018.
 */

public class FileHandler {

    public FileHandler() {

    }

    public boolean saveFile(String filename, String data) {
        File f = new File(MyApplication.getAppContext().getFilesDir()+"/"+filename);
        FileOutputStream out = null;
        try {
            f.createNewFile();
            Log.e("Checkfile", f.getAbsolutePath());
            out = new FileOutputStream(f);
            out.write(data.getBytes());
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f.exists();

    }

    public String readFile(String filename) {
        File f = new File(MyApplication.getAppContext().getFilesDir()+"/"+filename);
        byte[] buf = new byte[1024];
        String str = "";
        FileInputStream in = null;
        try {
            in = new FileInputStream(f);
            int len = in.read(buf);
            str = new String(buf, 0, len);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public boolean deleteFile(String filename) {
        File f = new File(MyApplication.getAppContext().getFilesDir()+"/"+filename);
        if (f.exists()) {
            f.delete();
        }
        return f.exists();
    }

    public boolean isExist(String filename){
        File f = new File(MyApplication.getAppContext().getFilesDir()+"/"+filename);
        if (f.exists()) {
            return true;
        }
        return false;
    }

}
