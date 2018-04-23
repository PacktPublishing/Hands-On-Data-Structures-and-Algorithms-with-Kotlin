package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list = listOf(
            "1st Item",
            "2nd Item",
            "3rd Item",
            "4th Item",
            "5th Item"
    )

    println("3rd Item on the list - ${list.get(2)}")
    println("4rd Item on the list - ${list[3]}")
}