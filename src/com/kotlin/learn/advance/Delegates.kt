package com.kotlin.learn.advance

import kotlin.properties.Delegates

fun main(args: Array<String>) {
    val u = User()
    u.name = "hahaha"
    u.name = "hehehe"

    u.name1 = "good"
    println("u.name1 = ${u.name1}")
    u.name1 = "fuck you"
    println("u.name1 = ${u.name1}")
}

class User {
    var name: String by Delegates.observable("") { p, old, new ->
        println("${p.name} 从$old 改为 $new")
    }

    var name1: String by Delegates.vetoable("") { p, old, new ->
        if (new.startsWith("fuck")) return@vetoable true

        return@vetoable false
    }
}