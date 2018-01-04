package com.example.kevinlay.androidfundamentalspractice.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by kevinlay on 1/4/18.
 */

public class MySubParcelable implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
