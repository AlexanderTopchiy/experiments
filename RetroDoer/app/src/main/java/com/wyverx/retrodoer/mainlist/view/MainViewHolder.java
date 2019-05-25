package com.wyverx.retrodoer.mainlist.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;

public class MainViewHolder extends RecyclerView.ViewHolder {

    final View mItem;
    final TextView mContentView;


    MainViewHolder(View item) {
        super(item);
        mItem = item;
        mContentView = item.findViewById(R.id.content);
    }


    void bind(Post item) {
        mContentView.setText(item.getPostTitle());
    }
}
