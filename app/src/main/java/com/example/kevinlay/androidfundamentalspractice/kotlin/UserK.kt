package com.example.kevinlay.androidfundamentalspractice.kotlin

/**
 * Created by kevinlay on 1/17/18.
 */
class UserK {
    var title: String
    var isbn: Long

    constructor(title: String, isbn: Long) {
        this.title = title
        this.isbn = isbn
    }

    fun showDetails(): String {
        return title + isbn
    }
}

