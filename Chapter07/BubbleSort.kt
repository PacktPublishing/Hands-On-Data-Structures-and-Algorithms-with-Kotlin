import java.util.*

fun <E: Comparable<E>> Array<E>.sort() {
    val len = size
    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j].compareTo(this[j + 1]) > 0) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}

fun <E: Comparable<E>> MutableList<E>.sort() {
    val len = size
    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j].compareTo(this[j + 1]) > 0) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
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
