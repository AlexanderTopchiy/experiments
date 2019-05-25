package com.wyverx.retrodoer.mainlist;

import android.support.v7.widget.RecyclerView;

import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.mainlist.repository.MainRepository;

import java.util.List;

public interface MainContract {

    interface View {

        void showData(RecyclerView recyclerView, List<Post> list);
    }


    interface Presenter {

        void matchData(RecyclerView recyclerView);
    }


    interface Repository {

        void getDataFormApi(MainRepository.ResultsCallback callback);
    }
}
