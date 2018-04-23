package com.rivuchk.packtpub.handsondskotlin.ch09

fun main(args: Array<String>) {
    val list = 1.until(50).toList()

    println("list.take(25) -> ${list.take(25)}")//(1)
    println("list.takeLast(25) -> ${list.takeLast(25)}")//(2)
    println("list.takeWhile { it<=10 } -> ${list.takeWhile { it<=10 }}")//(3)
    println("list.takeLastWhile { it>=40 } -> ${list.takeLastWhile { it>=40 }}")//(4)
}