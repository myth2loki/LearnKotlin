package com.kotlin.learn.advance

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main(args: Array<String>) = runBlocking {
//    val m1 = getMessage(1)
//
//    println("m1 = $m1")

    println("start------------")
    val async2 = async { getMessage(2) }
    val async3 = async { getMessage(3) }
    println("start1------------ ${System.currentTimeMillis()}")
    println("async2 = ${async2.await()} and async3 = ${async3.await()}")

    withContext(this.coroutineContext) {
//        println("async2 = ${async2.await()}")
//        println("async-------------- ${System.currentTimeMillis()}")
//        println("async3 = ${async3.await()}")
//        getMessage(3)

    }
    println("end------------ ${System.currentTimeMillis()}")
}

fun sleep() {
    Thread.sleep(10 * 1000)
}

suspend fun suSleep() {
    Thread.sleep(10 * 1000)
}

suspend fun getMessage(i: Int): String {
    delay(5000)
    return "message$i"
}