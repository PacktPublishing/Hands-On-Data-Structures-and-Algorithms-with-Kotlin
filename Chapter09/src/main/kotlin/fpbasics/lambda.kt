package fpbasics

fun main() {
    var myFunc: (Int) -> Int
    myFunc = { it * 2 }
    println("10 * 2 ${ myFunc(10) }")
    myFunc = { it / 2 }
    println("10 / 2 ${ myFunc(10) }")
}