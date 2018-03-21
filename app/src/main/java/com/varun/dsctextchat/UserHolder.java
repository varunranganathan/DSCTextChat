package com.varun.dsctextchat;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by vvvro on 3/21/2018.
 */

public class UserHolder extends RecyclerView.ViewHolder{
    public TextView userName;
    public TextView userID;

    public UserHolder(View itemView) {
        super(itemView);

        userName = itemView.findViewById(R.id.userName);
        userID = itemView.findViewById(R.id.uid);
    }
}
