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
}

