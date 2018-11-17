package com.exercise.android.careergps.UIActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;

import com.exercise.android.careergps.Controller.RestController;
import com.exercise.android.careergps.Function.CallBackFunction;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.BasicActivity.NoNavigationActivity;

/**
 * Created by Benix on 17/11/2018.
 */

public class ProfileActivity extends NoNavigationActivity implements CallBackFunction {
    private RestController tpc;
    private Context mContext;
    private DrawerLayout mydrawer;
    private View progress_form;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_profile);
        super.onCreate(savedInstanceState);
        mContext = this;
        mydrawer = findViewById(R.id.drawer_layout);
        progress_form = findViewById(R.id.progress_form);
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

    public void refresh() {
        //tpc = new RestController(progress_form, mContext,  drawer);
        //tpc.execute();
    }

    @Override
    public void done(String result) {

    }
}

