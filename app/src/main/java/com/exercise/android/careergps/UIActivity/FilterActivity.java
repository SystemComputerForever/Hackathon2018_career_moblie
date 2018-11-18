package com.exercise.android.careergps.UIActivity;

/**
 * Created by Benix on 18/11/2018.
 */

import android.app.ActivityOptions;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.exercise.android.careergps.Adapter.CommentAdapter;
import com.exercise.android.careergps.Controller.RestController;
import com.exercise.android.careergps.Controller.RestController2;
import com.exercise.android.careergps.Function.CallBackFunction;
import com.exercise.android.careergps.Function.CallBackFunction2;
import com.exercise.android.careergps.Function.ConvertFunction;
import com.exercise.android.careergps.Function.FileHandler;
import com.exercise.android.careergps.Item.Comment;
import com.exercise.android.careergps.Item.Jobpost;
import com.exercise.android.careergps.Item.User;
import com.exercise.android.careergps.MyApplication;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.BasicActivity.NoNavigationActivity;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by Benix on 17/11/2018.
 */

public class FilterActivity extends NoNavigationActivity implements CallBackFunction, CallBackFunction2 {
    private RestController tpc;
    private RestController2 tpc2;
    private Context mContext;
    private EditText keyword;
    private Spinner industrydesc;
    private Spinner educationleveldesc;
    private Spinner workexp;
    private EditText minsalary;
    private EditText mazsalary;

    private Gson gson = new Gson();
    private String pid;

    private HashMap<String, String> data = new HashMap<>();
    public static final String chosen1 = "Apply";
    public static final String chosen2 = "CANCEL";
    private RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.acitivity_search);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        // pid = intent.getExtras().getString("p_id");
        keyword = findViewById(R.id.keyword);
        industrydesc = findViewById(R.id.industrydesc);
        educationleveldesc = findViewById(R.id.educationleveldesc);
        workexp = findViewById(R.id.workexp);
        minsalary = findViewById(R.id.minsalary);
        mazsalary = findViewById(R.id.maxsalary);
        mContext = this;
        String[] mTestArray = getResources().getStringArray(R.array.industry_ary);
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        mTestArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        industrydesc.setAdapter(spinnerArrayAdapter);
        mTestArray = getResources().getStringArray(R.array.education_ary);
        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        mTestArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        educationleveldesc.setAdapter(spinnerArrayAdapter2);

        mTestArray = getResources().getStringArray(R.array.experience_ary);
        ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        mTestArray); //selected item will look like a spinner set from XML
        spinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        workexp.setAdapter(spinnerArrayAdapter3);
    }


    @Override
    public void done(String result) {

    }

    @Override
    public void done2(String result) {


    }


    public void searchonclick(View v) {

        HashMap<String, String> commentdata = new HashMap<>();
        commentdata.put("jobtitle", keyword.getText().toString());
        commentdata.put("industrydesc", industrydesc.getSelectedItem().toString());
        commentdata.put("education", educationleveldesc.getSelectedItemPosition() + 1 + "");
        commentdata.put("experience", workexp.getSelectedItemPosition() + "");
        commentdata.put("minsalary", minsalary.getText().toString());
        commentdata.put("maxsalary", mazsalary.getText().toString());
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(commentdata);
        new FileHandler().saveFile("filter", json);
        Intent myIntent = new Intent(mContext, DashboardActivity.class);
        ActivityOptions options = ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
        mContext.startActivity(myIntent, options.toBundle());
       /* synchronized (mContext) {
            tpc = new RestController(progress_form, mContext, mydrawer, "https://hackathon-718718.appspot.com/comment2/addcomment", commentdata, null);
            tpc.execute();
        }*/
        //refresh();
    }
}
