package com.wyverx.retrodoer.mainlist.presenter;

import android.support.v7.widget.RecyclerView;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.mainlist.MainContract;
import com.wyverx.retrodoer.mainlist.repository.MainRepository;
import com.wyverx.retrodoer.mainlist.repository.RepositoryResults;

import java.util.List;

public class MainPresenter implements MainContract.Presenter {

    private MainContract.View mMainView;
    private MainContract.Repository mMainRepository;
    private RepositoryResults mResults;


    private MainPresenter(MainContract.View view, MainRepository repository) {
        mMainView = view;
        mMainRepository = repository;
        mResults = new RepositoryResults();
    }


    public static MainPresenter newInstance(MainContract.View view,
                                            MainRepository repository) {
        return new MainPresenter(view, repository);
    }


    @Override
    public void matchData(RecyclerView recyclerView) {
        mMainRepository.getDataFormApi(mResults);
        List<Post> list = mResults.getPostsList();
        mMainView.showData(recyclerView, list);
    }
}
