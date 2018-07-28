fun search(text: String, pattern: String): Int {
    val patternLen = pattern.length
    val textLen = text.length - patternLen
    val patternHash = hash(pattern)
    var subText = text.substring(0, patternLen)
    var subTextHash = hash(subText)
    var isFound = false
    if ((patternHash == subTextHash) and subText.equals(pattern)) return 0

    for (i in 1..textLen) {
        subTextHash = rolledHash(text[i - 1], text[i + patternLen - 1], subTextHash, patternLen)
        if ((patternHash == subTextHash) and text.substring(i, i + patternLen).equals(pattern)) return i
    }
    return -1
}

private fun hash(input: String): Long {
    var result = 0L
    input.forEachIndexed { index, char ->
        result += (char.toDouble() * Math.pow(97.0, index.toDouble())).toLong()
    }
    return result
}

private fun rolledHash(oldChar: Char, newChar: Char, oldHash: Long, patternLen: Int): Long {
    val newHash = (((oldHash - oldChar.toLong()) / 97)
            + newChar.toDouble() * Math.pow(97.0, (patternLen - 1).toDouble())).toLong()
    return newHash
}

fun main(args: Array<String>) {
    // Testing Hash function
    println(hash("hello"))
    val output: Long = 104L + 101L * 97L + 108L * 97L * 97L + 108L * 97L * 97L * 97L + 111L * 97L * 97L * 97L * 97L
    println(output)

    // Testing rolled Hash function
    println(hash("he"))
    val output1: Long = 104L + 101L * 97L
    println(output1)
    println(hash("el"))
    println(rolledHash('h', 'l', hash("he"), 2))
    val output2: Long = 101L + 108L * 97L
    println(output2)

    println(search("Hello", "el"))
    println(search("Hello Kotlin", "owel"))
    println(search("Hello", "lo"))
    println(search("Hello", "llw"))
    println(search("Hello", "llo"))
}
