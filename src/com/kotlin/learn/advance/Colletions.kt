package com.kotlin.learn.advance

fun main(args: Array<String>) {
    println(arrayOf(1,2,3,4,5,6,7,8,9).filter { it > 5 }.map { it * it })
    println(listOf(1,2,3,4,5,6).map{ it * 2 }.filter { it >= 10})

    println("====================list====================")
    getList().filterNotNull().filter { it > 105 }.forEach { println(it) }
    println("====================sequence====================")
    i = 100
    getSequence().filter { it > 105 }.forEach { println(it) }
}

private fun getList() = (0..10).map { getNumber() }

private fun getSequence() = generateSequence { getNumber() }

private var i = 100
private fun getNumber(): Int? {
    if (i > 110) return null
    Thread.sleep(500)
    return i++
}