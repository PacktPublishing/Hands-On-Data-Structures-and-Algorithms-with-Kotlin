fun main(args: Array<String>) {
    val list = 1.until(50).toList()

    println("list.drop(20) -> ${list.drop(20)}")
    println("list.dropLast(20) -> ${list.dropLast(20)}")
}
