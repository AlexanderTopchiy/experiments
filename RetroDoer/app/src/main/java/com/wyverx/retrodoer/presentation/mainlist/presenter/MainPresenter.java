package com.wyverx.retrodoer.presentation.mainlist.presenter;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.presentation.mainlist.MainContract;
import com.wyverx.retrodoer.data.repository.MainRepository;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, MainRepository.ResponseCallback {

    private MainContract.View mMainView;
    private MainRepository mMainRepository;


    private MainPresenter(MainContract.View view, MainRepository repository) {
        mMainView = view;
        mMainRepository = repository;
    }


    public static MainPresenter newInstance(MainContract.View view,
                                            MainRepository repository) {
        return new MainPresenter(view, repository);
    }


    @Override
    public void loadData() {
        mMainRepository.getDataFromApi(this);
    }


    @Override
    public void onSuccess(List<Post> list) {
        mMainView.matchData(list);
    }
}
