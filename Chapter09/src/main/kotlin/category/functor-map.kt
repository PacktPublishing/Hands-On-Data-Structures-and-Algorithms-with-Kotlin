package category

fun main() {
    val intList = listOf(1, 2, 3, 4, 5)
    println(intList.map { it * 2 })
    println(intList.map { "Mapped $it" })
    println(intList.map { it.toDouble() })
}