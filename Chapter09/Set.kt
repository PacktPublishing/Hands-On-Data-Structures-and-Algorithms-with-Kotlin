fun main(args: Array<String>) {
    val set = mutableSetOf(1, 2, 3, 4, 4, 1, 2)

    println("set before add $set")

    set.add(4)
    set.add(5)
    set.add(5)
    set.add(6)

    println("set after add $set")
}
