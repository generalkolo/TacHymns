package com.semanientreprise.tachymns.Data;

import android.content.Context;

import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.fragment.EnglishHymnFragment;
import com.semanientreprise.tachymns.model.SongsGAndS;

import java.util.ArrayList;
import java.util.List;


public class DataFeeder {
    private static Context c;
    private static final String[] hymnNames = {"Hymn 001","Hymn 002","Hymn 003"};
    private static final int[] icon = {R.drawable.ic_star_border_black_24dp,R.drawable.ic_star_border_black_24dp,
                                        R.drawable.ic_star_border_black_24dp};
    private static final int[] hymnNumbers = {1,2,3};
    private static final boolean[] hymnIsFavorite = {false,false,false};
    private static final String[] hymnTitles = {"1. Jesus is the healer of us all",
                                                "2. Trust and Obey","3. What a friend we have in Jesus"};
    private static final String[] hymnVerses = {"\"Seek ye first his kingdom and all other things shall be added unto you\" - Mat 6:33",
            "\"For God so loved the world that he gave us his only begotten son\" - John 3: 16",
            "\"Rejoice forever more again i say rejoice\" - Philippians 4:4"};
    private static final String[] hymnSongsAndChorus = {"1. The very beginning of a thing One\n" +
                                                        "is much more harder than the end thereof\n" +
                                                        "But if you hold on tight and dont give up\n" +
                                                        "then something good is coming your way then\n" +
                                                        "\nCHORUS\n" +
                                                        "Tis is not the end, focus instead and watch a\n" +
                                                        "When all you do is hardwork then dont worry\n" +
                                                        "I welcome you to this great day of success\n" +
                                                        " turn around  success  is coming if only you hold on\n"+
                                                        "\n2. The very beginning of a thing\n" +
                                                        "is much more harder than the end thereof\n" +
                                                        "But if you hold on tight and dont give up\n" +
                                                        "then something good is coming your way then"
            ,
                                                        "1. The very beginning of a thing Two\n" +
                                                        "is much more harder than the end thereof\n" +
                                                        "But if you hold on tight and dont give up\n" +
                                                        "then something good is coming your way then\n" +
                                                        "\nCHORUS\n" +
                                                        "Tis is not the end, focus instead and watch a\n" +
                                                        "When all you do is hardwork then dont worry\n" +
                                                        "I welcome you to this great day of success\n" +
                                                        " turn around  success  is coming if only you hold on\n"+
                                                        "\n2. The very beginning of a thing\n" +
                                                        "is much more harder than the end thereof\n" +
                                                        "But if you hold on tight and dont give up\n" +
                                                        "then something good is coming your way then"
            ,
                                                        "1. The very beginning of a thing Three\n" +
                                                        "is much more harder than the end thereof\n" +
                                                        "But if you hold on tight and dont give up\n" +
                                                        "then something good is coming your way then\n" +
                                                        "\nCHORUS\n" +
                                                        "Tis is not the end, focus instead and watch a\n" +
                                                        "When all you do is hardwork then dont worry\n" +
                                                        "I welcome you to this great day of success\n" +
                                                        " turn around  success  is coming if only you hold on\n"+
                                                        "\n2. The very beginning of a thing\n" +
                                                        "is much more harder than the end thereof\n" +
                                                        "But if you hold on tight and dont give up\n" +
                                                        "then something good is coming your way then"
    };
    private static final String[] hymnChorus = {"This is first Line One","This is First Line two","This is first line three"};

    public static List<SongsGAndS> getListData(){
        List<SongsGAndS> data = new ArrayList<>();

        for(int x = 0;x<400;x++){
            for (int i = 0; i< hymnNames.length ; i++){
                SongsGAndS songsGAndS = new SongsGAndS();
                songsGAndS.setSongName(hymnNames[i]);
                songsGAndS.setFavourites(icon[i]);
                songsGAndS.setSongTitle(hymnTitles[i]);
                songsGAndS.setSongVerse(hymnVerses[i]);
                songsGAndS.setSongStanzasAndChorus(hymnSongsAndChorus[i]);
                songsGAndS.setHymnNumber(hymnNumbers[i]);
                songsGAndS.setHymnChorus(hymnChorus[i]);
                songsGAndS.setFavourite(hymnIsFavorite[i]);
                data.add(songsGAndS);
            }
        }
        return data;
    }

    public static List<SongsGAndS> getYorubaData(){
        List<SongsGAndS> data = new ArrayList<>();

        for(int x = 0;x<400;x++){
            for (int i = hymnNames.length - 1 ; i > -1; i--){
                SongsGAndS songsGAndS = new SongsGAndS();
                songsGAndS.setSongName(hymnNames[i]);
                songsGAndS.setFavourites(icon[i]);
                songsGAndS.setSongTitle(hymnTitles[i]);
                songsGAndS.setSongVerse(hymnVerses[i]);
                songsGAndS.setSongStanzasAndChorus(hymnSongsAndChorus[i]);
                songsGAndS.setHymnNumber(hymnNumbers[i]);
                songsGAndS.setHymnChorus(hymnChorus[i]);
                songsGAndS.setFavourite(hymnIsFavorite[i]);
                data.add(songsGAndS);
            }
        }
        return data;
    }

    public static List<SongsGAndS> getFavourites(){

        List<SongsGAndS> dataGotten = EnglishHymnFragment.getDataTobeSent();
        List<SongsGAndS> dataToBeSent = new ArrayList<>();

        for(SongsGAndS elements : dataGotten){
            if(elements.isFavourite()){
                dataToBeSent.add(elements);
            }
        }
        return dataToBeSent;
    }
}