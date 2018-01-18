package com.example.kevinlay.androidfundamentalspractice.kotlin

/**
 * Created by kevinlay on 1/17/18.
 */
open class Foo {
    open fun f() { println("Foo.f()") }
    open fun p() : String { return "p" }
    open val x: Int get() = 1
}
