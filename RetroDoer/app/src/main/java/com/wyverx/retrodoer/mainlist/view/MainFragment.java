package com.wyverx.retrodoer.mainlist.view;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.mainlist.MainContract;
import com.wyverx.retrodoer.mainlist.presenter.MainPresenter;
import com.wyverx.retrodoer.mainlist.repository.MainRepository;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mMainPresenter;
    private RecyclerView mRecyclerView;
    private MainRecyclerViewAdapter.ListFragmentListener mListener;


    public MainFragment() {
    }


    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = MainPresenter.newInstance(this, MainRepository.newInstance());
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_list, container, false);

        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mMainPresenter.loadData();
        return mRecyclerView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainRecyclerViewAdapter.ListFragmentListener) {
            mListener = (MainRecyclerViewAdapter.ListFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement ListFragmentListener");
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void matchData(List<Post> list) {
        mRecyclerView.setAdapter(new MainRecyclerViewAdapter(list, mListener));
    }
}
