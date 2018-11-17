package com.exercise.android.careergps.UIActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.exercise.android.careergps.Controller.RestController;
import com.exercise.android.careergps.Function.CallBackFunction;
import com.exercise.android.careergps.Item.User;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.BasicActivity.NoNavigationActivity;
import com.google.gson.Gson;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Benix on 17/11/2018.
 */

public class ProfileActivity extends NoNavigationActivity implements CallBackFunction {
    private RestController tpc;
    private Context mContext;
    private DrawerLayout mydrawer;
    private View progress_form;
    private ImageView pic_usricon;
    private TextView user_name;
    private TextView educationleveldesc;
    private TextView workexp;
    private TextView email;
    private TextView phone;
    private Gson gson = new Gson();
    private User user;
    private HashMap<String, String> data = new HashMap<>();

    private enum variable {
        u_id, user_name, email, phone_num, pwd, last_name, first_name, yob, gender, p_img, education, exp
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_profile);
        super.onCreate(savedInstanceState);
        mContext = this;
        mydrawer = findViewById(R.id.drawer_layout);
        progress_form = findViewById(R.id.progress_form);
        pic_usricon = findViewById(R.id.pic_usericon);
        user_name = findViewById(R.id.user_name);
        educationleveldesc = findViewById(R.id.educationleveldesc);
        workexp = findViewById(R.id.workexp);
        email = findViewById(R.id.email);
        phone = findViewById(R.id.phone);
        SharedPreferences prefs = getSharedPreferences("mprefs", MODE_PRIVATE);
        String restoredText = prefs.getString("user", null);
        user = gson.fromJson(restoredText, User.class);

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
        data.put("u_id", user.getU_id());
        tpc = new RestController(progress_form, mContext, mydrawer, "https://hackathon-718718.appspot.com/user2/getuser2", data, (CallBackFunction) mContext);
        tpc.execute();
    }

    @Override
    public void done(String result) {
        ArrayList<User> travelposts = new ArrayList<User>();
        try {
            JSONArray travelpostsary = new JSONArray(result);
            for (int i = 0; i < travelpostsary.length(); i++) {
                User onepost = new User(travelpostsary.getJSONObject(i).getString(variable.values()[0].name()), travelpostsary.getJSONObject(i).getString(variable.values()[1].name()), travelpostsary.getJSONObject(i).getString(variable.values()[2].name()), travelpostsary.getJSONObject(i).getString(variable.values()[3].name()), travelpostsary.getJSONObject(i).getString(variable.values()[4].name()), travelpostsary.getJSONObject(i).getString(variable.values()[5].name()), travelpostsary.getJSONObject(i).getString(variable.values()[6].name()), travelpostsary.getJSONObject(i).getString(variable.values()[7].name()), travelpostsary.getJSONObject(i).getString(variable.values()[8].name()), travelpostsary.getJSONObject(i).getString(variable.values()[9].name()), travelpostsary.getJSONObject(i).getString(variable.values()[10].name()), travelpostsary.getJSONObject(i).getString(variable.values()[11].name()));
                travelposts.add(onepost);
            }
            user_name.setText(travelposts.get(0).getUser_name());
            educationleveldesc.setText(travelposts.get(0).getEducation());
            workexp.setText(travelposts.get(0).getExp());
            phone.setText(travelposts.get(0).getPhone_num());
            email.setText(travelposts.get(0).getEmail());
        } catch (Exception e) {

        }
    }
}

