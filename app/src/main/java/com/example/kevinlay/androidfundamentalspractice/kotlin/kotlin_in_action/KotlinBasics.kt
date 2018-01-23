package com.example.kevinlay.androidfundamentalspractice.kotlin.kotlin_in_action

/**
 * Created by kevinlay on 1/22/18.
 */
class KotlinBasics {

    // 2.1.1 Hello, world!
    fun main(args: Array<String>) {
        println("Hello, world!")
    }

    // 2.1.2 Functions
    // Note that in Kotlin, if is an expression with a result value. It’s similar to a ternary operator in Java
    // In Kotlin, if is an expression, not a statement. The difference between a statement and an
    // expression is that an expression has a value
    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }
    // EXPRESSION BODIES
    // You can simplify the previous function even further. Because its body consists of just a
    // single expression, you can use that expression as the entire body of the function, removing
    // the curly braces and the return statement:
    // Can also omit return type
    fun max2(a: Int, b: Int): Int = if (a > b) a else b

    // 2.1.3 Variables
    // val (from value)—Immutable reference.
    // var (from variable)—Mutable reference.
    val answer : Int = 5
    var answer2 : Int = 5

    // 2.1.4 Easier string formatting: string templates
    // This is equivalent to Java’s string concatenation
    // ( "Hello, " + name + "!") but is more compact and just as efficient.
    // If you need to include the $ character in a string, you escape it: println("\$x")
    // println("Hello, ${args[0]}!") - Uses the ${} syntax to insert the first element of the args array
    fun main2(args: Array<String>) {
        val name = if (args.size > 0) args[0] else "Kotlin"
        println("Hello, $name!")
    }
}