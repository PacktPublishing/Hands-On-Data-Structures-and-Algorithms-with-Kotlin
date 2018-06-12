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

fun jumpSearch() {
    
}

fun binarySearch() {

}

fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "Scala", "JavaScript", "C#")
    println("Java is at - ${languages.linearSearch("Java")}")
    println("Scala is at - ${languages.linearSearch("Scala")}")

    val students = arrayListOf("Chanse", "Rivu", "Siddappa")
    println("Siddappa is at - ${students.linearSearch("Siddappa")}")
}
