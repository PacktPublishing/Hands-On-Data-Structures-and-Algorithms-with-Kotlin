#### Create an array of numbers between 0 to 500 that are multiples of 10.

```
val multiplesOfTen = Array(51) { i -> i * 10 }
```

#### Create an array with all the even indexed numbers of given array.

```
fun evenIndexedNumbers(arr: Array<Int>): IntArray {
    return arr.filterIndexed { index, _ ->
        index % 2 == 0
    }.toIntArray()
}
```

#### Write a snippet for finding a transpose of a matrix.

```
fun transpose(matrix: Array<IntArray>): Array<IntArray>? {
    var transpose: Array<IntArray>? = null
    // Considering it is a valid matrix
    val row = matrix.size
    if (row > 0) {
        val column = matrix[0].size
        if (column > 0) {
            transpose = Array(column) { IntArray(row) }
            for (i in 0..row - 1) {
                for (j in 0..column - 1) {
                    transpose[j][i] = matrix[i][j]
                }
            }
        }
    }
    return transpose
}
```

#### Write a snippet to append elements of two arrays.

```
val arr1 = arrayOf(10, 20, 30)
val arr2 = arrayOf(100, 200, 300)
val result = arr1 + arr2
```

#### Write snippet to convert wrapper typed array to a primitive array.

```
val intArray = arrayOf(1, 2, 3, 4, 5)
val output = intArray.toIntArray()

val doubleArray = arrayOf(1.2, 3.5, 4.8, 9.0)
val output1 = doubleArray.toDoubleArray()
```