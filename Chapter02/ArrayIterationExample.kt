fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript", "Python")

    for (i in languages.indices) {
        println(languages[i])
    }

    for ((index, value) in languages.withIndex()) {
        println("The element at $index is $value")
    }

    for (language in languages) {
        println("Language - $language")
    }

    languages.forEach { println("Language in Upper Case - ${it.toUpperCase()}") }
}
