package com.jhonlee.homenews.pojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by JhoneLee on 2017/2/20.
 */

public class Message implements Parcelable{

    private int mType;
    private String mMessage;

    public Message(Parcel in) {
        mType = in.readInt();
        mMessage = in.readString();
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    public String getmMessage() {
        return mMessage;
    }

    public void setmMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    public int getmType() {
        return mType;
    }

    public void setmType(int mType) {
        this.mType = mType;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mType);
        parcel.writeString(mMessage);
    }
}
