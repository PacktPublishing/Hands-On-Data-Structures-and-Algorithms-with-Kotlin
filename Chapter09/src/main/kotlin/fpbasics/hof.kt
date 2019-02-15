package fpbasics

fun highOrder(anotherFunc: () -> Unit) {
    println("Before anotherFunc()")
    anotherFunc()
    println("After anotherFunc()")
}

fun main() {
    highOrder {
        println("anotherFunc()")
    }
}