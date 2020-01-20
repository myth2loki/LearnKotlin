package com.kotlin.learn.advance

fun main(args: Array<String>) {
    //组合函数
    val add = {a: Int, b: Int -> a + b}

    val addResult = compose(add)(1)(2)
    println("compose = $addResult")

    val subResult = compose { a: Int, b: Int -> a - b }(1)(2)
    println("subResult = $subResult")


    val multipleResultWith5Func = compose { a: Int, b: Int -> a * b }(5)
    println("multipleResultWith5Func with 2 = ${multipleResultWith5Func(2)}")
    println("multipleResultWith5Func with 3 = ${multipleResultWith5Func(3)}")
    println("multipleResultWith5Func with 4 = ${multipleResultWith5Func(4)}")

    //实现输出格式
    val logPrint =
        log { tag: String, method: String, message: String, e: Exception -> println("[$tag]($method) $message, $e") }
    //实现tag
    val logWithMain = logPrint("MainWindow")
    //实现method
    val logWithMainOnCreate = logWithMain("onCreate()")
    //真正使用的log
    logWithMainOnCreate("run failed", RuntimeException("crash....."))
}

fun compose(func: (a: Int, b: Int) -> Int) = fun (a: Int) = fun (b: Int) = func(a, b)

//定义一个log
fun log(output: (tag: String, method: String, message: String, e: Exception) -> Unit)
        = fun(tag: String)
        = fun(method: String)
        = fun(message: String, e: Exception)
        = output(tag, method, message, e)