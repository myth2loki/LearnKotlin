package com.kotlin.learn.advance

fun main(args: Array<String>) {
    val a = A("abc")
    println("$a type = ${a.getType()}")
    val b = A(1234)
    println("$b type = ${b.getType()}")

    val list = listOf(1, 'c', "dafsdf", 3.4)


    println(list.filterInstance<String>())
    println(list.filterInstance<Int>())
    println(list.filterInstance<Char>())

    printlnClass<Int>()

    println(list.isA<String>())
    println("all item of list is String? ${list.isA<String>()}")

    val list2 = listOf(1, 2, 3.4)
    println("all item of list2 is Number? ${list2.isA<Number>()}")
}

data class A<T: Any>(val item: T) {
    fun getType(): String {
        return item::class.java.typeName
    }
}

inline fun <reified T> List<*>.isA(): Boolean = all { it is T }

inline fun <reified T> List<*>.filterInstance(): List<T> {
    val newList = mutableListOf<T>()
    for (e in this) {
        if (e is T) {
            newList.add(e)
        }
    }
    return newList
}

inline fun <reified T> printlnClass() {
    println(T::class.java)
}