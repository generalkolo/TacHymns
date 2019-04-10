package com.semanientreprise.tachymns.model;

import android.app.Application;
import android.arch.lifecycle.LiveData;

import java.util.List;

public class songsGAndSRepository {

    private songGAndSDao mSongGAndSDao;
    private LiveData<List<songGAndSEntity>> mAllHymns;

    public songsGAndSRepository(Application application){
        songGAndSDatabase db = songGAndSDatabase.getDatabase(application);
        mSongGAndSDao = db.mSongGAndSDao();
        mAllHymns = mSongGAndSDao.getAllHymns();
    }

    public LiveData<List<songGAndSEntity>> getAllHymns(){
        return mAllHymns;
    }

}
