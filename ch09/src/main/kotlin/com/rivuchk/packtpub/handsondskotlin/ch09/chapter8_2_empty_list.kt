package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val emptyList1 = listOf<Any>()

    val emptyList2 = emptyList<Any>()

    println("emptyList1.size = ${emptyList1.size}")
    println("emptyList2.size = ${emptyList2.size}")
}