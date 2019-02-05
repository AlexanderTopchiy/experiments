package com.wyverx.recyclers.domain.players;

import com.wyverx.recyclers.domain.players.models.Player;
import java.util.List;

public interface PlayersRepository {

    List<Player> getPlayersInfo();
}
