package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list = 1.until(50).toList()

    println("list.drop(25) -> ${list.drop(25)}")
    println("list.dropLast(25) -> ${list.dropLast(25)}")
}