fun main(args: Array<String>) {
    val list = mutableListOf(1, 2, 3, 0, 5, 6, 7, 8)

    list[3] = 4
    println("3rd and 4th Item on List -> ${list[3]}, ${list.get(4)}")
}
