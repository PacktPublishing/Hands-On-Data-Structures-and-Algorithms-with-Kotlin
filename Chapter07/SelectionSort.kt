import java.util.*

fun <E: Comparable<E>> Array<E>.sort() {
    val len = size
    // Find the minimum value of the array
    for (i in 0 until (len - 1)) {
        // Getting the index where minimum value is present
        var minIndex = i
        for (j in (i + 1) until len) {
            if (this[j].compareTo(this[minIndex]) < 0) minIndex = j
        }

        // We got the minimum element, now swap that to first element
        val temp = this[minIndex]
        this[minIndex] = this[i]
        this[i] = temp
    }
}

fun <E: Comparable<E>> MutableList<E>.sort() {
    val len = size
    // Find the minimum value of the array
    for (i in 0 until (len - 1)) {
        // Getting the index where minimum value is present
        var minIndex = i
        for (j in (i + 1) until len) {
            if (this[j].compareTo(this[minIndex]) < 0) minIndex = j
        }

        // We got the minimum element, now swap that to first element
        val temp = this[minIndex]
        this[minIndex] = this[i]
        this[i] = temp
    }
}

fun main(args: Array<String>) {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.sort()
    println(Arrays.toString(nums))

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.sort()
    println(languages)
}
