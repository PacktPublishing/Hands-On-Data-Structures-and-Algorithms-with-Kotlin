package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list = listOf<Int>(1,2,3,4,5,6,7,8,9,10)
    val modifiedList = list.map { it*2 }

    println("modifiedList -> $modifiedList")
}