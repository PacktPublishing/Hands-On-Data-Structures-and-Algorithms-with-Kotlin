fun main(args: Array<String>) {
    val list = listOf(10, 20, 30)
    println("flatMappedList -> ${
        list.flatMap {
            it.rangeTo(it * 2).toList()
        }
    }")
}
