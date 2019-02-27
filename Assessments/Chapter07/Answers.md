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

Bubble sort with an immutable list API:
```
fun <E: Comparable<E>> List<E>.bubbleSort(): List<E> {
    val len = size
    val resultList = toMutableList()
    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (resultList[j].compareTo(resultList[j + 1]) > 0) {
                val temp = resultList[j]
                resultList[j] = resultList[j + 1]
                resultList[j + 1] = temp
            }
        }
    }
    return resultList
}
```

Selection sort with immutable list API:
```
fun <E: Comparable<E>> List<E>.selectionSort(): List<E> {
    val len = size
    val resultList = toMutableList()
    // Find the minimum value of the array
    for (i in 0 until (len - 1)) {
        // Getting the index where minimum value is present
        var minIndex = i
        for (j in (i + 1) until len) {
            if (resultList[j].compareTo(resultList[minIndex]) < 0) minIndex = j
        }

        // We got the minimum element, now swap that to first element
        val temp = resultList[minIndex]
        resultList[minIndex] = resultList[i]
        resultList[i] = temp
    }
    return resultList
}
```

Insertion sort with immutable list API:
```
fun <E: Comparable<E>> List<E>.insertionSort(): List<E> {
    val len = size
    val resultList = toMutableList()
    for (i in 1 until len) {
        var key = resultList[i]
        var j = i - 1;

        while(j >= 0 && resultList[j].compareTo(key) > 0) {
            resultList[j + 1] = resultList[j]
            j--
        }
        resultList[j + 1] = key
    }
    return resultList
}
```

Quick sort with immutable list API:
```
fun <E: Comparable<E>> List<E>.quickSort(): List<E> {
    val resultList = toMutableList()
    sort(resultList, 0, size - 1)
    return resultList
}

private fun <E: Comparable<E>> sort(arr: MutableList<E>, low: Int, high: Int) {
    if (low < high) {
        val partitionIndex = partition(arr, low, high)

        sort(arr, low, partitionIndex - 1)
        sort(arr, partitionIndex + 1, high)
    }
}

private fun <E: Comparable<E>> partition(arr: MutableList<E>, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1
    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            arr[i] = arr[j].also { arr[j] = arr[i] }
        }
    }
    arr[i + 1] = arr[high].also { arr[high] = arr[i + 1] }
    return i + 1;
}
```
