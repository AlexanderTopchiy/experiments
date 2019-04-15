package com.wyverx.recyclers.data.repositories.players;

import com.wyverx.recyclers.RecyclersApplication;
import com.wyverx.recyclers.data.db.PlayersDAO;
import com.wyverx.recyclers.data.db.PlayersRoomDatabase;
import com.wyverx.recyclers.data.db.RecyclersDatabaseCopier;
import com.wyverx.recyclers.domain.players.PlayersRepository;
import com.wyverx.recyclers.domain.players.models.Player;

import java.util.List;

public class PlayersRepositoryImpl implements PlayersRepository {

    private RecyclersDatabaseCopier mDatabaseCopier;
    private PlayersRoomDatabase mDb;
    private PlayersDAO mPlayersDAO;


    @Override
    public List<Player> getPlayersInfo() {
        initDb();

        return mPlayersDAO.getAllPlayers();
    }


    private void initDb() {
        mDatabaseCopier= RecyclersDatabaseCopier.getInstance(RecyclersApplication.contextReference.get());
        mDb = mDatabaseCopier.getDatabase();
        mPlayersDAO = mDb.playersDAO();
    }
}
