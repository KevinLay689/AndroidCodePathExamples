package com.example.kevinlay.androidfundamentalspractice.kotlin

import android.content.Context
import android.util.AttributeSet
import android.view.View

/**
 * Created by kevinlay on 1/21/18.
 */
class KotlinClassesAndObjects {
    // Classes and inheritance
    // A class in Kotlin can have a primary constructor and one or more secondary constructors.
    // The primary constructor is part of the class header: it goes after the class name (and optional type parameters).
    class Person(firstName: String) {

    }
    // Primary constructor cannot contain code, must use init block
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
    // For declaring properties and initializing them from the primary constructor, Kotlin has a concise syntax:
    class Person2(val firstName: String, val lastName: String, var age: Int) {
        // ...
    }
    // If the class has no primary constructor, then each secondary constructor has to initialize
    // the base type using the super keyword, or to delegate to another constructor which does that.
    // Note that in this case different secondary constructors can call different constructors of the base type:
    class MyView : View {
        constructor(ctx: Context) : super(ctx)
        constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
    }
    // Overriding Methods
    // The override annotation is required for Derived.v(). If it were missing, the compiler would complain.
    // If there is no open annotation on a function, like Base.nv(), declaring a method with the same
    // signature in a subclass is illegal, either with override or without it.
    open class Base {
        open fun v() {}
        fun nv() {}
    }

    class Derived() : Base() {
        override fun v() {}
    }

    // A member marked override is itself open, i.e. it may be overridden in subclasses. If you want
    // to prohibit re-overriding, use final:

    open class AnotherDerived() : Base() {
        final override fun v() {}
    }




}