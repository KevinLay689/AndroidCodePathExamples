package com.example.kevinlay.androidfundamentalspractice.kotlin

import android.content.Context
import android.util.AttributeSet
import android.view.View

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
        println(Color.BLUE.rgb())
    }

    // Custom getter
    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
        get() {
            return height == width
        }
    }
    // Declares properties of enum constants
    enum class Color(val r: Int, val g: Int, val b: Int) {
        // Specifies property values when each constant is created
        RED(255, 0, 0), ORANGE(255, 165, 0),
        YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
        // The semicolon here is required.
        INDIGO(75, 0, 130), VIOLET(238, 130, 238);
        // Defines a method on the enum class
        fun rgb() = (r * 256 + g) * 256 + b
    }

    fun getMnemonic(color: Color) =
            when (color) {
                Color.RED -> "Richard"
                Color.ORANGE -> "Of"
                Color.YELLOW -> "York"
                Color.GREEN -> "Gave"
                Color.BLUE -> "Battle"
                Color.INDIGO -> "In"
                Color.VIOLET -> "Vain"
            }

    // Primary contructor can't contain any code
    // Use init to initialize variables
    // During an instance initialization, the initializer blocks are executed in the same order as
    // they appear in the class body, interleaved with the property initializers:

    class InitOrderDemo(name: String) {
        val firstProperty = "First property: $name".also(::println)

        init {
            println("First initializer block that prints ${name}")
        }

        val secondProperty = "Second property: ${name.length}".also(::println)

        init {
            println("Second initializer block that prints ${name.length}")
        }
    }

    // Secondary Constructors
    // The class can also declare secondary constructors, which are prefixed with constructor:
    // If the class has a primary constructor, each secondary constructor needs to delegate to the
    // primary constructor, either directly or indirectly through another secondary constructor(s).
    // Delegation to another constructor of the same class is done using the this keyword:

    class Person(val name: String) {
        constructor(name: String, parent: Person) : this(name) {
            //parent.children.add(this)
        }
    }

    // If the class has no primary constructor, then each secondary constructor has to initialize the
    // base type using the super keyword, or to delegate to another constructor which does that. Note
    // that in this case different secondary constructors can call different constructors of the base type:

    class MyView : View {
        constructor(ctx: Context) : super(ctx)
        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    }


}