import java.util.*

fun <E: Comparable<E>> Array<E>.sort() {
    val len = size
    for (i in 1 until len) {
        var key = this[i]
        var j = i - 1;

        while(j >= 0 && this[j] > key) {
            this[j + 1] = this[j]
            j--
        }
        this[j + 1] = key
    }
}

fun <E: Comparable<E>> MutableList<E>.sort() {
    val len = size
    for (i in 1 until len) {
        var key = this[i]
        var j = i - 1;

        while(j >= 0 && this[j].compareTo(key) > 0) {
            this[j + 1] = this[j]
            j--
        }
        this[j + 1] = key
    }
}

fun <E: Comparable<E>> List<E>.sort(): List<E> {
    val len = size
    val resultList = toMutableList()
    for (i in 1 until len) {
        var key = resultList[i]
        var j = i - 1;

        while(j >= 0 && resultList[j].compareTo(key) > 0) {
            resultList[j + 1] = resultList[j]
            j--
        }
        resultList[j + 1] = key
    }
    return resultList
}

fun main(args: Array<String>) {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.sort()
    println(Arrays.toString(nums))

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.sort()
    println(languages)

    val nums1 = listOf(2, 12, 89, 23, 76, 43, 12)
    val result = nums1.sort()
    println(nums1)
    println(result)
}
