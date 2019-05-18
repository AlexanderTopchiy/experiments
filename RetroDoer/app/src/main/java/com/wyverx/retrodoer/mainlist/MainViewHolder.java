package com.wyverx.retrodoer.mainlist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.dummy.DummyContent.DummyItem;

public class MainViewHolder extends RecyclerView.ViewHolder {

    final View mView;
    final TextView mContentView;


    MainViewHolder(View view) {
        super(view);
        mView = view;
        mContentView = view.findViewById(R.id.content);
    }


    @Override
    public String toString() {
        return super.toString() + " '" + mContentView.getText() + "'";
    }


    void bind(DummyItem item) {
        mContentView.setText(item.content);
    }
}
