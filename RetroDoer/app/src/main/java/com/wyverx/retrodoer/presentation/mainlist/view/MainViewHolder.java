package com.wyverx.retrodoer.presentation.mainlist.view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;

public class MainViewHolder extends RecyclerView.ViewHolder {

    final View mView;
    final TextView mContentView;


    MainViewHolder(View view) {
        super(view);
        mView = view;
        mContentView = mView.findViewById(R.id.content);
    }


    void bind(Post post) {
        mContentView.setText(post.getPostTitle());
    }
}
