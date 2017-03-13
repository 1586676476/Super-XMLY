package com.jieleo.xmly_plus.tools;

/**
 * Created by yuyongjie on 17/3/10.
 */


public class MyUrl {
    //tabLayout的标题接口
    public static final String TAB_WORDS = "http://mobile.ximalaya.com/mobile/discovery/v2/tabs?device=android&version=5.4.87";
    //ListPageFragment接口
    public static final String LIST_PAGE_FRAGMENT_URL = "http://mobile.ximalaya.com/mobile/discovery/v1/categories?channel=and-d10&device=android&picVersion=13&scale=2";


    public static final String PLAY_MUSIC_HEAD_URL ="http://140.207.215.242/v1/track/ca/playpage/";

    public static final String PLAY_MUSIC_FOOT_URL ="?device=android&trackId=";


    public static String getMusicUrl(int id) {
        return PLAY_MUSIC_HEAD_URL+id+PLAY_MUSIC_FOOT_URL+id;
    }

    //discover接口
    public static final String Discover="http://140.207.215.247/mobile/discovery/v1/square/list?cityCode=43_220000_2203" +
            "&device=android&timestamp=1489059340075&version=5.4.87";
    //热门页轮播图
    public static final String HOT_LUNBOTU="http://mobile.ximalaya.com/mobile/discovery/v4/recommends?channel=and-d10" +
            "&device=android&includeActivity=true&includeSpecial=true&scale=2&version=5.4.87";
    //热门页中间recycleview
    public static final String HOT_CENTER="http://mobile.ximalaya.com/mobile/discovery/v3/recommend/hotAndGuess?" +
            "code=43_220000_2203&device=android&version=5.4.87";

}
