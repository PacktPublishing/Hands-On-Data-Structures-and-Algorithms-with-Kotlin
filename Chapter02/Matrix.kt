import java.util.Arrays

fun isValidMatrix(arr: Array<Array<*>>): Boolean {
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

fun add(a: Array<DoubleArray>, b: Array<DoubleArray>): Array<DoubleArray> {
    val m = a.size
    val n = a[0].size
    val c = Array(m) { DoubleArray(n) }
    for (i in 0 until m)
        for (j in 0 until n)
            c[i][j] = a[i][j] + b[i][j]
    return c
}

fun subtract(a: Array<DoubleArray>, b: Array<DoubleArray>): Array<DoubleArray> {
    val m = a.size
    val n = a[0].size
    val c = Array(m) { DoubleArray(n) }
    for (i in 0 until m)
        for (j in 0 until n)
            c[i][j] = a[i][j] - b[i][j]
    return c
}

fun multiply(a: Array<DoubleArray>, b: Array<DoubleArray>): Array<DoubleArray> {
    val m1 = a.size
    val n1 = a[0].size
    val m2 = b.size
    val n2 = b[0].size
    if (n1 != m2) throw RuntimeException("Illegal matrix dimensions.")
    val c = Array(m1) { DoubleArray(n2) }
    for (i in 0 until m1)
        for (j in 0 until n2)
            for (k in 0 until n1)
                c[i][j] += a[i][k] * b[k][j]
    return c
}

fun multiply(a: Array<DoubleArray>, x: DoubleArray): DoubleArray {
    val m = a.size
    val n = a[0].size
    if (x.size != n) throw RuntimeException("Illegal matrix dimensions.")
    val y = DoubleArray(m)
    for (i in 0 until m)
        for (j in 0 until n)
            y[i] += a[i][j] * x[j]
    return y
}

fun multiply(x: DoubleArray, a: Array<DoubleArray>): DoubleArray {
    val m = a.size
    val n = a[0].size
    if (x.size != m) throw RuntimeException("Illegal matrix dimensions.")
    val y = DoubleArray(n)
    for (j in 0 until n)
        for (i in 0 until m)
            y[j] += a[i][j] * x[i]
    return y
}

fun transpose(a: Array<DoubleArray>): Array<DoubleArray> {
    val m = a.size
    val n = a[0].size
    val b = Array(n) { DoubleArray(m) }
    for (i in 0 until m)
        for (j in 0 until n)
            b[j][i] = a[i][j]
    return b
}

fun main(args: Array<String>) {
    val matrix: Array<Array<*>> = arrayOf(
        arrayOf(1, 2, 3),
        arrayOf(4, 5, 6)
    )
    println("${Arrays.deepToString(matrix)} is ${if (isValidMatrix(matrix)) "a valid" else "an invalid"} Matrix")

    val matrix1: Array<Array<*>> = arrayOf(
        arrayOf(1, 5),
        arrayOf(2, 7.8),
        arrayOf(3, 4, 3)
    )
    println("${Arrays.deepToString(matrix1)} is ${if (isValidMatrix(matrix1)) "a valid" else "an invalid"} Matrix")

    val matrix2 = arrayOf(1, 3, 6)
    println("${Arrays.toString(matrix2)} is ${if (matrix2 is Array<*>) "a valid" else "an invalid"} Matrix")

    val matrix3 = arrayOf(
        doubleArrayOf(1.2, 2.5, 3.4),
        doubleArrayOf(1.2, 4.5, 5.46),
        doubleArrayOf(12.2, 23.5, 3.45)
    )

    val matrix4 = arrayOf(
        doubleArrayOf(11.22, 223.5, 43.4),
        doubleArrayOf(13.2, 42.5, 53.46),
        doubleArrayOf(124.2, 23.5, 34.45)
    )

    val matrix5 = doubleArrayOf(2.4, 3.7, 5.88)

    println("${Arrays.deepToString(matrix3)} and ${Arrays.deepToString(matrix4)}")
    println("===============================================================")
    println("Addition : ${Arrays.deepToString(add(matrix3, matrix4))}")
    println("Subtraction : ${Arrays.deepToString(subtract(matrix3, matrix4))}")
    println("Multiplication : ${Arrays.deepToString(multiply(matrix3, matrix4))}")

    println()
    println("${Arrays.deepToString(matrix3)} and ${Arrays.toString(matrix5)}")
    println("===============================================================")
    println("Multiplication : ${Arrays.toString(multiply(matrix3, matrix5))}")

    println()
    println("${Arrays.toString(matrix5)} and ${Arrays.deepToString(matrix3)}")
    println("===============================================================")
    println("Multiplication : ${Arrays.toString(multiply(matrix5, matrix3))}")

    println()
    println("Transpose of ${Arrays.deepToString(matrix3)} is ${Arrays.deepToString(transpose(matrix3))}")
}
