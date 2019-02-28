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

fun <E: Comparable<E>> Array<E>.descending() {
    val len = size
    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j].compareTo(this[j + 1]) < 0) {
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

fun <E: Comparable<E>> List<E>.sort(): List<E> {
    val len = size
    val resultList = toMutableList()
    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (resultList[j].compareTo(resultList[j + 1]) > 0) {
                val temp = resultList[j]
                resultList[j] = resultList[j + 1]
                resultList[j + 1] = temp
            }
        }
    }
    return resultList
}

fun main(args: Array<String>) {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.sort()
    println(Arrays.toString(nums))
    nums.descending()
    println(Arrays.toString(nums))

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.sort()
    println(languages)

    val doubles = listOf(1.2, 2.6, 10.2, 3.5, 200.4, 34.54, 12.3)
    val sortedDoubles = doubles.sort()
    println("Doubles Before Sort - $doubles")
    println("Doubles After Sort - $sortedDoubles")
}
