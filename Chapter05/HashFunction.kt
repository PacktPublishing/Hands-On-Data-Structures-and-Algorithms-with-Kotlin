fun hashCodeFromStudentId(studentId: String) = studentId[0].toUpperCase() - 'A'

private fun hash(key: Char): Int {
    var h = key.hashCode()
    return h xor (h ushr 16)
}

fun main(args: Array<String>) {
    println(hashCodeFromStudentId("Apple"))
    println(hashCodeFromStudentId("angle"))
    println(hashCodeFromStudentId("Bangle"))
    println(hashCodeFromStudentId("ball"))

    val alphabets = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    // Testing hash() function
    val size = alphabets.length
    for (i in 1 until size) {
        println("$i = ${hash(alphabets[i])}")
    }
}
