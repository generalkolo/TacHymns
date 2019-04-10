package com.semanientreprise.tachymns.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.semanientreprise.tachymns.model.songGAndSEntity;
import com.semanientreprise.tachymns.model.songsGAndSRepository;

import java.util.List;

public class HymnsViewModel extends AndroidViewModel {
    private songsGAndSRepository mRepository;

    private LiveData<List<songGAndSEntity>> mHymnsAll;

    public HymnsViewModel(@NonNull Application application) {
        super(application);
        mRepository = new songsGAndSRepository(application);
        mHymnsAll = mRepository.getAllHymns();
    }

    public LiveData<List<songGAndSEntity>> getAllHymns(){
        return mHymnsAll;
    }
}
