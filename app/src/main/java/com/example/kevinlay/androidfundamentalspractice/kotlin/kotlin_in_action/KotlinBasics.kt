package com.example.kevinlay.androidfundamentalspractice.kotlin.kotlin_in_action

/**
 * Created by kevinlay on 1/22/18.
 */
class KotlinBasics {

    /**
     * 2.1 Basic elements: functions and variables
     */
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

    /**
     * 2.2 Classes and properties
     */
    // 2.2.1 Properties
    // Now, instead of invoking the getter, you reference the property directly. The logic
    // stays the same, but the code is more concise. Setters of mutable properties work the same
    // way: while in Java, you use person.setMarried(false) to tell about a divorce; in
    // Kotlin, you can write person.isMarried = false.
    class Person(
            val name: String,
            var isMarried: Boolean
    )
    val name : String = Person("Kevin", false).name

    // 2.2.2 Custom accessors
    // Custom getter for isSquare
    // The property isSquare doesn’t need a field to store its value. It only has a custom
    // getter with the implementation provided. The value is computed every time the property
    // is accessed
    class Rectangle(val height: Int, val width: Int) {
        val isSquare: Boolean
        get() {
            return height == width
        }
    }

    /**
     * 2.3 Representing and handling choices: enums and 'when'
     */
    // 2.3.1 Declaring enum classes
    // Just as in Java, enums aren’t lists of values: you can declare properties and methods
    // on enum classes.
    enum class Color(val r: Int, val g: Int, val b: Int) {
        RED(255, 0, 0), ORANGE(255, 165, 0),
        YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
        INDIGO(75, 0, 130), VIOLET(238, 130, 238);
        fun rgb() = (r * 256 + g) * 256 + b
    }

    // 2.3.2 Using 'when' to deal with enum classes
    // when is the java statement for switch
    // when is an expression that returns a value, so you can write a function with
    // an expression body, returning the when expression directly
    // You can also combine multiple values in the same branch if you separate them with commas
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

    // 2.3.3 Using 'when' with arbitrary objects
    // Unlike switch, which requires you to use constants (enum constants, strings, or number literals) as
    // branch conditions, when allows any objects.
    fun mix(c1: Color, c2: Color) =
            when (setOf(c1, c2)) {
                setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
                setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
                setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
                else -> throw Exception("Dirty color")
            }

    // 2.3.4 Using 'when' without
    // If no argument is supplied for the when expression, the branch condition is any
    // boolean expression
    fun mixOptimized(c1: Color, c2: Color) =
            when {
                (c1 == Color.RED && c2 == Color.YELLOW) ||
                        (c1 == Color.YELLOW && c2 == Color.RED) ->
                    Color.ORANGE
                (c1 == Color.YELLOW && c2 == Color.BLUE) ||
                        (c1 == Color.BLUE && c2 == Color.YELLOW) ->
                    Color.GREEN
                (c1 == Color.BLUE && c2 == Color.VIOLET) ||
                        (c1 == Color.VIOLET && c2 == Color.BLUE) ->
                    Color.INDIGO
                else -> throw Exception("Dirty color")
            }

    // 2.3.5 Smart casts: combining type checks and casts
    // In Kotlin, you check whether a variable is of a certain type by using an is check
    // If you check the variable for a certain type, you don’t need to cast it afterward; you can use it as
    // having the type you checked for. In effect, the compiler performs the cast for you, and we
    // call it a smart cast.
    interface Expr
    class Num(val value: Int) : Expr
    class Sum(val left: Expr, val right: Expr) : Expr
    fun eval(e: Expr): Int
    { if (e is Num) {
        val n = e as Num
        return n.value
    }
        if (e is Sum) {
            return eval(e.right) + eval(e.left)
        }
        throw IllegalArgumentException("Unknown expression")
    }

    // 2.3.6 Refactoring: replacing 'if' with 'when'
    // Can replace if with when
    // The when expression isn’t restricted to checking values for equality, which is what
    // you saw earlier. Here you use a different form of when branches, allowing you to check
    // the type of the when argument value.
    fun eval2(e: Expr): Int =
            if (e is Num) {
                e.value
            } else if (e is Sum) {
                eval2(e.right) + eval2(e.left)
            } else {
                throw IllegalArgumentException("Unknown expression")
            }
    fun eval3(e: Expr): Int =
            when (e) {
                is Num ->
                    e.value
                is Sum ->
                    eval3(e.right) + eval3(e.left)
                else ->
                    throw IllegalArgumentException("Unknown expression")
            }

    // 2.3.7 Blocks as branches of 'if' and 'when'
    // Both if and when can have blocks as branches. In this case, the last expression in the
    // block is the result.
    fun evalWithLogging(e: Expr): Int =
            when (e) {
                is Num -> {
                    println("num: ${e.value}")
                    e.value
                }
                is Sum -> {
                    val left = evalWithLogging(e.left)
                    val right = evalWithLogging(e.right)
                    println("sum: $left + $right")
                    left + right
                }
                else -> throw IllegalArgumentException("Unknown expression")
            }

}