package com.kotlin.learn.advance

import kotlin.reflect.full.*
import kotlin.reflect.jvm.javaType

fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    var kClass = person.javaClass.kotlin
    kClass = Person::class
//    kClass = person::class
    println(kClass.simpleName)
    kClass.constructors.forEach { println(it) }

    println("memberProperties")
    kClass.memberProperties.forEach { println(it) }

    println("memberFunctions")
    kClass.memberFunctions.forEach { println(it) }
    println("declaredMemberFunctions")
    kClass.declaredMemberFunctions.forEach { println(it) }

    println("primaryConstructor call")
    println(kClass.primaryConstructor?.call("Blice", 30))

    println()
    println("反射调用printlnEx")
    kClass.memberFunctions.filter { it.name == "printlnEx" }
        .first().call(person, "来自反射的信息")

    println("\n反射调用name")
    println(kClass.memberProperties.filter { it.name == "name" }
        .first().get(person))

    println("\n另一种反射调用printlnEx")
    Person::printlnEx.call(person, "另一种来自反射的信息")

    println("\n另一种反射调用name")
    println(Person::name.get(person))
    List(10) {
        Person("name$it", it)
    }.forEach {
        Person::myToString.invoke(it)
    }

    println("反射序列化")
    println(StringBuilder().serializeObject(person))
    println("反射序列化")
    println(StringBuilder().serializeObject(Bus("Benz", 10, 100)))
}

class Person(val name: String, val age: Int) {
    fun printlnEx(message: String) {
        println("$this and $message")
    }

    fun myToString(): String = toString()

    override fun toString(): String {
        return "Person(name='$name', age=$age)"
    }


}

fun StringBuilder.serializeObject(obj: Any): StringBuilder {
    val props = obj.javaClass.kotlin.memberProperties
    append(props.joinToString(", ", prefix = "{", postfix = "}") { prop ->
//        println("xxx===> ${prop.returnType} Int::class = ${Int::class}")
        if (prop.returnType.javaType == Int::class.java) {
            "'${prop.name}': ${prop.get(obj)}"
        } else {
            "'${prop.name}': '${prop.get(obj)}'"
        }
    })
    return this
}

data class Bus(val brand: String, val wheels: Int, val persons: Int)