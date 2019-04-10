package com.semanientreprise.tachymns.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {songGAndSEntity.class}, version = 1)
public abstract class songGAndSDatabase extends RoomDatabase {
    public abstract songGAndSDao mSongGAndSDao();

    private static songGAndSDatabase INSTANCE;

    //TODO : Implement the prepopulation of the database using either json or from files
    static songGAndSDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (songGAndSDatabase.class){
                if (INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),songGAndSDatabase.class,
                            "hymn_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
