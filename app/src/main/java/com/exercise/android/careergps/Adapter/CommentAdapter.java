package com.exercise.android.careergps.Adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exercise.android.careergps.Item.Jobpost;
import com.exercise.android.careergps.MyApplication;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.JobActivity;

import java.util.ArrayList;

/**
 * Created by Benix on 17/11/2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private ArrayList<Jobpost> data;
    private Context mContext;

    public CommentAdapter(ArrayList<Jobpost> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carditem_job, parent, false);
        //     ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        //  layoutParams.width = ((Activity) parent.getContext()).getWindowManager().getDefaultDisplay().getWidth() / 3;
        //  view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.jobtitletext.setText(data.get(position).getjobtitle());
        holder.salary.setText(data.get(position).getSalary());
        holder.displayname.setText(data.get(position).getDisplayname());
        holder.activationdate.setText(data.get(position).getdate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, JobActivity.class);
                myIntent.putExtra("p_id", data.get(position).getId());
                ActivityOptions options = ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
                mContext.startActivity(myIntent, options.toBundle());
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView jobtitletext;
        TextView salary;
        TextView displayname;
        TextView activationdate;


        ViewHolder(View v) {
            super(v);
            jobtitletext = v.findViewById(R.id.jobtitletext);
            salary = v.findViewById(R.id.salary);
            displayname = v.findViewById(R.id.displayname);
            activationdate = v.findViewById(R.id.activationdate);
        }
    }
}
