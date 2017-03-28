package com.jieleo.xmly_plus.model.bean.model_ju_neng_wan;

import java.util.List;

/**
 * Created by yuyongjie on 17/3/22.
 */


public class JuNengWanBannerBean {

    /**
     * Result : 0
     * Data : [{"biId":179,"bannerType":1,"imgUrl":"http://yf.jnwtv.com/B20170317100109674229125.png?e=2997426444","piId":10055,"miId":1305,"episode":1,"url":"","busiId":null,"questionType":"1"},{"biId":174,"bannerType":0,"imgUrl":"http://yf.jnwtv.com/B20170222101008627515512.jpg?e=2997426444","piId":0,"miId":null,"episode":null,"url":"","busiId":null,"questionType":"1"},{"biId":164,"bannerType":1,"imgUrl":"http://yf.jnwtv.com/B20170204182228826703039.jpg?e=2997426444","piId":10047,"miId":1271,"episode":1,"url":"","busiId":0,"questionType":"1"},{"biId":171,"bannerType":1,"imgUrl":"http://yf.jnwtv.com/B20170220104510576582518.jpg?e=2997426444","piId":10041,"miId":1225,"episode":1,"url":"","busiId":null,"questionType":"1"}]
     * Desc : \u6210\u529f
     */

    private String Result;
    private String Desc;
    private List<DataBean> Data;

    public String getResult() {
        return Result;
    }

    public void setResult(String Result) {
        this.Result = Result;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String Desc) {
        this.Desc = Desc;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * biId : 179
         * bannerType : 1
         * imgUrl : http://yf.jnwtv.com/B20170317100109674229125.png?e=2997426444
         * piId : 10055
         * miId : 1305
         * episode : 1
         * url :
         * busiId : null
         * questionType : 1
         */

        private int biId;
        private int bannerType;
        private String imgUrl;
        private int piId;
        private int miId;
        private int episode;
        private String url;
        private Object busiId;
        private String questionType;

        public int getBiId() {
            return biId;
        }

        public void setBiId(int biId) {
            this.biId = biId;
        }

        public int getBannerType() {
            return bannerType;
        }

        public void setBannerType(int bannerType) {
            this.bannerType = bannerType;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public int getPiId() {
            return piId;
        }

        public void setPiId(int piId) {
            this.piId = piId;
        }

        public int getMiId() {
            return miId;
        }

        public void setMiId(int miId) {
            this.miId = miId;
        }

        public int getEpisode() {
            return episode;
        }

        public void setEpisode(int episode) {
            this.episode = episode;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public Object getBusiId() {
            return busiId;
        }

        public void setBusiId(Object busiId) {
            this.busiId = busiId;
        }

        public String getQuestionType() {
            return questionType;
        }

        public void setQuestionType(String questionType) {
            this.questionType = questionType;
        }
    }
}
