package com.exercise.android.careergps.UIActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.exercise.android.careergps.Adapter.JobAdapter;
import com.exercise.android.careergps.Controller.RestController;
import com.exercise.android.careergps.Function.CallBackFunction;
import com.exercise.android.careergps.Function.FileHandler;
import com.exercise.android.careergps.Item.Jobpost;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.BasicActivity.NavigationActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benix on 17/11/2018.
 */

public class DashboardActivity extends NavigationActivity implements  CallBackFunction {

    private RestController tpc;
    private Context mContext;
    private DrawerLayout mydrawer;
    private View progress_form;
    private FileHandler fh = new FileHandler();
    private HashMap<String, String> data = new HashMap<>();
    ;
    private RecyclerView recyclerView;
    private enum variable {
        post_id, jobtitle, displayname, managerialleveldesc, shortdescription, fielddesc, subfield, industrydesc, minexp, maxexp, activationdate, educationleveldesc, salary, skills;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_dashboard);
        super.onCreate(savedInstanceState);
        mContext = this;
        mydrawer = findViewById(R.id.drawer_layout);
        progress_form = findViewById(R.id.progress_form);
       // new GetData().GetCountry();
        //you need to save the exist user here first
        // fh.saveFile("user",)
     /*  GridLayoutManager gl = new GridLayoutManager(this, 1);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        //  layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = findViewById(R.id.recyclerView_job);
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(gl); //設定 LayoutManager
        ArrayList<String> Dataset = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            Dataset.add(i + "");
        }
        Jobpost job = new Jobpost("","","","","","","","","","","","","","");
        ArrayList<Jobpost> j = new ArrayList<>();
        j.add(job);
        JobAdapter myAdapter = new JobAdapter(j, mContext);
        recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        GridLayoutManager gl = new GridLayoutManager(this, 2);
        recyclerView = findViewById(R.id.recyclerView_job);
        //  LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        //  layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(gl); //設定 LayoutManager
        refresh();
    }

    public void refresh() {
        tpc = new RestController(progress_form, mContext, mydrawer, "https://hackathon-718718.appspot.com/jobpost/getposts", data, (CallBackFunction) mContext);
        tpc.execute();
    }

    @Override
    public void done(String result) {
        Log.e("ouputresult:", result);
        ArrayList<Jobpost> travelposts = new ArrayList<Jobpost>();
        try {
            JSONArray travelpostsary = new JSONArray(result);
            for (int i = 0; i < travelpostsary.length(); i++) {
                Jobpost onepost = new Jobpost(travelpostsary.getJSONObject(i).getString(variable.values()[0].name()), travelpostsary.getJSONObject(i).getString(variable.values()[1].name()), travelpostsary.getJSONObject(i).getString(variable.values()[2].name()), travelpostsary.getJSONObject(i).getString(variable.values()[3].name()), travelpostsary.getJSONObject(i).getString(variable.values()[4].name()), travelpostsary.getJSONObject(i).getString(variable.values()[5].name()), travelpostsary.getJSONObject(i).getString(variable.values()[6].name()), travelpostsary.getJSONObject(i).getString(variable.values()[7].name()), travelpostsary.getJSONObject(i).getString(variable.values()[8].name()), travelpostsary.getJSONObject(i).getString(variable.values()[9].name()), travelpostsary.getJSONObject(i).getString(variable.values()[10].name()),travelpostsary.getJSONObject(i).getString(variable.values()[11].name()),travelpostsary.getJSONObject(i).getString(variable.values()[12].name()),travelpostsary.getJSONObject(i).getString(variable.values()[13].name()));
                travelposts.add(onepost);
            }
            Log.e("travelpost: ", travelpostsary.length() + "");
            // TravelPostAdapter myAdapter = new TravelPostAdapter(travelposts, mContext);
            // recyclerView.setAdapter(myAdapter); //設定 Adapter*/
            //  GridLayoutManager gl = new GridLayoutManager(this, 2);
            //  LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
            //  layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
            JobAdapter myAdapter = new JobAdapter(travelposts, mContext);
            recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Log.e("Show post", result);
    }
}
