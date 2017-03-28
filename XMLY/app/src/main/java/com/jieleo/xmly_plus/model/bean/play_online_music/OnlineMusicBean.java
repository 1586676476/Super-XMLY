package com.jieleo.xmly_plus.model.bean.play_online_music;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by yuyongjie on 17/3/24.
 */


public class OnlineMusicBean {

    /**
     * trackInfo : {"trackId":5890260,"uid":17707629,"playUrl64":"http://fdfs.xmcdn.com/group6/M04/A3/46/wKgDhFUJFBDSU0kLAF-82w3EC8E516.mp3","playUrl32":"http://fdfs.xmcdn.com/group6/M04/A3/46/wKgDhFUJFBSjuFQ7AC_eklp7Gwk850.mp3","downloadUrl":"http://download.xmcdn.com/group6/M04/A7/34/wKgDg1UJFATCNDM2ADGsLmUmILw341.aac","playPathAacv164":"http://audio.xmcdn.com/group11/M04/34/A2/wKgDa1WT2h2hYpq3AGDLJF_USOE108.m4a","playPathAacv224":"http://audio.xmcdn.com/group11/M04/34/A2/wKgDa1WT2h3gqlSIACT0Wyky0BY890.m4a","downloadAacUrl":"http://download.xmcdn.com/group11/M04/34/A2/wKgDa1WT2h3gqlSIACT0Wyky0BY890.m4a","title":"杭州往事（9）：情似烟霞","duration":783,"isPaid":false,"isFree":false,"isAuthorized":false,"priceTypeId":0,"sampleDuration":0,"priceTypeEnum":0,"priceTypes":[],"categoryId":22,"processState":2,"createdAt":1426658327000,"coverSmall":"http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_web_meduim.jpg","coverMiddle":"http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_web_large.jpg","coverLarge":"http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_mobile_large.jpg","isPublic":true,"images":["http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_mobile_large.jpg"],"status":1,"downloadSize":3255342,"downloadAacSize":2421851,"categoryName":"旅游","bulletSwitchType":2,"playPathHq":""}
     * albumInfo : {"albumId":314381,"categoryId":22,"title":"杭州往事","coverOrigin":"http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280.jpg","coverSmall":"http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_mobile_small.jpg","coverMiddle":"http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_mobile_meduim.jpg","coverLarge":"http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_mobile_large.jpg","coverWebLarge":"http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_web_large.jpg","createdAt":1419155049000,"updatedAt":1489124788000,"uid":17707629,"intro":"这是一座历史悠久的城市 这是一座有人文灵魂的城市 这是一座用美丽打动人心的城市 这里，有说不尽的往事 微信公众号：nuoradio","tags":"浩然爸爸,杭州,杭州往事,历史人文,文化","hasNew":false,"isFavorite":false,"isPaid":false,"status":1,"serializeStatus":1,"isAuthorized":false}
     * recAlbumsPanelTitle : 相关推荐
     * associationAlbumsInfo : [{"albumId":6436659,"title":"贾静雯带你游成都","coverSmall":"http://fdfs.xmcdn.com/group22/M05/81/94/wKgJM1h4luCj8w4cAAD55s_56wo250_mobile_small.jpg","coverMiddle":"http://fdfs.xmcdn.com/group22/M05/81/94/wKgJM1h4luCj8w4cAAD55s_56wo250_mobile_small.jpg","updatedAt":1488967209000,"uid":2501508,"recSrc":"cfItem","recTrack":"ra.ItemB.105","intro":"从这一刻，做一个气定神闲的成都人","isPaid":false},{"albumId":4687221,"title":"跟着格列佛-畅听卢浮宫","coverSmall":"http://fdfs.xmcdn.com/group21/M00/90/ED/wKgJLVh7FuaQFoduAAQZrLVoIyQ468_mobile_small.jpg","coverMiddle":"http://fdfs.xmcdn.com/group21/M00/90/ED/wKgJLVh7FuaQFoduAAQZrLVoIyQ468_mobile_small.jpg","updatedAt":1488606601000,"uid":26984746,"recSrc":"cfItem","recTrack":"ra.ItemB.105","intro":"环球旅行必备,最值得收听卢浮宫50个的展品最详细讲解","isPaid":true,"priceTypeEnum":2,"priceTypeId":2,"price":12.99,"discountedPrice":5.99,"displayPrice":"12.99喜点","displayDiscountedPrice":"5.99喜点"},{"albumId":2888955,"title":"你好，西藏","coverSmall":"http://fdfs.xmcdn.com/group11/M00/6E/A2/wKgDbVXXIAuQ-laYAAIrwiJmAuw185_mobile_small.jpg","coverMiddle":"http://fdfs.xmcdn.com/group11/M00/6E/A2/wKgDbVXXIAuQ-laYAAIrwiJmAuw185_mobile_small.jpg","updatedAt":1489620260000,"uid":20401328,"recSrc":"cfItem","recTrack":"ra.ItemB.105","intro":"为你讲述阿境三次入藏的点点滴滴","isPaid":false}]
     * userInfo : {"uid":17707629,"nickname":"浩然爸爸讲故事","isVerified":true,"smallLogo":"http://fdfs.xmcdn.com/group5/M04/A3/D2/wKgDtlRz-yizTJ8zAAgK5RCf-Z0479_mobile_small.jpg","followers":13663,"tracks":195,"albums":8,"ptitle":"专门为孩子们提供高品质听读资源。","personDescribe":"专门为孩子们提供高品质听读资源。","isOpenAskAndAnswer":false}
     * commentInfo : {"list":[{"id":23799050,"track_id":5890260,"uid":28330256,"nickname":"无日未雨非阴","smallHeader":"http://fdfs.xmcdn.com/group9/M0B/77/3E/wKgDYlYEGVmSnRZPAAFPtYkNhLg415_mobile_small.jpg","content":"背景音乐有夜的钢琴曲，好听","createdAt":1461743501000,"updatedAt":1461743501000,"parentId":23799050,"likes":4},{"id":33386010,"track_id":5890260,"uid":23139092,"nickname":"方便面蛋卷","smallHeader":"http://fdfs.xmcdn.com/group6/M03/7C/51/wKgDhFVCQ2-xOmr2AAF0YOzDQ3g303_mobile_small.jpg","content":"一段婚外情，一个懦弱的男人，被粉饰为一个爱而不得的故事，胡适私生活真是糜烂混乱","createdAt":1476055153000,"updatedAt":1476055153000,"parentId":33386010,"likes":3},{"id":11080923,"track_id":5890260,"uid":5303626,"nickname":"Jeff捷通","smallHeader":"http://qzapp.qlogo.cn/qzapp/100261563/E269D4FE1019639180F0028428799E19/30","content":"一段婚外情，粉饰成这样[嘻嘻]","createdAt":1434161148000,"updatedAt":1434161148000,"parentId":11080923,"likes":3},{"id":28648566,"track_id":5890260,"uid":55214030,"nickname":"quqi_d2","smallHeader":"http://fdfs.xmcdn.com/group23/M06/3D/36/wKgJNFiRnbvxST1GAACWDGVLgdk49_mobile_small.jpeg","content":"为什么不更新了呢？求继续更新","createdAt":1469276297000,"updatedAt":1469276297000,"parentId":28648566,"likes":2},{"id":14300048,"track_id":5890260,"uid":17523283,"nickname":"易梦君","smallHeader":"http://fdfs.xmcdn.com/group24/M09/1C/87/wKgJNVhotbOxASeSAAHRgFURB7g673_mobile_small.jpg","content":"还会再更吗 ？好喜欢","createdAt":1441235876000,"updatedAt":1441235876000,"parentId":14300048,"likes":2}],"pageId":1,"pageSize":5,"maxPageId":12,"totalCount":57}
     * countInfo : {"albumPlays":{"2888955":1254915,"4687221":14119,"314381":441742,"6436659":120506},"albumTracks":{"2888955":32,"4687221":48,"314381":9,"6436659":8},"albumSubscribes":{"314381":8372}}
     * trackRewardInfo : {"uid":17707629,"isOpen":false,"numOfRewards":0}
     * otherInfo : {}
     */

