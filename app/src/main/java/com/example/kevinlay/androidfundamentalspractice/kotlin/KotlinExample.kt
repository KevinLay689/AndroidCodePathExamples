package com.example.kevinlay.androidfundamentalspractice.kotlin

/**
 * Created by kevinlay on 1/19/18.
 */
class KotlinExample {
    // Expression Bodies
    // If a function is written with its body in curly braces, we say that this function has a
    // block body. If it returns an expression directly, it has an expression body.
    // Can omit the return type
    fun max(a: Int, b: Int): Int = if (a > b) a else b

    // Kotlin allows you to refer to local variables in string literals by putting the $
    // character in front of the variable name. This is equivalent to Java’s string concatenation
    // ( "Hello, " + name + "!"
    fun main(args: Array<String>) {
        val name = if (args.size > 0) args[0] else "Kotlin"
        println("Hello, $name!")
    }

    // When creating objects, don't use the new keyword
    // Properties are accessed directly but actually call getters
    fun test() {
        val userk = UserK("", 0)
        val isbn = userk.isbn
        val rect = Rectangle(44,45)
        println(rect.isSquare)
    }

    // Custom getter
    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
        get() {
            return height == width
        }
    }
}