package com.rivuchk.packtpub.handsondskotlin.ch09

import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val list = 1.until(50).toList()
    val filteredListEven = list.filter { it%2==0 }

    println("filteredListEven -> $filteredListEven")

    val filteredListPSquare = list.filter {
        val sqroot = sqrt(it.toDouble()).roundToInt()
        sqroot*sqroot==it
    }

    println("filteredListPSquare -> $filteredListPSquare")
}