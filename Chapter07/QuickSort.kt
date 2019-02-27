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

fun <E: Comparable<E>> List<E>.sort(): List<E> {
    val resultList = toMutableList()
    sort(resultList, 0, size - 1)
    return resultList
}

fun <E: Comparable<E>> Array<E>.descending() {
    descending(this, 0, size - 1)
}

private fun <E: Comparable<E>> descending(arr: Array<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = descendingPartition(arr, low, high)

        descending(arr, low, partitionIndex - 1)
        descending(arr, partitionIndex + 1, high)
    }
}

private fun <E: Comparable<E>> descendingPartition(arr: Array<E>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] >= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1;
}

fun <E: Comparable<E>> MutableList<E>.descending() {
    descending(this, 0, size - 1)
}

private fun <E: Comparable<E>> descending(arr: MutableList<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = descendingPartition(arr, low, high)

        descending(arr, low, partitionIndex - 1)
        descending(arr, partitionIndex + 1, high)
    }
}

private fun <E: Comparable<E>> descendingPartition(arr: MutableList<E>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] >= pivot) {
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

    println()
    println("Descending Order")
    val numbers2 = arrayOf(2, 12, 89, 23, 76, 43, 12)
    numbers2.descending()
    println(Arrays.toString(numbers2))
    val list = arrayOf("Kotlin", "Java", "C", "C++", "R", "Python", "Matlab")
    list.descending()
    println(Arrays.toString(list))

    println()
    println("Immutable list sorting")
    val immutableLangs = listOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    val sortedLangs = immutableLangs.sort()
    println(immutableLangs)
    println(sortedLangs)
}
