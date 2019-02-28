#### 1. Modify HashMap to have a constructor which accepts a Map<K, V> object to create itself.

This constrcutor can be found in HashMap.kt file of Chapter04 section of this repository.

```
constructor(map: Map<K, V>) {
    val size = map.size
    val newSize = when {
        size < minCapacity -> minCapacity
        else -> fetchNearestCapacity(size)
    }
    this.table = arrayOfNulls(newSize)
    if (size > 0) {
        for (entry in map) {
            putVal(entry.key, entry.value)
        }
    }
}
```

#### 2. Implement a Map whose keys are primitive integers.
