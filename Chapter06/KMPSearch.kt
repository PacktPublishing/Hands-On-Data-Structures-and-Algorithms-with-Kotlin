import java.util.*

fun search(text: String, pattern: String): Int {
    val prefixArr = preparePrefixArray(pattern)
    val textLen = text.length
    val patternLen = pattern.length

    var patternIndex = 0
    var textIndex = 0
    while ((textIndex < textLen) and (patternIndex < patternLen)) {
        if (pattern[patternIndex] == text[textIndex]) {
            textIndex++
            patternIndex++
        } else {
            if (patternIndex != 0) patternIndex = prefixArr[patternIndex - 1]
            else textIndex++
        }
        if (patternIndex == patternLen) {
            // We found the pattern
            return textIndex - patternIndex
        }
    }
    return -1
}

fun preparePrefixArray(pattern: String): IntArray {
    val patternLen = pattern.length
    val arr = IntArray(patternLen)
    var index = 0
    var i = 1
    while(i < patternLen) {
        if (pattern[i] == pattern[index]) {
            arr[i] = index + 1
            index++
            i++
        } else {
            if (index != 0) index = arr[index - 1]
            else {
                arr[i] = 0
                i++
            }
        }
    }
    println(Arrays.toString(arr))
    return arr
}

fun main(args:Array<String>) {
    println(search("Hello Kotlin!!", "Ko"))
    println(search("Hello Kotlin!!", "Kos"))
    println(search("Hello", "el"))
    println(search("Hello Kotlin", "owel"))
    println(search("Hello", "lo"))
    println(search("Hello", "llw"))
    println(search("Hello", "llo"))
}
