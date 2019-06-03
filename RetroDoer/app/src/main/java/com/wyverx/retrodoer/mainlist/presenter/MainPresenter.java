package com.wyverx.retrodoer.mainlist.presenter;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.mainlist.MainContract;
import com.wyverx.retrodoer.mainlist.repository.MainRepository;

import java.util.List;

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
    public void loadData() {
        mMainRepository.getDataFromApi(this);
    }


    @Override
    public void onSuccess(List<Post> list) {
        mMainView.matchData(list);
    }
}
