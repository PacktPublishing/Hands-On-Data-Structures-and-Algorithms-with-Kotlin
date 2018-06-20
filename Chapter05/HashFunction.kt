fun hashCodeFromStudentId(studentId: String) = studentId[0].toUpperCase() - 'A'

fun main(args: Array<String>) {
    println(hashCodeFromStudentId("Apple"))
    println(hashCodeFromStudentId("angle"))
    println(hashCodeFromStudentId("Bangle"))
    println(hashCodeFromStudentId("ball"))
}
