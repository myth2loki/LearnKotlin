package com.kotlin.learn.basic

open class A

class B: A() {
    fun show() = println("B")
}

private class C

internal class D

open class Test constructor(val a: Int)
private class Test1(val a: Int)
private class Test2 private constructor(val a: Int) {
    val _a = a
}

class Test11(val b: Int): Test(0)

fun main(args: Array<String>) {
    println(C())

    var test = Test(0)
    println(test.a)
    var test1 = Test1(1)
    println(test1.a)
    var test2 = Test1(2)
    println(test2.a)

    var test11 = Test11(2)
    println("${test11.a} and ${test11.b}")
}