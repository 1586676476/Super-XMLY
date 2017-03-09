package com.jieleo.xmly_plus.model.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by yuyongjie on 17/3/9.
 */


public class TabWordsBean implements Parcelable{

    /**
     * ret : 0
     * msg : 成功
     * tabs : {"count":5,"first":1,"list":[{"title":"推荐","contentType":"recSys","url":""},{"title":"热门","contentType":"recommend","url":""},{"title":"分类","contentType":"category"},{"title":"榜单","contentType":"ranking"},{"title":"主播","contentType":"anchor"}]}
     */

    private int ret;
    private String msg;
    private TabsBean tabs;

    public TabWordsBean() {
    }

    protected TabWordsBean(Parcel in) {
        ret = in.readInt();
        msg = in.readString();
        tabs = in.readParcelable(TabsBean.class.getClassLoader());
    }

    public static final Creator<TabWordsBean> CREATOR = new Creator<TabWordsBean>() {
        @Override
        public TabWordsBean createFromParcel(Parcel in) {
            return new TabWordsBean(in);
        }

        @Override
        public TabWordsBean[] newArray(int size) {
            return new TabWordsBean[size];
        }
    };

    public int getRet() {
        return ret;
    }

    public void setRet(int ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public TabsBean getTabs() {
        return tabs;
    }

    public void setTabs(TabsBean tabs) {
        this.tabs = tabs;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ret);
        dest.writeString(msg);
        dest.writeParcelable(tabs, flags);
    }

    public static class TabsBean implements Parcelable{
        /**
         * count : 5
         * first : 1
         * list : [{"title":"推荐","contentType":"recSys","url":""},{"title":"热门","contentType":"recommend","url":""},{"title":"分类","contentType":"category"},{"title":"榜单","contentType":"ranking"},{"title":"主播","contentType":"anchor"}]
         */

        private int count;
        private int first;
        private List<ListBean> list;

        protected TabsBean(Parcel in) {
            count = in.readInt();
            first = in.readInt();
            list = in.createTypedArrayList(ListBean.CREATOR);
        }

        public static final Creator<TabsBean> CREATOR = new Creator<TabsBean>() {
            @Override
            public TabsBean createFromParcel(Parcel in) {
                return new TabsBean(in);
            }

            @Override
            public TabsBean[] newArray(int size) {
                return new TabsBean[size];
            }
        };

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(count);
            dest.writeInt(first);
            dest.writeTypedList(list);
        }

        public static class ListBean implements Parcelable{
            /**
             * title : 推荐
             * contentType : recSys
             * url :
             */

            private String title;
            private String contentType;
            private String url;

            protected ListBean(Parcel in) {
                title = in.readString();
                contentType = in.readString();
                url = in.readString();
            }

            public static final Creator<ListBean> CREATOR = new Creator<ListBean>() {
                @Override
                public ListBean createFromParcel(Parcel in) {
                    return new ListBean(in);
                }

                @Override
                public ListBean[] newArray(int size) {
                    return new ListBean[size];
                }
            };

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContentType() {
                return contentType;
            }

            public void setContentType(String contentType) {
                this.contentType = contentType;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(title);
                dest.writeString(contentType);
                dest.writeString(url);
            }
        }
    }
}
