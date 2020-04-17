package com.kotlin.learn.test

fun main(args: Array<String>) {
    val list = (1..10).map { Task() }
    list.sorted().forEach { println(it) }
}

data class Task(val time: Long = System.nanoTime()): Comparable<Task> {
    override fun compareTo(other: Task): Int {
        return when{
            time > other.time -> 1
            time < other.time -> -1
            else -> 0
        }
    }
}