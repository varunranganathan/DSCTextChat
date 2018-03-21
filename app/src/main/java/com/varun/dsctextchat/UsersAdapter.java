package com.varun.dsctextchat;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vvvro on 3/21/2018.
 */

public class UsersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<TextChatUser> mDataset;
    Context context;

    public UsersAdapter(ArrayList<TextChatUser> d, Context c){
        mDataset = d;
        context = c;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.user_layout, parent, false);

        UserHolder userHolder = new UserHolder(v);
        return userHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final TextChatUser user = mDataset.get(position);
        UserHolder userHolder = (UserHolder) holder;
        userHolder.userName.setText(user.getUserName());
        userHolder.userID.setText(user.getUid());

        userHolder.userName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MessageActivity.class);
                intent.putExtra("uid", user.getUid());
                context.startActivity(intent);
            }
        });
    }
}
