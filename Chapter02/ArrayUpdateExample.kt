import java.util.*

fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript", "Python")

    languages[1] = "Swift"
    languages[4] = "Objective-C"
    println("Newly updated languages are - ${Arrays.toString(languages)}")

    println()
    languages.set(5, "TypeScript")
    languages.set(6, "Dart")
    println("Newly updated languages are - ${Arrays.toString(languages)}")
}
