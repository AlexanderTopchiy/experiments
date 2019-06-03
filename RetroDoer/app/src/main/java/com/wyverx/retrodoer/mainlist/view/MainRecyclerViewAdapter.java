package com.wyverx.retrodoer.mainlist.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Post} and makes a call to the
 * specified {@link ListFragmentListener}.
 */
public class MainRecyclerViewAdapter extends RecyclerView.Adapter<MainViewHolder> {

    public interface ListFragmentListener {
        void onClickListListener(Post item);
    }


    private List<Post> mValues;
    private final ListFragmentListener mListener;


    public MainRecyclerViewAdapter(List<Post> items, ListFragmentListener listener) {
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
                if (mListener != null) {
                    mListener.onClickListListener(item);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return mValues.size();
    }


    void updateDataSet(final List<Post> items) {
        this.mValues.clear();
        this.mValues.addAll(items);
        notifyDataSetChanged();
    }
}
