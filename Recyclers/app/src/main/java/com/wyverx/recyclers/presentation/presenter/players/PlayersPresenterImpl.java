package com.wyverx.recyclers.presentation.presenter.players;

import com.wyverx.recyclers.domain.players.PlayersInteractor;
import com.wyverx.recyclers.domain.players.PlayersInteractorImpl;
import com.wyverx.recyclers.domain.players.PlayersRepository;
import com.wyverx.recyclers.domain.players.models.Player;
import com.wyverx.recyclers.domain.threading.Executor;
import com.wyverx.recyclers.domain.threading.MainThread;
import com.wyverx.recyclers.presentation.presenter.AbstractPresenter;

import java.util.List;

public class PlayersPresenterImpl extends AbstractPresenter
        implements PlayersPresenter, PlayersInteractor.Callback {

    private PlayersPresenter.View mView;
    private PlayersRepository mPlayersRepository;


    public PlayersPresenterImpl(Executor executor,
                                MainThread mainThread,
                                View view,
                                PlayersRepository playersRepository) {
        super(executor, mainThread);
        mView = view;
        mPlayersRepository = playersRepository;
    }


    @Override
    public void resume() {
        PlayersInteractor interactor = new PlayersInteractorImpl(
                mExecutor,
                mMainThread,
                this,
                mPlayersRepository);
        interactor.execute();
    }


    @Override
    public void onError(String message) {
        mView.showError(message);
    }


    @Override
    public void onDisplayPlayersList(List<Player> playersList) {
        mView.displayPlayersList(playersList);
    }


    @Override
    public void onDisplayFailed(String error) {
        onError(error);
    }
}
