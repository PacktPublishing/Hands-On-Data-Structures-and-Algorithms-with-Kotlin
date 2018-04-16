package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list = mutableListOf(1,2,4)

    println("-----Created With Items-----")
    for (i in list) {
        println("list item $i")
    }

    //Adding Items

    list.add(5)
    list.add(2,3)
    list.add(6)

    println("-----After Adding Items-----")
    for (i in list) {
        println("list item $i")
    }
}