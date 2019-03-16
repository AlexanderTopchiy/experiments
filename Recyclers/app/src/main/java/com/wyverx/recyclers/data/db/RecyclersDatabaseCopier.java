package com.wyverx.recyclers.data.db;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RecyclersDatabaseCopier {

    private static final String DATABASE_NAME = "recyclers.db";
    private static Context mContext;
    private static volatile RecyclersDatabaseCopier INSTANCE;
    private PlayersRoomDatabase mDatabase;


    public static RecyclersDatabaseCopier getInstance(final Context context) {
        mContext = context;
        if (INSTANCE == null) {
            synchronized (RecyclersDatabaseCopier.class) {
                if (INSTANCE == null) {
                    INSTANCE = new RecyclersDatabaseCopier();
                }
            }
        }
        return INSTANCE;
    }


    private RecyclersDatabaseCopier() {
        copyAttachedDatabase(mContext, DATABASE_NAME);
        mDatabase = Room.databaseBuilder(mContext.getApplicationContext(),
                PlayersRoomDatabase.class, DATABASE_NAME)
                .build();

    }


    public PlayersRoomDatabase getDatabase() {
        return mDatabase;
    }


    private void copyAttachedDatabase(Context context, String databaseName) {
        final File dbPath = context.getDatabasePath(databaseName);

        if (dbPath.exists()) {
            return;
        }

        dbPath.getParentFile().mkdirs();

        try {
            final InputStream inputStream = context.getAssets().open(databaseName);
            final OutputStream output = new FileOutputStream(dbPath);

            byte[] buffer = new byte[8192];
            int length;

            while ((length = inputStream.read(buffer, 0, 8192)) > 0) {
                output.write(buffer, 0, length);
            }

            output.flush();
            output.close();
            inputStream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
