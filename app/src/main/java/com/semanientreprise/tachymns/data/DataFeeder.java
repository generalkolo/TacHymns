package com.semanientreprise.tachymns.data;

import com.semanientreprise.tachymns.R;
import com.semanientreprise.tachymns.fragment.EnglishHymnFragment;
import com.semanientreprise.tachymns.model.SongsGAndS;

import java.util.ArrayList;
import java.util.List;


public class DataFeeder {

    private static final String[] hymnNames = {"Hymn 001","Hymn 002","Hymn 003"};

    private static final int[] icon = {R.drawable.ic_star_border_black_24dp,R.drawable.ic_star_border_black_24dp,
                                        R.drawable.ic_star_border_black_24dp};

    private static final int[] hymnNumbers = {1,2,3};

    private static final boolean[] hymnIsFavorite = {false,false,false};

    private static final String[] hymnTitles = {"1. Jesus is the healer of us all",
                                                "2. Trust and Obey",
                                                "3. What a friend we have in Jesus"};

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
                                                        "then something good is coming your way then",

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
                                                        "then something good is coming your way then",

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
                                                        "then something good is coming your way then" };

    private static final String[] hymnChorus = {"This is first Line","This is Second Line","This is third"};

    private static final String[] YORhymnNames = {"Orin 001","Orin 002","Orin 003"};

    private static final String[] YORhymnTitles = {"1. Jesu ni olutọju gbogbo wa",
                                                   "2. Gbẹkẹle ati Igbọràn",
                                                   "3. Kini ọrẹ kan ti a ni ninu Jesu"};

    private static final String[] YORhymnVerses = {"\"Ẹ wá akọkọ ijọba rẹ, ao si fi ohun gbogbo kun nyin\" - Mat 6:33",
                                                   "\"Nitori Ọlọrun fẹ araiye tobẹ gẹ ti o fi wa ni ọmọ bíbi kanṣoṣo \"- Johannu 3:16",
                                                   "\"yọ lailai lailai Mo sọ ayọ \"- Filippi 4: 4"};

    private static final String[] YORhymnChorus = {"Eyi ni Laini akọkọ","Eyi ni Laini Keji","Eyi jẹ kẹta"};

    private static final String[] YORhymnSongsAndChorus = {"1. Ibẹrẹ ibẹrẹ ti ohun kan\n" +
                                                            "jẹ Elo siwaju sii siwaju sii ju opin rẹ\n" +
                                                            "Ṣugbọn ti o ba di mimu ati ki o maṣe dawọ duro\n" +
                                                            "lẹhinna nkankan ti o dara yoo wa ọna rẹ lẹhinna\n" +
                                                            "\nIWA\n" +
                                                            "Tis kii ṣe opin, idojukọ dipo ki o wo a\n" +
                                                            "Nigbati gbogbo nkan ti o ba ṣe jẹ hardwork lẹhinna maṣe dààmú\n" +
                                                            "Mo gba ọ lọwọ si ọjọ nla ti aṣeyọri\n" +
                                                            "yipada si aṣeyọri ti nbọ ti o ba jẹwọ nikan\n"+
                                                            "\n2. Ibẹrẹ ibere nkan kan\n" +
                                                            "jẹ Elo siwaju sii siwaju sii ju opin rẹ\n" +
                                                            "Ṣugbọn ti o ba di mimu ati ki o maṣe dawọ duro\n" +
                                                            "lẹhinna nkankan ti o dara yoo wa ọna rẹ lẹhinna",

                                                            "1. Ibẹrẹ ibẹrẹ ti ohun meji\n" +
                                                            "jẹ Elo siwaju sii siwaju sii ju opin rẹ\n" +
                                                            "Ṣugbọn ti o ba di mimu ati ki o maṣe dawọ duro\n" +
                                                            "lẹhinna nkankan ti o dara yoo wa ọna rẹ lẹhinna\n" +
                                                            "\nIWA\n" +
                                                            "Tis kii ṣe opin, idojukọ dipo ki o wo a\n" +
                                                            "Nigbati gbogbo nkan ti o ba ṣe jẹ hardwork lẹhinna maṣe dààmú\n" +
                                                            "Mo gba ọ lọwọ si ọjọ nla ti aṣeyọri\n" +
                                                            "yipada si aṣeyọri ti nbọ ti o ba jẹwọ nikan\n"+
                                                            "\n2. Ibẹrẹ ibere nkan kan\n" +
                                                            "jẹ Elo siwaju sii siwaju sii ju opin rẹ\n" +
                                                            "Ṣugbọn ti o ba di mimu ati ki o maṣe dawọ duro\n" +
                                                            "lẹhinna nkankan ti o dara yoo wa ọna rẹ lẹhinna",

                                                            "1. Ibẹrẹ ibẹrẹ ti ohun mẹta\n" +
                                                            "jẹ Elo siwaju sii siwaju sii ju opin rẹ\n" +
                                                            "Ṣugbọn ti o ba di mimu ati ki o maṣe dawọ duro\n" +
                                                            "lẹhinna nkankan ti o dara yoo wa ọna rẹ lẹhinna\n" +
                                                            "\nIWA\n" +
                                                            "Tis kii ṣe opin, idojukọ dipo ki o wo a\n" +
                                                            "Nigbati gbogbo nkan ti o ba ṣe jẹ hardwork lẹhinna maṣe dààmú\n" +
                                                            "Mo gba ọ lọwọ si ọjọ nla ti aṣeyọri\n" +
                                                            "yipada si aṣeyọri ti nbọ ti o ba jẹwọ nikan\n"+
                                                            "\n2. Ibẹrẹ ibere nkan kan\n" +
                                                            "jẹ Elo siwaju sii siwaju sii ju opin rẹ\n" +
                                                            "Ṣugbọn ti o ba di mimu ati ki o maṣe dawọ duro\n" +
                                                            "lẹhinna nkankan ti o dara yoo wa ọna rẹ lẹhinna", };


    public static List<SongsGAndS> getEnglishData(){
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
            for (int i = 0; i < hymnNames.length; i++){
                SongsGAndS songsGAndS = new SongsGAndS();
                songsGAndS.setSongName(YORhymnNames[i]);
                songsGAndS.setFavourites(icon[i]);
                songsGAndS.setSongTitle(YORhymnTitles[i]);
                songsGAndS.setSongVerse(YORhymnVerses[i]);
                songsGAndS.setSongStanzasAndChorus(YORhymnSongsAndChorus[i]);
                songsGAndS.setHymnNumber(hymnNumbers[i]);
                songsGAndS.setHymnChorus(YORhymnChorus[i]);
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