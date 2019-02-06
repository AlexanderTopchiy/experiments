package com.wyverx.recyclers.domain.players;

import com.wyverx.recyclers.domain.players.models.Player;
import com.wyverx.recyclers.domain.threading.Executor;
import com.wyverx.recyclers.domain.threading.MainThread;
import com.wyverx.recyclers.threading.TestMainThread;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class PlayersInteractorTest {

    private MainThread mMainThread;
    @Mock private Executor mExecutor;
    @Mock private PlayersRepository mPlayersRepository;
    @Mock private PlayersInteractor.Callback mCallback;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mMainThread = new TestMainThread();
    }


    @Test
    public void testDisplayPlayersList() throws Exception {
        List<Player> playersList = new ArrayList<>();
        playersList.add(new Player("Shin Jinseo"));
        playersList.add(new Player("Ke Jie"));
        playersList.add(new Player("Park Junghwan"));
        Mockito.when(mPlayersRepository.getPlayersInfo()).thenReturn(playersList);
        PlayersInteractorImpl interactor = new PlayersInteractorImpl(
                mExecutor,
                mMainThread,
                mCallback,
                mPlayersRepository);
        interactor.run();
        Mockito.verify(mPlayersRepository).getPlayersInfo();
        Mockito.verifyNoMoreInteractions(mPlayersRepository);
        Mockito.verify(mCallback).onDisplayPlayersList(playersList);
    }


    @Test
    public void testDisplayFailed() throws Exception {
        Mockito.when(mPlayersRepository.getPlayersInfo()).thenReturn(null);
        PlayersInteractorImpl interactor = new PlayersInteractorImpl(
                mExecutor,
                mMainThread,
                mCallback,
                mPlayersRepository);
        interactor.run();
        Mockito.verify(mPlayersRepository).getPlayersInfo();
        Mockito.verifyNoMoreInteractions(mPlayersRepository);
        Mockito.verify(mCallback).onDisplayFailed(Mockito.anyString());
    }
}
