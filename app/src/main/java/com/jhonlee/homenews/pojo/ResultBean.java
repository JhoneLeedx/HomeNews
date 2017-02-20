package com.jhonlee.homenews.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by JhoneLee on 2017/2/6.
 */

public class ResultBean implements Parcelable {

    /**
     * _id : 583bf8f0421aa9710cf54c45
     * createdAt : 2016-11-28T17:29:20.600Z
     * desc : iOS平台键盘再也不会挡住输入控件
     * images : ["http://img.gank.io/c9bdeea9-d931-4daf-a599-38fcdc40e39f"]
     * publishedAt : 2016-11-29T11:38:58.378Z
     * source : web
     * type : iOS
     * url : https://github.com/netyouli/WHC_KeyboardManager
     * used : true
     * who : 吴海超(WHC)
     */

    private String _id;
    private String createdAt;
    private String desc;
    private String publishedAt;
    private String source;
    private String type;
    private String url;
    private boolean used;
    private String who;
    private List<String> images;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ResultBean> CREATOR = new Creator<ResultBean>() {
        @Override
        public ResultBean createFromParcel(Parcel in) {
            return new ResultBean(in);
        }

        @Override
        public ResultBean[] newArray(int size) {
            return new ResultBean[size];
        }
    };
    protected ResultBean(Parcel in) {
        _id = in.readString();
        createdAt = in.readString();
        desc = in.readString();
        publishedAt = in.readString();
        source = in.readString();
        type = in.readString();
        url = in.readString();
        used = in.readByte() != 0;
        who = in.readString();
        images = in.createStringArrayList();
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(_id);
        parcel.writeString(createdAt);
        parcel.writeString(desc);
        parcel.writeString(publishedAt);
        parcel.writeString(source);
        parcel.writeString(type);
        parcel.writeString(url);
        parcel.writeByte((byte) (used ? 1 : 0));
        parcel.writeString(who);
        parcel.writeStringList(images);
    }


}
