package com.wyverx.retrodoer.mainlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.mainlist.MainFragment.OnListFragmentInteractionListener;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Post} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private final List<Post> mValues;
    private final OnListFragmentInteractionListener mListener;


    public MainRecyclerViewAdapter(List<Post> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }


    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_main, parent, false);
        return new MainViewHolder(view);
    }


    @Override
    public void onBindViewHolder(final MainViewHolder holder, int position) {
        final Post item = mValues.get(position);
        holder.bind(item);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(item);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
