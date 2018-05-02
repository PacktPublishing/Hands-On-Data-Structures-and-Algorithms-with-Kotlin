import java.util.Arrays

fun isValidMatrix(arr: Array<Array<Int>>): Boolean {
    var isValid = true
    var sizeOfRow = arr[0].size
    for (row in arr) { // Can be optimized more by iterating from 1st index instead of 0th
        if (sizeOfRow != row.size) {
            isValid = false
            break
        }
    }
    return isValid
}

fun main(args: Array<String>) {
    val matrix = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6)
    )
    println("${Arrays.deepToString(matrix)} is ${if (isValidMatrix(matrix)) "a valid" else "an invalid"} Matrix")

    val matrix1 = arrayOf(
        arrayOf(1, 5),
        arrayOf(2, 7),
        arrayOf(3, 4, 3)
    )
    println("${Arrays.deepToString(matrix1)} is ${if (isValidMatrix(matrix1)) "a valid" else "an invalid"} Matrix")

    val matrix2 = arrayOf(1, 3, 6)
    println("${Arrays.toString(matrix2)} is ${if (matrix2 is Array<*>) "a valid" else "an invalid"} Matrix")
}
