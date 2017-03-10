package com.jieleo.xmly_plus.model.bean.model_discover;

import java.util.List;

/**
 * Created by dllo on 17/3/10.
 */

public class DisCoverBean {


    /**
     * ret : 0
     * squareTabLastReadMillisecond : 1489108545362
     * list : [{"id":1,"list":[{"contentType":"album_category","contentUpdatedAt":1489054536000,"coverPath":"http://fdfs.xmcdn.com/group18/M07/FB/93/wKgJJVfXXrzhgNjuAAAPUre2hE4043.jpg","enableShare":false,"id":62,"isExternalUrl":false,"properties":{"categoryId":33},"sharePic":"","subCoverPath":"","subtitle":"雷明教你读懂BOSS心","title":"付费精品","url":""}]},{"id":2,"list":[{"contentType":"html5","contentUpdatedAt":1488969137000,"coverPath":"http://fdfs.xmcdn.com/group21/M00/D8/31/wKgJKFiEO1WRwucyAAAKaqnHh-0138.jpg","enableShare":false,"id":71,"isExternalUrl":false,"sharePic":"","subCoverPath":"http://fdfs.xmcdn.com/group23/M08/E1/1E/wKgJNFjBM1Gycg6-AAKOk9p-Y9o120.jpg","subtitle":"将这长途，点缀得香花弥漫","title":"我读你听","url":"http://a.ximalaya.com/m/all/people/list"}]},{"id":3,"list":[{"contentType":"html5.hotline","contentUpdatedAt":1488878461000,"coverPath":"http://fdfs.xmcdn.com/group23/M09/6E/79/wKgJL1ibFnewM7eNAAAMzK6XaNA817.jpg","enableShare":false,"id":63,"isExternalUrl":false,"sharePic":"","subCoverPath":"http://fdfs.xmcdn.com/group18/M08/B9/98/wKgJJVi-e2CjrpkIAAB4-HoBE7U403.jpg","subtitle":"西游记团队如何裁员?","title":"问答","url":"http://hotline.ximalaya.com/"},{"contentType":"broadcast","contentUpdatedAt":0,"coverPath":"http://fdfs.xmcdn.com/group20/M01/FA/85/wKgJLFfXXyCTBbhnAAAGGhhiaM4449.jpg","enableShare":false,"id":64,"isExternalUrl":false,"sharePic":"","subCoverPath":"","subtitle":"","title":"广播","url":""}]},{"id":4,"list":[{"contentType":"chaos","contentUpdatedAt":0,"coverPath":"http://fdfs.xmcdn.com/group19/M04/FC/38/wKgJJlfXZHviQHM1AAAMJV5syGs287.jpg","enableShare":false,"id":66,"isExternalUrl":false,"sharePic":"","subtitle":"","title":"听友圈","url":""}]},{"id":5,"list":[{"contentType":"html5.mall","contentUpdatedAt":1489025274000,"coverPath":"http://fdfs.xmcdn.com/group17/M02/FC/46/wKgJKVfXZMTgt4vpAAAGzvR3wVc424.jpg","enableShare":false,"id":67,"isExternalUrl":false,"sharePic":"","subCoverPath":"","subtitle":"智惠生活 全场1折起","title":"精选特卖","url":"ttg://home"},{"contentType":"html5.game","contentUpdatedAt":0,"coverPath":"http://fdfs.xmcdn.com/group20/M05/FC/67/wKgJJ1fXZTmhXq5lAAAKI51tu1Q609.jpg","enableShare":false,"id":68,"isExternalUrl":false,"sharePic":"","subCoverPath":"http://fdfs.xmcdn.com/group23/M04/D9/C8/wKgJL1iEStaBl7YaAAAjxRMZiJI055.jpg","subtitle":"无兄弟不传奇","title":"游戏","url":"http://game.ximalaya.com/games-operation/v1/games/list?ly=androidfx&dot=1"},{"contentType":"activity","contentUpdatedAt":0,"coverPath":"http://fdfs.xmcdn.com/group17/M0A/38/31/wKgJJFfp4bewZ4SSAAAI_a8W7wQ032.jpg","enableShare":false,"id":69,"isExternalUrl":false,"sharePic":"","subCoverPath":"","subtitle":"","title":"活动","url":""}]}]
     * msg : 成功
     */

    private int ret;
    private long squareTabLastReadMillisecond;
    private String msg;
    private List<ListBeanX> list;

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public long getSquareTabLastReadMillisecond() {
        return squareTabLastReadMillisecond;
    }

    public void setSquareTabLastReadMillisecond(long squareTabLastReadMillisecond) {
        this.squareTabLastReadMillisecond = squareTabLastReadMillisecond;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ListBeanX> getList() {
        return list;
    }

    public void setList(List<ListBeanX> list) {
        this.list = list;
    }

    public static class ListBeanX {
        /**
         * id : 1
         * list : [{"contentType":"album_category","contentUpdatedAt":1489054536000,"
         * coverPath":"http://fdfs.xmcdn.com/group18/M07/FB/93/wKgJJVfXXrzhgNjuAAAPUre2hE4043.jpg",
         * "enableShare":false,"id":62,"isExternalUrl":false,"properties":{"categoryId":33},"sharePic":"",
         * "subCoverPath":"","subtitle":"雷明教你读懂BOSS心","title":"付费精品","url":""}]
         */

        private int id;
        private List<ListBean> list;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * contentType : album_category
             * contentUpdatedAt : 1489054536000
             * coverPath : http://fdfs.xmcdn.com/group18/M07/FB/93/wKgJJVfXXrzhgNjuAAAPUre2hE4043.jpg
             * enableShare : false
             * id : 62
             * isExternalUrl : false
             * properties : {"categoryId":33}
             * sharePic :
             * subCoverPath :
             * subtitle : 雷明教你读懂BOSS心
             * title : 付费精品
             * url :
             */

            private String contentType;
            private long contentUpdatedAt;
            private String coverPath;
            private boolean enableShare;
            private int id;
            private boolean isExternalUrl;
            private PropertiesBean properties;
            private String sharePic;
            private String subCoverPath;
            private String subtitle;
            private String title;
            private String url;

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public long getContentUpdatedAt() {
                return contentUpdatedAt;
            }

            public void setContentUpdatedAt(long contentUpdatedAt) {
                this.contentUpdatedAt = contentUpdatedAt;
            }

            public String getCoverPath() {
                return coverPath;
            }

            public void setCoverPath(String coverPath) {
                this.coverPath = coverPath;
            }

            public boolean isEnableShare() {
                return enableShare;
            }

            public void setEnableShare(boolean enableShare) {
                this.enableShare = enableShare;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIsExternalUrl() {
                return isExternalUrl;
            }

            public void setIsExternalUrl(boolean isExternalUrl) {
                this.isExternalUrl = isExternalUrl;
            }

            public PropertiesBean getProperties() {
                return properties;
            }

            public void setProperties(PropertiesBean properties) {
                this.properties = properties;
            }

            public String getSharePic() {
                return sharePic;
            }

            public void setSharePic(String sharePic) {
                this.sharePic = sharePic;
            }

            public String getSubCoverPath() {
                return subCoverPath;
            }

            public void setSubCoverPath(String subCoverPath) {
                this.subCoverPath = subCoverPath;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public static class PropertiesBean {
                /**
                 * categoryId : 33
                 */

                private int categoryId;

                public int getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }
            }
        }
    }
}
