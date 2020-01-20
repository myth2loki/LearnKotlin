package com.kotlin.learn.advance

fun main(args: Array<String>) {
    LazyTest().println()
}

class LazyTest {
    private val value by lazy { getValue() }

    fun println() {
        println(value)
    }
}

fun LazyTest.getValue(): String {
    return "getValue"
}
