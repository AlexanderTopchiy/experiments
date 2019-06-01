package com.wyverx.retrodoer.mainlist;

import android.support.v7.widget.RecyclerView;

import com.wyverx.retrodoer.mainlist.view.MainFragment;

public interface MainContract {

    interface View {

    }


    interface Presenter {

        void loadData(RecyclerView rv,
                      MainFragment.OnListFragmentInteractionListener listener);
    }


    interface Repository {

        void getDataFormApi(RecyclerView rv,
                            MainFragment.OnListFragmentInteractionListener listener);
    }
}
