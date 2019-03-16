package com.wyverx.recyclers.data.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.wyverx.recyclers.domain.players.models.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class PlayersRoomDatabase extends RoomDatabase {

    public abstract PlayersDAO playersDAO();
}
