package com.kotlin.learn.basic

import java.lang.RuntimeException

fun main(args: Array<String>) {
    var i: Int = 0
    val vi = 1

    val result = add(i, vi)
    println("result = $result")

    if (result == 1) {
        println("result 等于 1")
    } else {
        println("result 不等于 1")
    }

    var key = 1
    when(key) {
        1 -> println("key == 1")
        in 1..100 -> println("1到100之间")
        else -> println("key未知")
    }

    //when表达式
    val array = arrayOf(1,2,3,4)
    var anyVal: Any = "salkjflask"
    val resultFromWhen = when {
        anyVal is String -> "anyVal是字符串($anyVal)"
        anyVal is Int -> anyVal + 1
        array.isNotEmpty() -> array.sum()
        else -> -1
    }
    println("resultFromWhen = $resultFromWhen and type = ${resultFromWhen.javaClass}")
    val resultFromTry = try {
        throw RuntimeException()
    } catch (e: Exception) {
        2
    }
    println("resultFromTry = $resultFromTry")

    //区间
    val range = 1..5
    range.forEach {
        println(it)
    }


}

fun add(a: Int, b: Int) = a + b
