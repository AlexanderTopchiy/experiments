package com.wyverx.recyclers.domain.players;

import com.wyverx.recyclers.domain.Interactor;
import com.wyverx.recyclers.domain.players.models.Player;

import java.util.List;

public interface PlayersInteractor extends Interactor {

    interface Callback {
        void onDisplayPlayersList(List<Player> playersList);

        void onDisplayFailed(String error);
    }
}
