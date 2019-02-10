package com.wyverx.recyclers.presentation.presenter.players;

import com.wyverx.recyclers.domain.players.models.Player;
import com.wyverx.recyclers.presentation.presenter.BasePresenter;
import com.wyverx.recyclers.presentation.view.BaseView;

import java.util.List;

public interface PlayersPresenter extends BasePresenter {

    interface View extends BaseView {

        void displayPlayersList(List<Player> playersList);
    }
}
