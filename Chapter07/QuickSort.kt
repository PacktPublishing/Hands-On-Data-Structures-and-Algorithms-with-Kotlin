import java.util.*

fun <E: Comparable<E>> Array<E>.sort() {
    sort(this, 0, size - 1)
}

private fun <E: Comparable<E>> sort(arr: Array<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = partition(arr, low, high)

        sort(arr, low, partitionIndex - 1)
        sort(arr, partitionIndex + 1, high)
    }
}

private fun <E: Comparable<E>> partition(arr: Array<E>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1;
}

fun <E: Comparable<E>> MutableList<E>.sort() {
    sort(this, 0, size - 1)
}

private fun <E: Comparable<E>> sort(arr: MutableList<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = partition(arr, low, high)

        sort(arr, low, partitionIndex - 1)
        sort(arr, partitionIndex + 1, high)
    }
}

private fun <E: Comparable<E>> partition(arr: MutableList<E>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1;
}

fun main(args: Array<String>) {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.sort()
    println(Arrays.toString(nums))

    val numbers = arrayOf(17, 12, 29, 21, 5, 7)
    numbers.sort()
    println(Arrays.toString(numbers))

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.sort()
    println(languages)
}
