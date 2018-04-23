fun main(args: Array<String>) {
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript", "Python")
    println("1st language in the array is : ${languages[0]}")
    println("2nd language in the array is : ${languages[1]}")
    println("3rd language in the array is : ${languages[2]}")
    println("4th language in the array is : ${languages[3]}")
    println("5th language in the array is : ${languages[4]}")
    println("6th language in the array is : ${languages[5]}")
    println("7th language in the array is : ${languages[6]}")
    // println("8th language in the array is : ${languages[7]}")

    val firstLanguage = languages[0]
    val secondLanguage = languages[1]
    val thirdLanguage = languages[2]
    // val invalidIndex = languages[-1]

    println()
    println("2nd language in the array is : ${languages.get(1)}")
    println("4th language in the array is : ${languages.get(3)}")
    println("5th language in the array is : ${languages.get(4)}")

    println()
    println("1st language in the array is : ${languages.component1()}")
    println("2nd language in the array is : ${languages.component2()}")

    println()
    val firstItem = languages.elementAt(0)
    val secItem = languages.elementAt(0)
    val tenthItem = languages.elementAtOrElse(9, {_ -> "Not Available"})
    val eleventhItem = languages.elementAtOrNull(10)

    println("1st item - $firstItem")
    println("2nd item - $secItem")
    println("10th item - $tenthItem")
    println("11th item - $eleventhItem")
}
