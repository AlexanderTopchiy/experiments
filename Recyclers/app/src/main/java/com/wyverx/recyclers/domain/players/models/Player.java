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

    @ColumnInfo(name = "memorized")
    private int mMemorized;


    public Player(int id, String lastName, String firstName, String country, int elo, int memorized) {
        mId = id;
        mLastName = lastName;
        mFirstName = firstName;
        mCountry = country;
        mElo = elo;
        mMemorized = memorized;
    }


    public int getId() {
        return mId;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getFullName() {
        return mLastName + " " + mFirstName;
    }

    public String getCountry() {
        return mCountry;
    }

    public int getElo() {
        return mElo;
    }

    public int getMemorized() {
        return mMemorized;
    }


    public void setMemorized(int value) {
        mMemorized = value;
    }
}
