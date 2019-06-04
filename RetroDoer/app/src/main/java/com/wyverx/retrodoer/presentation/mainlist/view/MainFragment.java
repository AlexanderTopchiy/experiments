package com.wyverx.retrodoer.presentation.mainlist.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wyverx.retrodoer.R;
import com.wyverx.retrodoer.data.models.Post;
import com.wyverx.retrodoer.presentation.itemdetails.ItemDetailsFragment;
import com.wyverx.retrodoer.presentation.mainlist.MainContract;
import com.wyverx.retrodoer.presentation.mainlist.presenter.MainPresenter;
import com.wyverx.retrodoer.data.repository.MainRepository;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class MainFragment extends Fragment implements MainContract.View {

    private MainContract.Presenter mMainPresenter;
    private RecyclerView mRecyclerView;
    private MainRecyclerViewAdapter mAdapter;


    public MainFragment() {
    }


    public static MainFragment newInstance() {
        return new MainFragment();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMainPresenter = MainPresenter.newInstance(this, MainRepository.newInstance());

        mAdapter = new MainRecyclerViewAdapter(new MainRecyclerViewAdapter.ListFragmentListener() {
            @Override
            public void onClickListListener(Post post) {
                moveToItemDetailsFragment(post);
            }
        });
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_list, container, false);

        mRecyclerView = (RecyclerView) view;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mRecyclerView.setAdapter(mAdapter);
        mMainPresenter.loadData();
        return mRecyclerView;
    }


    @Override
    public void matchData(List<Post> list) {
        mAdapter.updateDataSet(list);
    }


    private void moveToItemDetailsFragment(Post post) {
        Bundle argsFromMain = new Bundle();
        argsFromMain.putString("post body", post.getPostBody());

        FragmentManager fragmentManager = getFragmentManager();
        ItemDetailsFragment itemDetailsFragment = ItemDetailsFragment.newInstance();
        itemDetailsFragment.setArguments(argsFromMain);
        fragmentManager.beginTransaction()
                .replace(R.id.main_container, itemDetailsFragment)
                .addToBackStack("ItemDetailsFragment")
                .commit();
    }
}
