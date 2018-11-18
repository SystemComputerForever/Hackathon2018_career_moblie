package com.exercise.android.careergps.Adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.exercise.android.careergps.Item.Comment;
import com.exercise.android.careergps.Item.Jobpost;
import com.exercise.android.careergps.MyApplication;
import com.exercise.android.careergps.R;
import com.exercise.android.careergps.UIActivity.JobActivity;

import java.util.ArrayList;

/**
 * Created by Benix on 17/11/2018.
 */

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private ArrayList<Comment> data;
    private Context mContext;

    public CommentAdapter(ArrayList<Comment> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public CommentAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listitem_comment, parent, false);
        //     ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        //  layoutParams.width = ((Activity) parent.getContext()).getWindowManager().getDefaultDisplay().getWidth() / 3;
        //  view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.position.setText(data.get(position).getPosition());
        holder.department.setText(data.get(position).getDepartment());
        holder.educationleveldesc.setText(data.get(position).getEducationleveldesc());
        holder.workexp.setText(data.get(position).getWorkexp());
        holder.add_content.setText(data.get(position).getContent());
        holder.post_datetime.setText(data.get(position).getCreated_date());
        /*holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, JobActivity.class);
                myIntent.putExtra("p_id", data.get(position).getId());
                ActivityOptions options = ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
                mContext.startActivity(myIntent, options.toBundle());
            }
        });*/
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
        TextView position;
        TextView department;
        TextView educationleveldesc;
        TextView workexp;
        TextView add_content;
        TextView post_datetime;


        ViewHolder(View v) {
            super(v);
            position = v.findViewById(R.id.position);
            department = v.findViewById(R.id.department);
            educationleveldesc = v.findViewById(R.id.educationleveldesc);
            workexp = v.findViewById(R.id.workexp);
            add_content = v.findViewById(R.id.content);
            post_datetime = v.findViewById(R.id.post_datetime);
        }
    }
}
