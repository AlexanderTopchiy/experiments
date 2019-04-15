package com.wyverx.recyclers.presentation.presenter.players;

import com.wyverx.recyclers.data.repositories.players.PlayersRepositoryImpl;
import com.wyverx.recyclers.domain.players.PlayersInteractor;
import com.wyverx.recyclers.domain.players.PlayersInteractorImpl;
import com.wyverx.recyclers.domain.players.models.Player;
import com.wyverx.recyclers.domain.threading.Executor;
import com.wyverx.recyclers.domain.threading.MainThread;
import com.wyverx.recyclers.presentation.presenter.AbstractPresenter;

import java.util.List;

public class PlayersPresenterImpl extends AbstractPresenter
        implements PlayersPresenter, PlayersInteractor.Callback {

    private PlayersPresenter.View mView;


    public PlayersPresenterImpl(Executor executor,
                                MainThread mainThread,
                                View view) {
        super(executor, mainThread);
        mView = view;
    }


    @Override
    public void resume() {
        PlayersInteractor interactor = new PlayersInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                new PlayersRepositoryImpl());
        interactor.execute();
    }


    @Override
    public void onDisplayPlayersList(List<Player> playersList) {
        mView.displayPlayersList(playersList);
    }
}
