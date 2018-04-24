fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript", "Python")

    for (i in languages.indices) {
        if (i % 2 == 0) {
            println(languages[i])
        } else {
            println(languages[i].toUpperCase())
        }
    }

    for ((index, value) in languages.withIndex()) {
        if (index % 2 == 0) {
            println("The element at $index is $value")
        } else {
            println("The element at $index is ${value.toUpperCase()}")
        }
    }

    for (language in languages) {
        println("Language - $language")
    }

    languages.forEach { println("Language in Upper Case - ${it.toUpperCase()}") }
}
