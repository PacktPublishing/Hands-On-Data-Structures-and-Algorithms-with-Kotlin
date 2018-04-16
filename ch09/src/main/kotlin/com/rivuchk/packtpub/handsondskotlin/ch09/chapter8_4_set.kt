package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val set = mutableSetOf(1,2,3,3,2)

    println("set $set")

    set.add(4)
    set.add(5)
    set.add(5)
    set.add(6)

    println("set $set")
}