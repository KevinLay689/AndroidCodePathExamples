package com.example.kevinlay.androidfundamentalspractice.kotlin

/**
 * Kotlin Class example
 *
 * -Primary constructor is added after the class definition
 * -Inherit classes with using classname()
 * -Return type is defined after method
 * -To inherit a class the subclass must be defined as open
 * -Everything is final in Kotlin by default
 */
class UserK(var title: String, var isbn: Long) : Foo() {

    fun showDetails(): String {
        return title + isbn
    }
}

