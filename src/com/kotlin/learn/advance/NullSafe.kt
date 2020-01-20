package com.kotlin.learn.advance

fun main(args: Array<String>) {
    var str1 = "abc"
    //str1 = null
    var str2: String? = "def"
    str2 = null
    if (str2 != null) {
        println(str2.length)
    } else {
        println(0)
    }
    println(str2?: 0)
    println(str2?.length)

    var a: Int? = 0
    a = null
    val f: Float = a?.toFloat()?:0f
    println("f = $f")
}