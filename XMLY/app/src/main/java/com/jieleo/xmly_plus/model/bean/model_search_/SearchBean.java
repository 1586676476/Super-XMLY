package com.jieleo.xmly_plus.model.bean.model_search_;

/**
 * Created by dllo on 17/3/16.
 */

public class SearchBean {

    /**
     * searchWord : 白百何
     * display_type : 2
     * is_through : true
     * through_type : 1
     * tgt_id : 6998843
     * url :
     */

    private String searchWord;
    private int display_type;
    private boolean is_through;
    private int through_type;
    private int tgt_id;
    private String url;

    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }

    public int getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(int display_type) {
        this.display_type = display_type;
    }

    public boolean isIs_through() {
        return is_through;
    }

    public void setIs_through(boolean is_through) {
        this.is_through = is_through;
    }

    public int getThrough_type() {
        return through_type;
    }

    public void setThrough_type(int through_type) {
        this.through_type = through_type;
    }

    public int getTgt_id() {
        return tgt_id;
    }

    public void setTgt_id(int tgt_id) {
        this.tgt_id = tgt_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
