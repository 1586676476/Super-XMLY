package com.jieleo.xmly_plus.tools;

/**
 * Created by yuyongjie on 17/3/10.
 */


public class MyUrl {
    //tabLayout的标题接口
    public static final String TAB_WORDS = "http://mobile.ximalaya.com/mobile/discovery/v2/tabs?device=android&version=5.4.87";
    //ListPageFragment接口
    public static final String LIST_PAGE_FRAGMENT_URL = "http://mobile.ximalaya.com/mobile/discovery/v1/categories?channel=and-d10&device=android&picVersion=13&scale=2";

    //LivePageFragment接口
    public static final String LIVE_PAGE_FRAGMENT_URL = "http://mobile.ximalaya.com/mobile/discovery/v1/anchor/recommend?device=android&version=5.4.87";


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
    //搜索页面推荐
    public static final String SEARCH="HTTP://search.ximalaya.com/hotWord?device=android";
    public static final String MVFragment_str_pre ="http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.7.3.0&channel=xiaomi&operator=3&provider=11%2C12&method=baidu.ting.mv.playMV&format=json&mv_id=";
    public static final String MVFragment_str_last = "&song_id=&definition=0";
    public static final String VIDEO_NEW_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting?from=android&version=5.9.8.1&channel=xiaomi&operator=-1&provider=11%2C12&method=baidu.ting.mv.searchMV&format=json&order=1&page_num=1&page_size=20&query=%E5%85%A8%E9%83%A8 ";
}
