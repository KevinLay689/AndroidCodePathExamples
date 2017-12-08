package com.example.kevinlay.androidfundamentalspractice.NetworkAndModels;

/**
 * GithubRepo Class
 *
 * This class is a used to map the Json Return from Retrofit
 * -Use @SerializedName("x") to annotate any name so you can change the name of the actual property
 *  but still have it map correctly
 *      Example
 *         @SerializedName("id")
 *         private int mId;
 *      We can choose the name we want id to map to
 */

public class GithubRepo {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
