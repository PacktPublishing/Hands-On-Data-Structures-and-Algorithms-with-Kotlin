fun search(text: String, pattern: String): Int {
    var retVal = -1
    val patternLen = pattern.length
    val textLen = text.length - patternLen
    for (i in 0..textLen) {
        var isFound = true
        for (j in 0 until patternLen) {
            if (text[i + j] != pattern[j]) {
                isFound = false
                break
            }
        }
        if (isFound) {
            retVal = i
            break
        }
    }
    return retVal
}

fun main(args: Array<String>) {
    println(search("Hello World!!", "abc"))
    println(search("Hello World!!", "Hel"))
    println(search("Hello World!!", "elo"))
    println(search("Hello World!!", "el"))
    println(search("Hello World!!", "wo"))
    println(search("Hello World!!", "Wo"))
    println(search("Hello World!!", "Wod"))
    println(search("Hello World!!", "!!"))
}