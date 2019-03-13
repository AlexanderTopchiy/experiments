package com.wyverx.recyclers.domain.players.models;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "players")
public class Player {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "_id")
    private int mId;

    @ColumnInfo(name = "last_name")
    private String mLastName;

    @ColumnInfo(name = "first_name")
    private String mFirstName;

    @ColumnInfo(name = "country")
    private String mCountry;

    @ColumnInfo(name = "elo")
    private int mElo;


    public Player(int id, String lastName, String firstName, String country, int elo) {
        mId = id;
        mLastName = lastName;
        mFirstName = firstName;
        mCountry = country;
        mElo = elo;
    }
}
