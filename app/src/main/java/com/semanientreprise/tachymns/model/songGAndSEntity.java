package com.semanientreprise.tachymns.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity(tableName = "Hymns")
public class songGAndSEntity {
    @PrimaryKey
    @NotNull
    @ColumnInfo(name = "song_name")
    private String songName;

    private int favourites;

    @ColumnInfo(name = "hymn_title")
    private String songTitle;

    @ColumnInfo(name = "hymn_scripture")
    private String songVerse;

    @ColumnInfo(name = "hymn_stanza_chrous")
    private String songStanzasAndChorus;

    @ColumnInfo(name = "hymn_number")
    private int hymnNumber;

    @ColumnInfo(name = "hymn_chorus")
    private String hymnChorus;

    @ColumnInfo(name = "hymn_first_line")
    private String hymnFirstLine;

    @ColumnInfo(name = "song_name")
    private boolean isFavourite;

    public songGAndSEntity(@NotNull String songName, int favourites, String songTitle,
                           String songVerse, String songStanzasAndChorus, int hymnNumber,
                           String hymnChorus, boolean isFavourite, String hymnFirstLine) {
        this.songName = songName;
        this.favourites = favourites;
        this.songTitle = songTitle;
        this.songVerse = songVerse;
        this.songStanzasAndChorus = songStanzasAndChorus;
        this.hymnNumber = hymnNumber;
        this.hymnChorus = hymnChorus;
        this.isFavourite = isFavourite;
        this.hymnFirstLine = hymnFirstLine;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getFavourites() {
        return favourites;
    }

    public void setFavourites(int favourites) {
        this.favourites = favourites;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getSongVerse() {
        return songVerse;
    }

    public void setSongVerse(String songVerse) {
        this.songVerse = songVerse;
    }

    public String getSongStanzasAndChorus() {
        return songStanzasAndChorus;
    }

    public void setSongStanzasAndChorus(String songStanzasAndChorus) {
        this.songStanzasAndChorus = songStanzasAndChorus;
    }

    public int getHymnNumber() {
        return hymnNumber;
    }

    public void setHymnNumber(int hymnNumber) {
        this.hymnNumber = hymnNumber;
    }

    public String getHymnChorus() {
        return hymnChorus;
    }

    public void setHymnChorus(String hymnChorus) {
        this.hymnChorus = hymnChorus;
    }

    public boolean isFavourite() {
        return isFavourite;
    }

    public void setFavourite(boolean favourite) {
        isFavourite = favourite;
    }
}
