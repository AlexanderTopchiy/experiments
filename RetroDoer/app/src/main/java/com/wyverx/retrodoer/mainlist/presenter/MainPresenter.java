package com.wyverx.retrodoer.mainlist.presenter;

import android.support.v7.widget.RecyclerView;

import com.wyverx.retrodoer.mainlist.MainContract;
import com.wyverx.retrodoer.mainlist.repository.MainRepository;
import com.wyverx.retrodoer.mainlist.view.MainRecyclerViewAdapter;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;
    private MainContract.Repository mMainRepository;


    private MainPresenter(MainContract.View view, MainRepository repository) {
        mMainView = view;
        mMainRepository = repository;
    }


    public static MainPresenter newInstance(MainContract.View view,
                                            MainRepository repository) {
        return new MainPresenter(view, repository);
    }


    @Override
    public void loadData(RecyclerView rv, MainRecyclerViewAdapter.ListFragmentListener listener) {
        mMainRepository.getDataFormApi(rv, listener);
    }
}
