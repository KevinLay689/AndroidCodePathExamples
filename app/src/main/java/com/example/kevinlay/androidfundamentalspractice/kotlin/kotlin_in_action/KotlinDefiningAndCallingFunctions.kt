package com.example.kevinlay.androidfundamentalspractice.kotlin.kotlin_in_action

/**
 * Created by kevinlay on 1/23/18.
 */
class KotlinDefiningAndCallingFunctions {
    /**
     * 3.1 Creating collections in Kotlin
     */
    // println(set.javaClass) - javaClass is getClass() in kotlin
    // Kotlin collections have methods like last() and max()
    val set = setOf(1, 7, 53)
    val list = listOf(1, 7, 53)
    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-three")

    /**
     * 3.2 Making functions easier to call
     */
    // Java collections have a default toString implementation, but the formatting of the
    // output is fixed and not always what you need, printing list invokes toString()
    fun printList() {
        println(list)
    }
    // 3.2.1
    // The first problem we’ll address concerns the readability of function calls.
    // joinToString(collection, separator = " ", prefix = " ", postfix = ".")
    // can use strings in parameter to identify the parameters passed
    // When calling a method written in Kotlin, you can specify the names of some
    // arguments that you’re passing to the function.
}