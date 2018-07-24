import java.util.*

fun search(text: String, pattern: String): Int {
    val prefixArr = preparePrefixArray(pattern)
    return 0
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
    search("Hello Kotlin!!", "abcdabcy")
}
