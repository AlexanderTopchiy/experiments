package com.wyverx.retrodoer.mainlist;

import android.support.v7.widget.RecyclerView;

import com.wyverx.retrodoer.mainlist.view.MainRecyclerViewAdapter;

public interface MainContract {

    interface View {

    }


    interface Presenter {

        void loadData(RecyclerView rv,
                      MainRecyclerViewAdapter.ListFragmentListener listener);
    }


    interface Repository {

        void getDataFormApi(RecyclerView rv,
                            MainRecyclerViewAdapter.ListFragmentListener listener);
    }
}
