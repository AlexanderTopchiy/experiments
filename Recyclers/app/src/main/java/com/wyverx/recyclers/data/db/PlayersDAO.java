package com.wyverx.recyclers.data.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.wyverx.recyclers.domain.players.models.Player;

import java.util.List;

@Dao
public interface PlayersDAO {

    @Query("SELECT * FROM players ORDER BY _id ASC")
    List<Player> getAllPlayers();
}
