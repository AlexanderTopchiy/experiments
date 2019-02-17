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
                "Shi Yue",
                "Xie Erhao",
                "Jiang Weijie",
                "Xu Jiayang",
                "Chen Yaoye",
                "Tuo Jiaxi",
                "Li Qincheng",
                "Fan Yunruo",
                "Wang Xi",
                "Lee Donghoon",
                "Tong Mengcheng",
                "Shin Minjun",
                "Liao Yuanhe",
                "Xie Ke",
                "Zhou Ruiyang",
                "Byun Sangil"
        };

        List<Player> playersList = new ArrayList<>();

        for (String playerName : playersArray) {
            playersList.add(new Player(playerName));
        }

        return playersList;
    }
}
