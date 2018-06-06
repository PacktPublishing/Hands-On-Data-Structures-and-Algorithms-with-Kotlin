package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list1 = listOf(1,2,3,4,5,6,7,8)
    val list2 = listOf(
            "Item 1",
            "Item 2",
            "Item 3",
            "Item 4",
            "Item 5"
    )

    println("list1.zip(list2)-> ${list1.zip(list2)}")

    println("list1.zipWithNext() -> ${list1.zipWithNext()}")
}