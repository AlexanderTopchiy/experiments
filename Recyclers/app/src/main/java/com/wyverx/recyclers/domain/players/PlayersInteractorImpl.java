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


    @Override
    public void run() {
        final List<Player> playersList = mPlayersRepository.getPlayersInfo();
        displayPlayersList(playersList);
    }


    private void displayPlayersList(final List<Player> playersList) {
        mMainThread.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onDisplayPlayersList(playersList);
            }
        });
    }
}
