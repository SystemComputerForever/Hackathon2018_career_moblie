package com.exercise.android.careergps.UIActivity;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.Button;

import com.exercise.android.careergps.Controller.RestController;
import com.exercise.android.careergps.Function.CallBackFunction;
import com.exercise.android.careergps.Item.Jobpost;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.BasicActivity.NoNavigationActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benix on 17/11/2018.
 */

public class JobActivity extends NoNavigationActivity implements CallBackFunction {
    private RestController tpc;
    private Context mContext;
    private DrawerLayout mydrawer;
    private View progress_form;
    private Button btn_join;
    private HashMap<String, String> data = new HashMap<>();
    public static final String chosen1 = "Join now";
    public static final String chosen2 = "CANCEL APPLICATION";

    private enum variable {
        id, jobtitletext, displayname, managerialleveldesc, shortdescription, fielddesc, subfield, industrydesc, minexp, maxexp, activationdate, educationleveldesc, salary, skill
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_job);
        super.onCreate(savedInstanceState);
        btn_join = findViewById(R.id.btn_join);
        mContext = this;
        mydrawer = findViewById(R.id.drawer_layout);
        progress_form = findViewById(R.id.progress_form);
        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog mydialog = new Dialog(mContext, R.style.Theme_AppCompat_DayNight_Dialog);
                switch (btn_join.getText().toString()) {
                    case chosen1:
                        mydialog.setContentView(R.layout.popup);
                        btn_join.setText("CANCEL APPLICATION");
                        break;
                    case chosen2:
                        mydialog.setContentView(R.layout.popup2);
                        btn_join.setText("Join now");
                        break;
                    default:
                        break;
                }

                mydialog.show();
                addTransparency(mydialog);
                //    btn_join.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mydialog.dismiss();
                    }
                }, 800);
            }
        });
       /* RecyclerView recyclerView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> Dataset = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
        {
            Dataset.add(i + "");
        }
        MyAdapter myAdapter = new MyAdapter(myDataset);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); 設定此 layoutManager 為垂直堆疊

                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST)); //設定分割線
        recyclerView.setLayoutManager(layoutManager); //設定 LayoutManager
        recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        refresh();
    }

    public void addTransparency(Dialog mydialog) {
        mydialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void refresh() {
        tpc = new RestController(progress_form, mContext, mydrawer, "https://hackathon-718718.appspot.com/plans/getplanbyid", data, (CallBackFunction) mContext);
        tpc.execute();
    }

    @Override
    public void done(String result) {
        ArrayList<Jobpost> travelposts = new ArrayList<Jobpost>();
        try {
            JSONArray travelpostsary = new JSONArray(result);
            for (int i = 0; i < travelpostsary.length() - 1; i++) {
                Jobpost onepost = new Jobpost(travelpostsary.getJSONObject(i).getString(variable.values()[0].name()), travelpostsary.getJSONObject(i).getString(variable.values()[1].name()), travelpostsary.getJSONObject(i).getString(variable.values()[2].name()), travelpostsary.getJSONObject(i).getString(variable.values()[3].name()), travelpostsary.getJSONObject(i).getString(variable.values()[4].name()), travelpostsary.getJSONObject(i).getString(variable.values()[5].name()), travelpostsary.getJSONObject(i).getString(variable.values()[6].name()), travelpostsary.getJSONObject(i).getString(variable.values()[7].name()), travelpostsary.getJSONObject(i).getString(variable.values()[8].name()), travelpostsary.getJSONObject(i).getString(variable.values()[9].name()), travelpostsary.getJSONObject(i).getString(variable.values()[10].name()), travelpostsary.getJSONObject(i).getString(variable.values()[11].name()), travelpostsary.getJSONObject(i).getString(variable.values()[12].name()), travelpostsary.getJSONObject(i).getString(variable.values()[13].name()));
                travelposts.add(onepost);
            }
            // TravelPostAdapter myAdapter = new TravelPostAdapter(travelposts, mContext);
            // recyclerView.setAdapter(myAdapter); //設定 Adapter*/

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
