import java.util.LinkedList

fun main(args: Array<String>) {
    val list = listOf(10,8,18,45,63,49,88,15,62)

    val sortedList = list.sorted()

    for (i in sortedList) {
        println("List Item $i")
    }
}
