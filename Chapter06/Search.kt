import kotlin.collections.Collection

fun <E> Array<E>.linearSearch(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
    }
    return -1
}

fun <E> Collection<E>.linearSearch(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
    }
    return -1
}

fun <E : Comparable<E>> Array<E>.linearSearchInSortedArray(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
        else if (value > element) return -1
    }
    return -1
}

fun <E : Comparable<E>> Collection<E>.linearSearchInSortedCollection(element: E): Int {
    for ((index, value) in this.withIndex()) {
        if (value == element) return index
        else if (value > element) return -1
    }
    return -1
}

fun jumpSearch() {
    
}

fun <E: Comparable<E>> Array<E>.binarySearch(element: E): Int {
    var left = 0
    var right = size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        val midVal = this[mid]
        val compare = midVal.compareTo(element)

        if (compare < 0) left = mid + 1
        else if (compare > 0) right = mid - 1
        else return mid             // element found
    }
    return -1                       // element not found
}

fun <E: Comparable<E>> List<E>.binarySearch(element: E): Int {
    var left = 0
    var right = size - 1
    while (left <= right) {
        var mid = (left + right) / 2
        val midVal = this[mid]
        val compare = midVal.compareTo(element)

        if (compare < 0) left = mid + 1
        else if (compare > 0) right = mid - 1
        else return mid             // element found
    }
    return -1                       // element not found
}

fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "Scala", "JavaScript", "C#")
    println("Java is at - ${languages.linearSearch("Java")}")
    println("Scala is at - ${languages.linearSearch("Scala")}")

    val students = arrayListOf("Chanse", "Rivu", "Siddappa", "Chanse")
    println("Siddappa is at - ${students.linearSearch("Siddappa")}")

    val uniqueStudents = setOf("Chanse", "Rivu", "Siddappa", "Chanse")
    println("Siddappa is at - ${uniqueStudents.linearSearch("Siddappa")}")
}
