package com.example.kevinlay.androidfundamentalspractice.NetworkAndModels.RetrofitGithub;

/**
 * Created by kevinlay on 12/8/17.
 */

public class GitUser {
    String name;
    String url;
    int id;

    @Override
    public String toString() {
        return "name = " + name + "\nurl = " + url + "\nid = " + id;
    }
}