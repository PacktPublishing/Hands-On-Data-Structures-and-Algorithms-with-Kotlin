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

fun <E: Comparable<E>> Array<E>.binarySearch(element: E, start: Int, end: Int): Int {
    var left = start
    var right = end - 1
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

fun <E: Comparable<E>> List<E>.binarySearch(element: E, start: Int, end: Int): Int {
    var left = start
    var right = end - 1
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

fun <E: Comparable<E>> Array<E>.jumpSearch(element: E): Int {
    val size = this.size
    var step = Math.sqrt(size.toDouble()).toInt()
    var prev = 0

    while (this[Math.min(step, size) - 1] < element) {
        prev = step
        step *= 2
        if (prev >= size.toInt()) return -1
    }

    while(this[prev] < element) {
        prev++
        if (prev == Math.min(step, size)) return -1
    }

    if (this[prev] == element) {
        return prev
    }
    return -1
}

fun <E: Comparable<E>> List<E>.jumpSearch(element: E): Int {
    val size = this.size
    var step = Math.sqrt(size.toDouble()).toInt()
    var prev = 0

    while (this[Math.min(step, size) - 1] < element) {
        prev = step
        step *= 2
        if (prev >= size.toInt()) return -1
    }

    while(this[prev] < element) {
        prev++
        if (prev == Math.min(step, size)) return -1
    }

    if (this[prev] == element) return prev
    return -1
}

fun <E: Comparable<E>> Array<E>.exponentialSearch(element: E): Int {
    if (this[0] == element) return 0

    var i = 1
    val len = this.size
    while(i < len && this[i] <= element) i *= 2

    return this.binarySearch(element, i/2, Math.min(i, len))
}

fun <E: Comparable<E>> List<E>.exponentialSearch(element: E): Int {
    if (this[0] == element) return 0

    var i = 1
    val len = this.size
    while(i < len && this[i] <= element) i *= 2

    return this.binarySearch(element, i/2, Math.min(i, len))
}

fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "Scala", "JavaScript", "C#")
    println("Java is at - ${languages.linearSearch("Java")}")
    println("Scala is at - ${languages.linearSearch("Scala")}")

    val students = arrayListOf("Chanse", "Rivu", "Siddappa", "Chanse")
    println("Siddappa is at - ${students.linearSearch("Siddappa")}")

    val uniqueStudents = setOf("Chanse", "Rivu", "Siddappa", "Chanse")
    println("Siddappa is at - ${uniqueStudents.linearSearch("Siddappa")}")

    println("==========Binary Search==========")
    val numbers = arrayOf(1, 45, 67, 234, 678, 5678, 34567, 909090)
    println("1 is at - ${numbers.binarySearch(1)}")
    println("45 is at - ${numbers.binarySearch(45)}")
    println("67 is at - ${numbers.binarySearch(67)}")
    println("234 is at - ${numbers.binarySearch(234)}")
    println("678 is at - ${numbers.binarySearch(678)}")
    println("5678 is at - ${numbers.binarySearch(5678)}")
    println("34567 is at - ${numbers.binarySearch(34567)}")
    println("909090 is at - ${numbers.binarySearch(909090)}")
    println("4 is at - ${numbers.binarySearch(4)}")

    println("==========Jump Search==========")
    println("1 is at - ${numbers.jumpSearch(1)}")
    println("45 is at - ${numbers.jumpSearch(45)}")
    println("67 is at - ${numbers.jumpSearch(67)}")
    println("234 is at - ${numbers.jumpSearch(234)}")
    println("678 is at - ${numbers.jumpSearch(678)}")
    println("5678 is at - ${numbers.jumpSearch(5678)}")
    println("34567 is at - ${numbers.jumpSearch(34567)}")
    println("909090 is at - ${numbers.jumpSearch(909090)}")
    println("5 is at - ${numbers.jumpSearch(5)}")

    println("==========Exponential Search==========")
    println("1 is at - ${numbers.exponentialSearch(1)}")
    println("45 is at - ${numbers.exponentialSearch(45)}")
    println("67 is at - ${numbers.exponentialSearch(67)}")
    println("234 is at - ${numbers.exponentialSearch(234)}")
    println("678 is at - ${numbers.exponentialSearch(678)}")
    println("5678 is at - ${numbers.exponentialSearch(5678)}")
    println("34567 is at - ${numbers.exponentialSearch(34567)}")
    println("909090 is at - ${numbers.exponentialSearch(909090)}")
    println("5 is at - ${numbers.exponentialSearch(5)}")
}
