import java.util.*

fun <E: Comparable<E>> Array<E>.sort() {
    sort(this, 0, this.size - 1)
}

private fun <E: Comparable<E>> sort(arr: Array<E>, left: Int, right: Int) {
    println("Sort - Left - $left, Right - $right")
    if (left < right) {
        val middle = (left + right) / 2
        sort(arr, left, middle)
        sort(arr, middle + 1, right)

        merge(arr, left, middle, right)
    }
}

private fun <E: Comparable<E>> merge(arr: Array<E>, left: Int, middle: Int, right: Int) {
    println(Arrays.toString(arr))
    println("Left - $left, Right - $right, Middle - $middle")
    val leftSubArrSize = middle - left + 1
    val rightSubArrSize = right - middle

    val leftArr = arr.copyOfRange(left, middle)
    val rightArr = arr.copyOfRange(middle + 1, right)
    println("Array - ${Arrays.toString(arr)}")
    println("Left Array - ${Arrays.toString(leftArr)}")
    println("Right Array - ${Arrays.toString(rightArr)}")

    var leftArrIndex = 0
    var rightArrIndex = 0
    var mergedArrIndex = left
    while(leftArrIndex < leftSubArrSize && rightArrIndex < rightSubArrSize) {
        if (leftArr[leftArrIndex] <= rightArr[rightArrIndex]) {
            arr[mergedArrIndex] = leftArr[leftArrIndex]
            leftArrIndex++
        } else {
            arr[mergedArrIndex] = rightArr[rightArrIndex]
            rightArrIndex++
        }
        mergedArrIndex++
    }

    while(leftArrIndex < leftSubArrSize) {
        arr[mergedArrIndex] = leftArr[leftArrIndex]
        leftArrIndex++
        mergedArrIndex++
    }

    while(rightArrIndex < rightSubArrSize) {
        arr[mergedArrIndex] = rightArr[rightArrIndex]
        rightArrIndex++
        mergedArrIndex++
    }
}

fun <E: Comparable<E>> MutableList<E>.sort() {
    sort(this, 0, this.size - 1)
}

private fun <E: Comparable<E>> sort(arr: MutableList<E>, left: Int, right: Int) {
    if (left < right) {
        val middle = (left + right) / 2
        sort(arr, left, middle)
        sort(arr, middle + 1, right)

        merge(arr, left, middle, right)
    }
}

private fun <E: Comparable<E>> merge(arr: MutableList<E>, left: Int, middle: Int, right: Int) {
    val leftSubArrSize = middle - left + 1
    val rightSubArrSize = right - middle

    val leftArr = arr.subList(left, middle)
    val rightArr = arr.subList(middle + 1, right)

    var leftArrIndex = 0
    var rightArrIndex = 0
    var mergedArrIndex = left
    while(leftArrIndex < leftSubArrSize && rightArrIndex < rightSubArrSize) {
        if (leftArr[leftArrIndex] <= rightArr[rightArrIndex]) {
            arr[mergedArrIndex] = leftArr[leftArrIndex]
            leftArrIndex++
        } else {
            arr[mergedArrIndex] = rightArr[rightArrIndex]
            rightArrIndex++
        }
        mergedArrIndex++
    }

    while(leftArrIndex < leftSubArrSize) {
        arr[mergedArrIndex] = leftArr[leftArrIndex]
        leftArrIndex++
        mergedArrIndex++
    }

    while(rightArrIndex < rightSubArrSize) {
        arr[mergedArrIndex] = rightArr[rightArrIndex]
        rightArrIndex++
        mergedArrIndex++
    }
}

fun main(args: Array<String>) {
    val nums = arrayOf(2, 12, 89, 23, 76, 43, 12)
    nums.sort()
    println(Arrays.toString(nums))

    val languages = mutableListOf("Kotlin", "Java", "C#", "R", "Python", "Scala", "Groovy", "C", "C++")
    languages.sort()
    println(languages)
}
