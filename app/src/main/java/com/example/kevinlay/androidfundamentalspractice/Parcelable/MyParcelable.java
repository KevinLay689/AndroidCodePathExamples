package com.example.kevinlay.androidfundamentalspractice.Parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * This class demonstrates how to implement Parcelable for a java class
 * Parcelables allow java objects to be passed through IPC like intents
 *
 * Steps to implementing Parcelable
 *      1. Implement the Parcelable interface
 *          1a. Must override methods describeContents() and writeToParcel()
 *          1b. WriteToParcel() is in charge of saving your values for the object
 *          1c. DescribeContents() can usually just return 0
 *      2. Create a constructor that accepts a Parcelable, it is in charge of restoring the values back to the object
 *      3. Create the public static CREATOR constant
 *          3a. Looks like: public static final Parcelable.Creator<MyParcelable> CREATOR = new Parcelable.Creator<MyParcelable>() {}
 *          3b. The CREATOR must implement createFromParcel() and newArray()
 *          3c. CreateFromParcel() returns a new Object using the constructor we created that accepts a Parcleable
 *          3d. NewArray() returns an object, given an array.
 *
 * Retrieve the Parcelable in other activity with getIntent().getParcelableExtra("myDataKey");
 *
 * Tips for implementing Parcelable
 *      -Order matters when you read and write your values to the Parcelable, they must match up in both cases
 *      -Can only put primitives in the Parcelable, dates must convert to longs, etc
 *      -No Boolean, best way to store bool is with a byte
 *          -Example. out.writeByte((byte) (myBoolean ? 1 : 0));
 *          and retrieve it similarly with myBoolean = in.readByte() != 0;
 */

public class MyParcelable implements Parcelable {
    // You can include parcel data types
    private int mData;
    private String mName;

    // We can also include child Parcelable objects. Assume MySubParcel is such a Parcelable:
    private MySubParcelable mInfo;

    // This is where you write the values you want to save to the `Parcel`.
    // The `Parcel` class has methods defined to help you save all of your values.
    // Note that there are only methods defined for simple values, lists, and other Parcelable objects.
    // You may need to make several classes Parcelable to send the data you want.
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(mData);
        out.writeString(mName);
        out.writeParcelable(mInfo, flags);
    }

    // Using the `in` variable, we can retrieve the values that
    // we originally wrote into the `Parcel`.  This constructor is usually
    // private so that only the `CREATOR` field can access.
    private MyParcelable(Parcel in) {
        mData = in.readInt();
        mName = in.readString();
        mInfo = in.readParcelable(MySubParcelable.class.getClassLoader());
    }

    public MyParcelable() {
        // Normal actions performed by class, since this is still a normal object!
    }

    // In the vast majority of cases you can simply return 0 for this.
    // There are cases where you need to use the constant `CONTENTS_FILE_DESCRIPTOR`
    // But this is out of scope of this tutorial
    @Override
    public int describeContents() {
        return 0;
    }

    // After implementing the `Parcelable` interface, we need to create the
    // `Parcelable.Creator<MyParcelable> CREATOR` constant for our class;
    // Notice how it has our class specified as its type.
    public static final Parcelable.Creator<MyParcelable> CREATOR
            = new Parcelable.Creator<MyParcelable>() {

        // This simply calls our new constructor (typically private) and
        // passes along the unmarshalled `Parcel`, and then returns the new object!
        @Override
        public MyParcelable createFromParcel(Parcel in) {
            return new MyParcelable(in);
        }

        // We just need to copy this and change the type to match our class.
        @Override
        public MyParcelable[] newArray(int size) {
            return new MyParcelable[size];
        }
    };
}