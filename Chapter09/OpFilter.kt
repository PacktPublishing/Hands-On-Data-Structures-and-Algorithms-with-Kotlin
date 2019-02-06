import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val list = 1.until(50).toList()

    println("Filtered List with Even Numbers-> ${list.filter { it % 2 == 0 }}")

    val filteredList = list.filter {
        val sqroot = sqrt(it.toDouble()).roundToInt()
        sqroot*sqroot==it
    }

    println("Filtered List with Perfect Squares -> $filteredList")
}
