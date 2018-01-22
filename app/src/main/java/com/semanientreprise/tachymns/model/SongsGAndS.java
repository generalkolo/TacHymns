package com.semanientreprise.tachymns.model;

import android.os.Parcel;
import android.os.Parcelable;

public class SongsGAndS implements Parcelable {

    private String songName;
    private int favourites;
    private String songTitle;
    private String songVerse;
    private String songStanzasAndChorus;
    private int hymnNumber;
    private String hymnChorus;
    private boolean isFavourite;

    public SongsGAndS() {}

    public SongsGAndS(String songName, int favourites, String songTitle, String songVerse, String songStanzasAndChorus
    , int hymnNumber, String hymnChorus, boolean isFavourite) {
        this.songName = songName;
        this.favourites = favourites;
        this.songTitle = songTitle;
        this.songVerse = songVerse;
        this.songStanzasAndChorus = songStanzasAndChorus;
        this.hymnNumber = hymnNumber;
        this.hymnChorus = hymnChorus;
        this.isFavourite = isFavourite;
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

    public String getHymnTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getHymnScripture() {
        return songVerse;
    }

    public void setSongVerse(String songVerse) {
        this.songVerse = songVerse;
    }

    public String SongStanzasAndChorus() {
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.songName);
        dest.writeInt(this.favourites);
        dest.writeString(this.songTitle);
        dest.writeString(this.songVerse);
        dest.writeString(this.songStanzasAndChorus);
        dest.writeInt(this.hymnNumber);
        dest.writeString(this.hymnChorus);
        dest.writeByte(this.isFavourite ? (byte) 1 : (byte) 0);
    }

    protected SongsGAndS(Parcel in) {
        this.songName = in.readString();
        this.favourites = in.readInt();
        this.songTitle = in.readString();
        this.songVerse = in.readString();
        this.songStanzasAndChorus = in.readString();
        this.hymnNumber = in.readInt();
        this.hymnChorus = in.readString();
        this.isFavourite = in.readByte() != 0;
    }

    public static final Parcelable.Creator<SongsGAndS> CREATOR = new Parcelable.Creator<SongsGAndS>() {
        @Override
        public SongsGAndS createFromParcel(Parcel source) {
            return new SongsGAndS(source);
        }

        @Override
        public SongsGAndS[] newArray(int size) {
            return new SongsGAndS[size];
        }
    };
}
