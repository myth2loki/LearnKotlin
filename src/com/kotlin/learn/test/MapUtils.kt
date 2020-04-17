package com.kotlin.learn.test

fun main(args: Array<String>) {
    println(mapOf(
        "a" to 1,
        "s" to "sssssss",
        "b" to listOf("aa", "bb"),
        "c" to mapOf(
            "aaa" to "aaaa",
            "bbb" to "bbbb"
        )
    ).toRawJsonString())
}

fun <K, V> Pair<K, V>.toRawJsonString(): String {
    return "\"$first\":\"$second\""
}

fun <K, V> Map<K, out V>.toRawJsonString(): String {
    return map { entry ->
        val key = entry.key
        val value = entry.value
        when (value) {
            is Number -> "\"$key\":$value"
            is String -> "\"$key\":\"$value\""
            is Map<*, *> -> "\"$key\": ${value.toRawJsonString()}"
            is List<*> -> "\"$key\": ${value.toRawJsonString()}"
            else -> key to value
        }
    }.joinToString(", ", "{", "}")
}

fun <T> List<T>.toRawJsonString(): String {
    return map { item ->
        when (item) {
            is Number -> item
            is String -> "\"$item\""
            is Map<*, *> -> item.toRawJsonString()
            is List<*> -> item.toRawJsonString()
            else -> item
        }
    }.joinToString(", ", "[", "]")
}