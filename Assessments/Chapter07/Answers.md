#### 1. Implement Quick Sort in descending order.

Below snippet is an implementation of sorting an array in descending order.

```
fun <E: Comparable<E>> Array<E>.descending() {
    descending(this, 0, size - 1)
}

private fun <E: Comparable<E>> descending(arr: Array<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = descendingPartition(arr, low, high)

        descending(arr, low, partitionIndex - 1)
        descending(arr, partitionIndex + 1, high)
    }
}

private fun <E: Comparable<E>> descendingPartition(arr: Array<E>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] >= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1;
}
```

Below snippet is an implementation of sorting an immutable list in descending order.
```
fun <E: Comparable<E>> MutableList<E>.descending() {
    descending(this, 0, size - 1)
}

private fun <E: Comparable<E>> descending(arr: MutableList<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = descendingPartition(arr, low, high)

        descending(arr, low, partitionIndex - 1)
        descending(arr, partitionIndex + 1, high)
    }
}

private fun <E: Comparable<E>> descendingPartition(arr: MutableList<E>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] >= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1;
}
```

#### 2. Implement all the sorting algorithms discussed above for immutable list.
