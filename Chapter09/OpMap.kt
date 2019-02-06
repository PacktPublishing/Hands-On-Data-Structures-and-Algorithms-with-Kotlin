fun main(args: Array<String>) {
    val list = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    println("modifiedList -> ${list.map { it + 3 }}")
}
