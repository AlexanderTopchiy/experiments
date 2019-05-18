package com.wyverx.retrodoer.mainlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.dummy.DummyContent.DummyItem;

public class MainViewHolder extends RecyclerView.ViewHolder {
    public final View mView;
    public final TextView mContentView;
    public DummyItem mItem;


    public MainViewHolder(View view) {
        super(view);
        mView = view;
        mContentView = view.findViewById(R.id.content);
    }


    @Override
    public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";
    }
}