    private TrackInfoBean trackInfo;
    private AlbumInfoBean albumInfo;
    private String recAlbumsPanelTitle;
    private UserInfoBean userInfo;
    private CommentInfoBean commentInfo;
    private CountInfoBean countInfo;
    private TrackRewardInfoBean trackRewardInfo;
    private OtherInfoBean otherInfo;
    private List<AssociationAlbumsInfoBean> associationAlbumsInfo;

    public TrackInfoBean getTrackInfo() {
        return trackInfo;
    }

    public void setTrackInfo(TrackInfoBean trackInfo) {
        this.trackInfo = trackInfo;
    }

    public AlbumInfoBean getAlbumInfo() {
        return albumInfo;
    }

    public void setAlbumInfo(AlbumInfoBean albumInfo) {
        this.albumInfo = albumInfo;
    }

    public String getRecAlbumsPanelTitle() {
        return recAlbumsPanelTitle;
    }

    public void setRecAlbumsPanelTitle(String recAlbumsPanelTitle) {
        this.recAlbumsPanelTitle = recAlbumsPanelTitle;
    }

    public UserInfoBean getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfoBean userInfo) {
        this.userInfo = userInfo;
    }

    public CommentInfoBean getCommentInfo() {
        return commentInfo;
    }

    public void setCommentInfo(CommentInfoBean commentInfo) {
        this.commentInfo = commentInfo;
    }

    public CountInfoBean getCountInfo() {
        return countInfo;
    }

    public void setCountInfo(CountInfoBean countInfo) {
        this.countInfo = countInfo;
    }

    public TrackRewardInfoBean getTrackRewardInfo() {
        return trackRewardInfo;
    }

    public void setTrackRewardInfo(TrackRewardInfoBean trackRewardInfo) {
        this.trackRewardInfo = trackRewardInfo;
    }

    public OtherInfoBean getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(OtherInfoBean otherInfo) {
        this.otherInfo = otherInfo;
    }

    public List<AssociationAlbumsInfoBean> getAssociationAlbumsInfo() {
        return associationAlbumsInfo;
    }

    public void setAssociationAlbumsInfo(List<AssociationAlbumsInfoBean> associationAlbumsInfo) {
        this.associationAlbumsInfo = associationAlbumsInfo;
    }

    public static class TrackInfoBean {
        /**
         * trackId : 5890260
         * uid : 17707629
         * playUrl64 : http://fdfs.xmcdn.com/group6/M04/A3/46/wKgDhFUJFBDSU0kLAF-82w3EC8E516.mp3
         * playUrl32 : http://fdfs.xmcdn.com/group6/M04/A3/46/wKgDhFUJFBSjuFQ7AC_eklp7Gwk850.mp3
         * downloadUrl : http://download.xmcdn.com/group6/M04/A7/34/wKgDg1UJFATCNDM2ADGsLmUmILw341.aac
         * playPathAacv164 : http://audio.xmcdn.com/group11/M04/34/A2/wKgDa1WT2h2hYpq3AGDLJF_USOE108.m4a
         * playPathAacv224 : http://audio.xmcdn.com/group11/M04/34/A2/wKgDa1WT2h3gqlSIACT0Wyky0BY890.m4a
         * downloadAacUrl : http://download.xmcdn.com/group11/M04/34/A2/wKgDa1WT2h3gqlSIACT0Wyky0BY890.m4a
         * title : 杭州往事（9）：情似烟霞
         * duration : 783
         * isPaid : false
         * isFree : false
         * isAuthorized : false
         * priceTypeId : 0
         * sampleDuration : 0
         * priceTypeEnum : 0
         * priceTypes : []
         * categoryId : 22
         * processState : 2
         * createdAt : 1426658327000
         * coverSmall : http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_web_meduim.jpg
         * coverMiddle : http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_web_large.jpg
         * coverLarge : http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_mobile_large.jpg
         * isPublic : true
         * images : ["http://fdfs.xmcdn.com/group6/M04/A7/35/wKgDg1UJFBbj8mJvAAKheOviWMg326_mobile_large.jpg"]
         * status : 1
         * downloadSize : 3255342
         * downloadAacSize : 2421851
         * categoryName : 旅游
         * bulletSwitchType : 2
         * playPathHq :
         */

        private int trackId;
        private int uid;
        private String playUrl64;
        private String playUrl32;
        private String downloadUrl;
        private String playPathAacv164;
        private String playPathAacv224;
        private String downloadAacUrl;
        private String title;
        private int duration;
        private boolean isPaid;
        private boolean isFree;
        private boolean isAuthorized;
        private int priceTypeId;
        private int sampleDuration;
        private int priceTypeEnum;
        private int categoryId;
        private int processState;
        private long createdAt;
        private String coverSmall;
        private String coverMiddle;
        private String coverLarge;
        private boolean isPublic;
        private int status;
        private int downloadSize;
        private int downloadAacSize;
        private String categoryName;
        private int bulletSwitchType;
        private String playPathHq;
        private List<?> priceTypes;
        private List<String> images;

        public int getTrackId() {
            return trackId;
        }

        public void setTrackId(int trackId) {
            this.trackId = trackId;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getPlayUrl64() {
            return playUrl64;
        }

        public void setPlayUrl64(String playUrl64) {
            this.playUrl64 = playUrl64;
        }

        public String getPlayUrl32() {
            return playUrl32;
        }

        public void setPlayUrl32(String playUrl32) {
            this.playUrl32 = playUrl32;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

        public String getPlayPathAacv164() {
            return playPathAacv164;
        }

        public void setPlayPathAacv164(String playPathAacv164) {
            this.playPathAacv164 = playPathAacv164;
        }

        public String getPlayPathAacv224() {
            return playPathAacv224;
        }

        public void setPlayPathAacv224(String playPathAacv224) {
            this.playPathAacv224 = playPathAacv224;
        }

        public String getDownloadAacUrl() {
            return downloadAacUrl;
        }

        public void setDownloadAacUrl(String downloadAacUrl) {
            this.downloadAacUrl = downloadAacUrl;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public boolean isIsPaid() {
            return isPaid;
        }

        public void setIsPaid(boolean isPaid) {
            this.isPaid = isPaid;
        }

        public boolean isIsFree() {
            return isFree;
        }

        public void setIsFree(boolean isFree) {
            this.isFree = isFree;
        }

        public boolean isIsAuthorized() {
            return isAuthorized;
        }

        public void setIsAuthorized(boolean isAuthorized) {
            this.isAuthorized = isAuthorized;
        }

        public int getPriceTypeId() {
            return priceTypeId;
        }

        public void setPriceTypeId(int priceTypeId) {
            this.priceTypeId = priceTypeId;
        }

        public int getSampleDuration() {
            return sampleDuration;
        }

        public void setSampleDuration(int sampleDuration) {
            this.sampleDuration = sampleDuration;
        }

        public int getPriceTypeEnum() {
            return priceTypeEnum;
        }

        public void setPriceTypeEnum(int priceTypeEnum) {
            this.priceTypeEnum = priceTypeEnum;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public int getProcessState() {
            return processState;
        }

        public void setProcessState(int processState) {
            this.processState = processState;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }

        public String getCoverSmall() {
            return coverSmall;
        }

        public void setCoverSmall(String coverSmall) {
            this.coverSmall = coverSmall;
        }

        public String getCoverMiddle() {
            return coverMiddle;
        }

        public void setCoverMiddle(String coverMiddle) {
            this.coverMiddle = coverMiddle;
        }

        public String getCoverLarge() {
            return coverLarge;
        }

        public void setCoverLarge(String coverLarge) {
            this.coverLarge = coverLarge;
        }

        public boolean isIsPublic() {
            return isPublic;
        }

        public void setIsPublic(boolean isPublic) {
            this.isPublic = isPublic;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getDownloadSize() {
            return downloadSize;
        }

        public void setDownloadSize(int downloadSize) {
            this.downloadSize = downloadSize;
        }

        public int getDownloadAacSize() {
            return downloadAacSize;
        }

        public void setDownloadAacSize(int downloadAacSize) {
            this.downloadAacSize = downloadAacSize;
        }

        public String getCategoryName() {
            return categoryName;
        }

        public void setCategoryName(String categoryName) {
            this.categoryName = categoryName;
        }

        public int getBulletSwitchType() {
            return bulletSwitchType;
        }

        public void setBulletSwitchType(int bulletSwitchType) {
            this.bulletSwitchType = bulletSwitchType;
        }

        public String getPlayPathHq() {
            return playPathHq;
        }

        public void setPlayPathHq(String playPathHq) {
            this.playPathHq = playPathHq;
        }

        public List<?> getPriceTypes() {
            return priceTypes;
        }

        public void setPriceTypes(List<?> priceTypes) {
            this.priceTypes = priceTypes;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }

    public static class AlbumInfoBean {
        /**
         * albumId : 314381
         * categoryId : 22
         * title : 杭州往事
         * coverOrigin : http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280.jpg
         * coverSmall : http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_mobile_small.jpg
         * coverMiddle : http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_mobile_meduim.jpg
         * coverLarge : http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_mobile_large.jpg
         * coverWebLarge : http://fdfs.xmcdn.com/group5/M07/F5/30/wKgDtlSWlTqxr_KnAAKheOviWMg280_web_large.jpg
         * createdAt : 1419155049000
         * updatedAt : 1489124788000
         * uid : 17707629
         * intro : 这是一座历史悠久的城市 这是一座有人文灵魂的城市 这是一座用美丽打动人心的城市 这里，有说不尽的往事 微信公众号：nuoradio
         * tags : 浩然爸爸,杭州,杭州往事,历史人文,文化
         * hasNew : false
         * isFavorite : false
         * isPaid : false
         * status : 1
         * serializeStatus : 1
         * isAuthorized : false
         */

        private int albumId;
        private int categoryId;
        private String title;
        private String coverOrigin;
        private String coverSmall;
        private String coverMiddle;
        private String coverLarge;
        private String coverWebLarge;
        private long createdAt;
        private long updatedAt;
        private int uid;
        private String intro;
        private String tags;
        private boolean hasNew;
        private boolean isFavorite;
        private boolean isPaid;
        private int status;
        private int serializeStatus;
        private boolean isAuthorized;

        public int getAlbumId() {
            return albumId;
        }

        public void setAlbumId(int albumId) {
            this.albumId = albumId;
        }

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCoverOrigin() {
            return coverOrigin;
        }

        public void setCoverOrigin(String coverOrigin) {
            this.coverOrigin = coverOrigin;
        }

        public String getCoverSmall() {
            return coverSmall;
        }

        public void setCoverSmall(String coverSmall) {
            this.coverSmall = coverSmall;
        }

        public String getCoverMiddle() {
            return coverMiddle;
        }

        public void setCoverMiddle(String coverMiddle) {
            this.coverMiddle = coverMiddle;
        }

        public String getCoverLarge() {
            return coverLarge;
        }

        public void setCoverLarge(String coverLarge) {
            this.coverLarge = coverLarge;
        }

        public String getCoverWebLarge() {
            return coverWebLarge;
        }

        public void setCoverWebLarge(String coverWebLarge) {
            this.coverWebLarge = coverWebLarge;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }

        public long getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(long updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public boolean isHasNew() {
            return hasNew;
        }

        public void setHasNew(boolean hasNew) {
            this.hasNew = hasNew;
        }

        public boolean isIsFavorite() {
            return isFavorite;
        }

        public void setIsFavorite(boolean isFavorite) {
            this.isFavorite = isFavorite;
        }

        public boolean isIsPaid() {
            return isPaid;
        }

        public void setIsPaid(boolean isPaid) {
            this.isPaid = isPaid;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSerializeStatus() {
            return serializeStatus;
        }

        public void setSerializeStatus(int serializeStatus) {
            this.serializeStatus = serializeStatus;
        }

        public boolean isIsAuthorized() {
            return isAuthorized;
        }

        public void setIsAuthorized(boolean isAuthorized) {
            this.isAuthorized = isAuthorized;
        }
    }

    public static class UserInfoBean {
        /**
         * uid : 17707629
         * nickname : 浩然爸爸讲故事
         * isVerified : true
         * smallLogo : http://fdfs.xmcdn.com/group5/M04/A3/D2/wKgDtlRz-yizTJ8zAAgK5RCf-Z0479_mobile_small.jpg
         * followers : 13663
         * tracks : 195
         * albums : 8
         * ptitle : 专门为孩子们提供高品质听读资源。
         * personDescribe : 专门为孩子们提供高品质听读资源。
         * isOpenAskAndAnswer : false
         */

        private int uid;
        private String nickname;
        private boolean isVerified;
        private String smallLogo;
        private int followers;
        private int tracks;
        private int albums;
        private String ptitle;
        private String personDescribe;
        private boolean isOpenAskAndAnswer;

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public boolean isIsVerified() {
            return isVerified;
        }

        public void setIsVerified(boolean isVerified) {
            this.isVerified = isVerified;
        }

        public String getSmallLogo() {
            return smallLogo;
        }

        public void setSmallLogo(String smallLogo) {
            this.smallLogo = smallLogo;
        }

        public int getFollowers() {
            return followers;
        }

        public void setFollowers(int followers) {
            this.followers = followers;
        }

        public int getTracks() {
            return tracks;
        }

        public void setTracks(int tracks) {
            this.tracks = tracks;
        }

        public int getAlbums() {
            return albums;
        }

        public void setAlbums(int albums) {
            this.albums = albums;
        }

        public String getPtitle() {
            return ptitle;
        }

        public void setPtitle(String ptitle) {
            this.ptitle = ptitle;
        }

        public String getPersonDescribe() {
            return personDescribe;
        }

        public void setPersonDescribe(String personDescribe) {
            this.personDescribe = personDescribe;
        }

        public boolean isIsOpenAskAndAnswer() {
            return isOpenAskAndAnswer;
        }

        public void setIsOpenAskAndAnswer(boolean isOpenAskAndAnswer) {
            this.isOpenAskAndAnswer = isOpenAskAndAnswer;
        }
    }

    public static class CommentInfoBean {
        /**
         * list : [{"id":23799050,"track_id":5890260,"uid":28330256,"nickname":"无日未雨非阴","smallHeader":"http://fdfs.xmcdn.com/group9/M0B/77/3E/wKgDYlYEGVmSnRZPAAFPtYkNhLg415_mobile_small.jpg","content":"背景音乐有夜的钢琴曲，好听","createdAt":1461743501000,"updatedAt":1461743501000,"parentId":23799050,"likes":4},{"id":33386010,"track_id":5890260,"uid":23139092,"nickname":"方便面蛋卷","smallHeader":"http://fdfs.xmcdn.com/group6/M03/7C/51/wKgDhFVCQ2-xOmr2AAF0YOzDQ3g303_mobile_small.jpg","content":"一段婚外情，一个懦弱的男人，被粉饰为一个爱而不得的故事，胡适私生活真是糜烂混乱","createdAt":1476055153000,"updatedAt":1476055153000,"parentId":33386010,"likes":3},{"id":11080923,"track_id":5890260,"uid":5303626,"nickname":"Jeff捷通","smallHeader":"http://qzapp.qlogo.cn/qzapp/100261563/E269D4FE1019639180F0028428799E19/30","content":"一段婚外情，粉饰成这样[嘻嘻]","createdAt":1434161148000,"updatedAt":1434161148000,"parentId":11080923,"likes":3},{"id":28648566,"track_id":5890260,"uid":55214030,"nickname":"quqi_d2","smallHeader":"http://fdfs.xmcdn.com/group23/M06/3D/36/wKgJNFiRnbvxST1GAACWDGVLgdk49_mobile_small.jpeg","content":"为什么不更新了呢？求继续更新","createdAt":1469276297000,"updatedAt":1469276297000,"parentId":28648566,"likes":2},{"id":14300048,"track_id":5890260,"uid":17523283,"nickname":"易梦君","smallHeader":"http://fdfs.xmcdn.com/group24/M09/1C/87/wKgJNVhotbOxASeSAAHRgFURB7g673_mobile_small.jpg","content":"还会再更吗 ？好喜欢","createdAt":1441235876000,"updatedAt":1441235876000,"parentId":14300048,"likes":2}]
         * pageId : 1
         * pageSize : 5
         * maxPageId : 12
         * totalCount : 57
         */

        private int pageId;
        private int pageSize;
        private int maxPageId;
        private int totalCount;
        private List<ListBean> list;

        public int getPageId() {
            return pageId;
        }

        public void setPageId(int pageId) {
            this.pageId = pageId;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getMaxPageId() {
            return maxPageId;
        }

        public void setMaxPageId(int maxPageId) {
            this.maxPageId = maxPageId;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 23799050
             * track_id : 5890260
             * uid : 28330256
             * nickname : 无日未雨非阴
             * smallHeader : http://fdfs.xmcdn.com/group9/M0B/77/3E/wKgDYlYEGVmSnRZPAAFPtYkNhLg415_mobile_small.jpg
             * content : 背景音乐有夜的钢琴曲，好听
             * createdAt : 1461743501000
             * updatedAt : 1461743501000
             * parentId : 23799050
             * likes : 4
             */

            private int id;
            private int track_id;
            private int uid;
            private String nickname;
            private String smallHeader;
            private String content;
            private long createdAt;
            private long updatedAt;
            private int parentId;
            private int likes;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getTrack_id() {
                return track_id;
            }

            public void setTrack_id(int track_id) {
                this.track_id = track_id;
            }

            public int getUid() {
                return uid;
            }

            public void setUid(int uid) {
                this.uid = uid;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getSmallHeader() {
                return smallHeader;
            }

            public void setSmallHeader(String smallHeader) {
                this.smallHeader = smallHeader;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public long getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(long createdAt) {
                this.createdAt = createdAt;
            }

            public long getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(long updatedAt) {
                this.updatedAt = updatedAt;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public int getLikes() {
                return likes;
            }

            public void setLikes(int likes) {
                this.likes = likes;
            }
        }
    }

    public static class CountInfoBean {
        /**
         * albumPlays : {"2888955":1254915,"4687221":14119,"314381":441742,"6436659":120506}
         * albumTracks : {"2888955":32,"4687221":48,"314381":9,"6436659":8}
         * albumSubscribes : {"314381":8372}
         */

        private AlbumPlaysBean albumPlays;
        private AlbumTracksBean albumTracks;
        private AlbumSubscribesBean albumSubscribes;

        public AlbumPlaysBean getAlbumPlays() {
            return albumPlays;
        }

        public void setAlbumPlays(AlbumPlaysBean albumPlays) {
            this.albumPlays = albumPlays;
        }

        public AlbumTracksBean getAlbumTracks() {
            return albumTracks;
        }

        public void setAlbumTracks(AlbumTracksBean albumTracks) {
            this.albumTracks = albumTracks;
        }

        public AlbumSubscribesBean getAlbumSubscribes() {
            return albumSubscribes;
        }

        public void setAlbumSubscribes(AlbumSubscribesBean albumSubscribes) {
            this.albumSubscribes = albumSubscribes;
        }

        public static class AlbumPlaysBean {
            /**
             * 2888955 : 1254915
             * 4687221 : 14119
             * 314381 : 441742
             * 6436659 : 120506
             */

            @SerializedName("2888955")
            private int _$2888955;
            @SerializedName("4687221")
            private int _$4687221;
            @SerializedName("314381")
            private int _$314381;
            @SerializedName("6436659")
            private int _$6436659;

            public int get_$2888955() {
                return _$2888955;
            }

            public void set_$2888955(int _$2888955) {
                this._$2888955 = _$2888955;
            }

            public int get_$4687221() {
                return _$4687221;
            }

            public void set_$4687221(int _$4687221) {
                this._$4687221 = _$4687221;
            }

            public int get_$314381() {
                return _$314381;
            }

            public void set_$314381(int _$314381) {
                this._$314381 = _$314381;
            }

            public int get_$6436659() {
                return _$6436659;
            }

            public void set_$6436659(int _$6436659) {
                this._$6436659 = _$6436659;
            }
        }

        public static class AlbumTracksBean {
            /**
             * 2888955 : 32
             * 4687221 : 48
             * 314381 : 9
             * 6436659 : 8
             */

            @SerializedName("2888955")
            private int _$2888955;
            @SerializedName("4687221")
            private int _$4687221;
            @SerializedName("314381")
            private int _$314381;
            @SerializedName("6436659")
            private int _$6436659;

            public int get_$2888955() {
                return _$2888955;
            }

            public void set_$2888955(int _$2888955) {
                this._$2888955 = _$2888955;
            }

            public int get_$4687221() {
                return _$4687221;
            }

            public void set_$4687221(int _$4687221) {
                this._$4687221 = _$4687221;
            }

            public int get_$314381() {
                return _$314381;
            }

            public void set_$314381(int _$314381) {
                this._$314381 = _$314381;
            }

            public int get_$6436659() {
                return _$6436659;
            }

            public void set_$6436659(int _$6436659) {
                this._$6436659 = _$6436659;
            }
        }

        public static class AlbumSubscribesBean {
            /**
             * 314381 : 8372
             */

            @SerializedName("314381")
            private int _$314381;

            public int get_$314381() {
                return _$314381;
            }

            public void set_$314381(int _$314381) {
                this._$314381 = _$314381;
            }
        }
    }

    public static class TrackRewardInfoBean {
    }

    public static class OtherInfoBean {
    }

    public static class AssociationAlbumsInfoBean {
        /**
         * albumId : 6436659
         * title : 贾静雯带你游成都
         * coverSmall : http://fdfs.xmcdn.com/group22/M05/81/94/wKgJM1h4luCj8w4cAAD55s_56wo250_mobile_small.jpg
         * coverMiddle : http://fdfs.xmcdn.com/group22/M05/81/94/wKgJM1h4luCj8w4cAAD55s_56wo250_mobile_small.jpg
         * updatedAt : 1488967209000
         * uid : 2501508
         * recSrc : cfItem
         * recTrack : ra.ItemB.105
         * intro : 从这一刻，做一个气定神闲的成都人
         * isPaid : false
         * priceTypeEnum : 2
         * priceTypeId : 2
         * price : 12.99
         * discountedPrice : 5.99
         * displayPrice : 12.99喜点
         * displayDiscountedPrice : 5.99喜点
         */

        private int albumId;
        private String title;
        private String coverSmall;
        private String coverMiddle;
        private long updatedAt;
        private int uid;
        private String recSrc;
        private String recTrack;
        private String intro;
        private boolean isPaid;
        private int priceTypeEnum;
        private int priceTypeId;
        private double price;
        private double discountedPrice;
        private String displayPrice;
        private String displayDiscountedPrice;

        public int getAlbumId() {
            return albumId;
        }

        public void setAlbumId(int albumId) {
            this.albumId = albumId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCoverSmall() {
            return coverSmall;
        }

        public void setCoverSmall(String coverSmall) {
            this.coverSmall = coverSmall;
        }

        public String getCoverMiddle() {
            return coverMiddle;
        }

        public void setCoverMiddle(String coverMiddle) {
            this.coverMiddle = coverMiddle;
        }

        public long getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(long updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int getUid() {
            return uid;
        }

        public void setUid(int uid) {
            this.uid = uid;
        }

        public String getRecSrc() {
            return recSrc;
        }

        public void setRecSrc(String recSrc) {
            this.recSrc = recSrc;
        }

        public String getRecTrack() {
            return recTrack;
        }

        public void setRecTrack(String recTrack) {
            this.recTrack = recTrack;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public boolean isIsPaid() {
            return isPaid;
        }

        public void setIsPaid(boolean isPaid) {
            this.isPaid = isPaid;
        }

        public int getPriceTypeEnum() {
            return priceTypeEnum;
        }

        public void setPriceTypeEnum(int priceTypeEnum) {
            this.priceTypeEnum = priceTypeEnum;
        }

        public int getPriceTypeId() {
            return priceTypeId;
        }

        public void setPriceTypeId(int priceTypeId) {
            this.priceTypeId = priceTypeId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getDiscountedPrice() {
            return discountedPrice;
        }

        public void setDiscountedPrice(double discountedPrice) {
            this.discountedPrice = discountedPrice;
        }

        public String getDisplayPrice() {
            return displayPrice;
        }

        public void setDisplayPrice(String displayPrice) {
            this.displayPrice = displayPrice;
        }

        public String getDisplayDiscountedPrice() {
            return displayDiscountedPrice;
        }

        public void setDisplayDiscountedPrice(String displayDiscountedPrice) {
            this.displayDiscountedPrice = displayDiscountedPrice;
        }
    }
}
