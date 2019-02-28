#### 1. Write an algorithm to find kth largest element of an integer array.

```
fun kthLargest(arr: Array<Int>, k: Int): Int {
    arr.descending()
    return arr[k - 1]
}

fun <E: Comparable<E>> Array<E>.descending() {
    val len = size
    for (i in 0 until (len - 1)) {
        for (j in 0 until (len - i - 1)) {
            if (this[j].compareTo(this[j + 1]) < 0) {
                val temp = this[j]
                this[j] = this[j + 1]
                this[j + 1] = temp
            }
        }
    }
}
```

NOTE: Here we have sorted the input array in descending order using bubble sort, but you can use any sorting algorithm you want.

#### 2. Write a snippet which tells whether a given array or list has a duplicate element or not.

```
fun <E: Comparable<E>> Array<E>.hasDuplicate(): Boolean {
    for (i in 0..(size - 1)) {
		for (j in (i + 1)..(size - 1)) {
			if (this[i] == this[j]) {
				return true
			}
		}
	}
	return false
}
```

#### 3. Find all the occurrences of a pattern from a text using any pattern matching algorithm discussed in the chapter.

```
fun search(text: String, pattern: String): IntArray {
    val result = ArrayList<Int>()
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
            result.add(textIndex - patternIndex)
            patternIndex = 0
        }
    }
    return result.toIntArray()
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
    return arr
}
```

NOTE: We have used KMP search algorithm here. But you can choose any pattern searching algorithm as per your choice.