package com.example.kevinlay.androidfundamentalspractice.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kevinlay on 1/4/18.
 */

public class MySubParcelable implements Parcelable {
    protected MySubParcelable(Parcel in) {
    }

    public static final Creator<MySubParcelable> CREATOR = new Creator<MySubParcelable>() {
        @Override
        public MySubParcelable createFromParcel(Parcel in) {
            return new MySubParcelable(in);
        }

        @Override
        public MySubParcelable[] newArray(int size) {
            return new MySubParcelable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
