package com.wyverx.recyclers.presentation.view.players;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.wyverx.recyclers.R;
import com.wyverx.recyclers.data.repositories.players.PlayersRepositoryImpl;
import com.wyverx.recyclers.domain.players.models.Player;
import com.wyverx.recyclers.domain.threading.MainThread;
import com.wyverx.recyclers.domain.threading.ThreadExecutor;
import com.wyverx.recyclers.presentation.presenter.players.PlayersPresenter;
import com.wyverx.recyclers.presentation.presenter.players.PlayersPresenterImpl;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayersActivity extends AppCompatActivity implements PlayersPresenter.View {

    private PlayersPresenter mPresenter;
    private PlayersRecyclerViewAdapter mPlayersAdapter;

    @BindView(R.id.players_recycler_view) RecyclerView mPlayersRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        ButterKnife.bind(this);

        initPlayersRecyclerView();

        mPresenter = new PlayersPresenterImpl(
                ThreadExecutor.getInstance(),
                MainThread.getInstance(),
                this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }


    @Override
    public void displayPlayersList(List<Player> playersList) {
        mPlayersAdapter.setDataToAdapter(playersList);
        mPlayersRecyclerView.setAdapter(mPlayersAdapter);
    }


    public void initPlayersRecyclerView() {
        int numberOfColumns = 2;
        mPlayersRecyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        mPlayersAdapter = new PlayersRecyclerViewAdapter();
    }
}
