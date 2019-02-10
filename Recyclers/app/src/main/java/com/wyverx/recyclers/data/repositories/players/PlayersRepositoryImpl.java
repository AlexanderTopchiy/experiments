package com.wyverx.recyclers.data.repositories.players;

import com.wyverx.recyclers.domain.players.PlayersRepository;
import com.wyverx.recyclers.domain.players.models.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayersRepositoryImpl implements PlayersRepository {

    @Override
    public List<Player> getPlayersInfo() {
        String[] playersArray = new String[] {
                "Shin Jinseo",
                "Ke Jie",
                "Park Junghwan",
                "Mi Yuting",
                "Gu Zihao",
                "Lian Xiao",
                "Fan Tingyu",
                "Kim Jiseok",
                "Yang Dingxin",
                "Shi Yue"
        };

        List<Player> playersList = new ArrayList<>();

        for (String player : playersArray) {
            playersList.add(new Player(player));
        }

        return playersList;
    }
}
