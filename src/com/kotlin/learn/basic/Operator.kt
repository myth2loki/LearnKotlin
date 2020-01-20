package com.kotlin.learn.basic

class StringA {
    private var value = "abc"

    operator fun get(i: Int): Char = value[i]
    operator fun inc(): StringA {
        value = "${value}B"
        return this
    }

    override fun toString(): String {
        return value
    }
}

fun main(args: Array<String>) {
    var stringA = StringA()
    println(stringA[0])
    stringA++
    stringA++
    println(stringA)
    var a = stringA.run { "a" }
    a.run {  }
    println(a)
}