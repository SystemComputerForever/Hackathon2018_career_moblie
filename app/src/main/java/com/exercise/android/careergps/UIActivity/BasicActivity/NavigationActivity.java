package com.exercise.android.careergps.UIActivity.BasicActivity;

import android.app.ActionBar;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.exercise.android.careergps.MyApplication;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.DashboardActivity;
import com.exercise.android.careergps.UIActivity.FilterActivity;
import com.exercise.android.careergps.UIActivity.ProfileActivity;

/**
 * Created by Benix on 17/11/2018.
 */

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private Intent myIntent = null;
    private Context mContext;
    private ImageView imgicon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ImageView search = toolbar.findViewById(R.id.btn_search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, FilterActivity.class);
                ActivityOptions options = ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
                mContext.startActivity(myIntent, options.toBundle());
            }
        });
        mContext = this;
      /*  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        imgicon = navigationView.getHeaderView(0).findViewById(R.id.imageView_profileicon);
        Log.e("imgicon", imgicon.toString());
        imgicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("clickclcik", view.toString());
                Intent myIntent = new Intent(MyApplication.getAppContext(), ProfileActivity.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
                mContext.startActivity(myIntent, options.toBundle());
            }
        });
        ActionBar bar = getActionBar();
      //bar.setDisplayShowCustomEnabled(true);
    }

    public void toprofile(View v) {
        myIntent = new Intent(MyApplication.getAppContext(), ProfileActivity.class);
        ActivityOptions options =
                ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
        mContext.startActivity(myIntent, options.toBundle());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.dropdownmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.btn_search) {
            Intent myIntent = new Intent(mContext, FilterActivity.class);
            ActivityOptions options = ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
            mContext.startActivity(myIntent, options.toBundle());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        int id = item.getItemId();

        if (id == R.id.nav_allpost) {
            myIntent = new Intent(MyApplication.getAppContext(), DashboardActivity.class);
            ActivityOptions options =
                    ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
            mContext.startActivity(myIntent, options.toBundle());
            DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
        }

        return true;
    }


}
