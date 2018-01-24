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
    // 3.2.1 Named arguments
    // The first problem we’ll address concerns the readability of function calls.
    // joinToString(collection, separator = " ", prefix = " ", postfix = ".")
    // can use strings in parameter to identify the parameters passed
    // When calling a method written in Kotlin, you can specify the names of some
    // arguments that you’re passing to the function.

    // 3.2.2 Default parameter values
    // In Kotlin, you can often avoid creating overloads because you can specify default
    // values for parameters in a function declaration.
    // You can either invoke the function with all the arguments or omit some of them because
    // they have default values
    // When using the regular call syntax, you can omit only trailing arguments. If you use
    // named arguments, you can omit some arguments from the middle of the list and specify
    // only the ones you need: joinToString(list, prefix = "# ")
    fun <T> joinToString(
            collection: Collection<T>,
            separator: String = ", ",
            prefix: String = "",
            postfix: String = ""
    ): String {
        return "s"
    }

    /**
        Given that Java doesn’t have the concept of default parameter
        values, you have to specify all the parameter values explicitly when
        you call a Kotlin function with default parameter values from Java. If
        you frequently need to call a function from Java and want to make it
        easier to use for Java callers, you can annotate it with
        @JvmOverloads. This instructs the compiler to generate Java
        overloaded functions, omitting each of the parameters one by one, starting from the last one.

        For example, if you annotate joinToString() with
        @JvmOverloads, the following overloads are generated:

        /* Java */
        String joinToString(Collection<T> collection, String separator,String prefix, String postfix);
        String joinToString(Collection<T> collection, String separator,String prefix);
        String joinToString(Collection<T> collection, String separator);
        String joinToString(Collection<T> collection);
     */

}