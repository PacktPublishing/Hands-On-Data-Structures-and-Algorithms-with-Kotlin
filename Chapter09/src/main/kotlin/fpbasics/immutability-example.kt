package fpbasics

import java.util.*

val immutableRandomValue: String by lazy {
    getRandomValue()
}
fun getRandomValue(): String {
    val rand = Random().nextInt()
    return "Value $rand"
}

fun main(vararg args:String) {
    println("getRandomValue() will return different values at each call")
    println("1. ${getRandomValue()}")
    println("2. ${getRandomValue()}")
    println("\nHowever, immutableRandomValue will return the same value at each call")
    println("1. $immutableRandomValue")
    println("2. $immutableRandomValue")
}