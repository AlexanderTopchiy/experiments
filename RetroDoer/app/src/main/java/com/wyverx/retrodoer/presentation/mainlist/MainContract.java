package com.wyverx.retrodoer.presentation.mainlist;

import com.wyverx.retrodoer.data.models.Post;

import java.util.List;

public interface MainContract {

    interface View {

        void matchData(List<Post> list);
    }


    interface Presenter {

        void loadData();
    }
}
