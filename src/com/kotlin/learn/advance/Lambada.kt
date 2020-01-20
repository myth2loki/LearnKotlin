package com.kotlin.learn.advance

val add = {a: Int, b: Int -> a + b}

fun main(args: Array<String>) {
    println(add)

    var message = show({ "abc" })
    println(message)
    message = show{ "abc" }
    println(message)
    message = show { "def" }
    println(message)
}

fun show(lambada: () -> String) = lambada()
