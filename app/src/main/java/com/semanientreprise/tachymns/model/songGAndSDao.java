package com.semanientreprise.tachymns.model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface songGAndSDao {

    @Query("SELECT * FROM Hymns")
    LiveData<List<songGAndSEntity>> getAllHymns();

}
