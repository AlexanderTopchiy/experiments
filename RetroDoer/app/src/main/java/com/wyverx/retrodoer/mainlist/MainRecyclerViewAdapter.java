package com.wyverx.retrodoer.mainlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.mainlist.MainFragment.OnListFragmentInteractionListener;
import com.wyverx.retrodoer.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;


    public MainRecyclerViewAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
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
        final DummyItem mItem = mValues.get(position);
        holder.bind(mItem);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(mItem);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }
}
