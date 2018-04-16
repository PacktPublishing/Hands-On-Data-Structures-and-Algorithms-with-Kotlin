package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list = 1.rangeTo(50).toList()

    println(list.groupBy { it%5 })
}