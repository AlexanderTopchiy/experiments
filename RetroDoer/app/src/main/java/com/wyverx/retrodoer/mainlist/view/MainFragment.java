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
import com.wyverx.retrodoer.mainlist.MainContract;
import com.wyverx.retrodoer.mainlist.presenter.MainPresenter;
import com.wyverx.retrodoer.mainlist.repository.MainRepository;

/**
 * A fragment representing a list of Items.
 */
public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mMainPresenter;
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

        // Set the adapter
        RecyclerView recyclerView = (RecyclerView) view;
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mMainPresenter.loadData(recyclerView, mListener);
        return recyclerView;
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
}
