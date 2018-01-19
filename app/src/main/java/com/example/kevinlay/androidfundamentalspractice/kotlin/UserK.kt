package com.example.kevinlay.androidfundamentalspractice.kotlin

import java.util.*

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

    fun testMethod() {
        // Booleans are either true or false
        if (true is Boolean){
            print("true is boolean\n")
        }

        var myArray = arrayOf(1, 1.23, "Doug")

        // You can access values using indexes starting at 0
        println(myArray[2])

        // Change the value
        myArray[1] = 3.14
        println(myArray[1])

        val age = 8

        // When works like Switch in other languages
        when (age) {

        // Match a list
            0,1,2,3,4 -> println("Go to Preschool")

        // Match a specific value
            5 -> println("Go to Kindergarten")

        // Match a range
            in 6..17 -> {
                val grade = age - 5
                println("Go to Grade $grade")
            }

        // Default
            else -> println("Go to College")
        }

        // ----- LOOPING -----
        // You can use for loops to cycle through arrays
        // ranges, or anything else that implements the
        // iterator function

        for (x in 1..10){
            println("Loop : $x")
        }

        // Generate a random number from 1 to 50
        val rand = Random()
        val magicNum = rand.nextInt(50) + 1

        // While loops while a condition is true
        var guess = 0

        while(magicNum != guess){
            guess += 1
        }

        println("Magic num is $magicNum and you guessed $guess")

        for (x in 1..20){
            if (x % 2 == 0) {

                // Continue jumps back to the top of the loop
                continue
            }

            println("Odd : $x")

            // Break jumps out of the loop and stops looping
            if (x == 15) break

        }
    }

    fun describeString(maybeString: String?): String {              // 1
        if (maybeString != null && maybeString.length > 0) {        // 2
            return "String of length ${maybeString.length}"
        } else {
            return "Empty or null string"
        }
    }
    //1. A function that takes in a nullable String and gives you a phrase describing it
    //2. If the given String is not null and not empty, tell the caller about it’s length

    fun infoOnNull() {
        var neverNull: String = "This can't be null"            // 1

        var nullable: String? = "You can keep a null here"      // 2

        nullable = null                                         // 3

        var inferredNonNull = "The compiler assumes non-null"   // 4
    }

    //1. Declare a non-null String variable
    //2. Declare a nullable String variable
    //3. Set the nullable variable to null
    //4. When infering types, the compiler assumes non-null for variables that are initialized with a value
}



