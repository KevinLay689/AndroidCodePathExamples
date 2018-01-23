package com.example.kevinlay.androidfundamentalspractice.kotlin

/**
 * Created by kevinlay on 1/21/18.
 */
class KotlinPropertiesAndFields {
    // Getters and Setters
    var initialized = 1 // has type Int, default getter and setter
    val inferredType = 1 // has type Int and a default getter
    // We can write custom accessors, very much like ordinary functions, right inside a property declaration. Here's an example of a custom getter:
    val isEmpty: Boolean
        get() = this.initialized == 0
    // A custom setter looks like this:
    var stringRepresentation: String
        get() = this.toString()
        set(value) {
            setDataFromString(value) // parses the string and assigns values to other properties
        }
    fun setDataFromString(value : String) : String {
        return value
    }
}