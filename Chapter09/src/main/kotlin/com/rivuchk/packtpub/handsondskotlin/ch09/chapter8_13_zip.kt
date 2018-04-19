package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list1 = listOf(1,2,3,4,5)
    val list2 = listOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5"
    )

    val resultantList = list1.zip(list2)

    println(resultantList)
}