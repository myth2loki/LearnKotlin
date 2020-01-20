package com.kotlin.learn.advance

import java.lang.Exception


fun main(args: Array<String>) {
    println(getString())
    ::getString.delay { println(it) }

    val a = A1("aaa")
    println(a.getString())
    a::getString.delay { println(it) }

    println("Thread(${Thread.currentThread().id}), value = ${a.function2(1, 2)}")
    a::function2.background(1, 2) {
        println("Thread(${Thread.currentThread().id}), value = $it")
    }

    a::function22.background(1, 2) {}
}

fun getString() = "test"

fun <R> Function0<out R>.delay(delay: Long = 1000, block: (R) -> Unit) {
    try {
        Thread.sleep(delay)
    } catch (e: Exception) {}
    block(this())
}

fun <R> Function0<out R>.background(block: (R) -> Unit) {
    Thread {
        block(this())
    }.start()
}

fun <T, V, R> Function2<T, V, out R>.background(t: T, v: V, block: ((R) -> Unit)? = null) {
    Thread {
        block?.invoke(this(t, v))
    }.start()
}

class A1 constructor(t: String) {
    private var test = t
    fun getString() = test

    fun function2(i: Int, j: Int) = i + j

    fun function22(i: Int, j: Int) {
        println("Thread(${Thread.currentThread().id}), value = ${i + j}")
    }
}