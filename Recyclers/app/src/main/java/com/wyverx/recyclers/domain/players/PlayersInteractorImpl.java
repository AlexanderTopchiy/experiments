package com.wyverx.recyclers.domain.players;

import com.wyverx.recyclers.domain.AbstractInteractor;
import com.wyverx.recyclers.domain.players.models.Player;
import com.wyverx.recyclers.domain.threading.Executor;
import com.wyverx.recyclers.domain.threading.MainThread;

import java.util.List;

public class PlayersInteractorImpl extends AbstractInteractor implements PlayersInteractor {

    private PlayersInteractor.Callback mCallback;
    private PlayersRepository mPlayersRepository;


    public PlayersInteractorImpl(Executor threadExecutor,
                                 MainThread mainThread,
                                 PlayersInteractor.Callback callback,
                                 PlayersRepository playersRepository) {
        super(threadExecutor, mainThread);
        mCallback = callback;
        mPlayersRepository = playersRepository;
    }


    private void notifyError() {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onDisplayFailed("Nothing to show :(");
            }
        });
    }


    private void displayPlayersList(final List<Player> playersList) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onDisplayPlayersList(playersList);
            }
        });
    }


    @Override
    public void run() {
        final List<Player> playersList = mPlayersRepository.getPlayersInfo();
        if (playersList == null || playersList.size() == 0) {
            notifyError();
            return;
        }
        displayPlayersList(playersList);
    }
}
