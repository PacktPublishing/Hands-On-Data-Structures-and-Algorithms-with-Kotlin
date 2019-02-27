#### 1. Write an API to push all the elements of an array to a stack.

```
fun pushAll(newElements: Array<E>) {
    val newSize = size + newElements.size
    if (elements.size < newSize) {
        // New sizing can be of any logic as per requirement
        val newArray = arrayOfNulls<Any>(newSize + minCapacityIncrement)
        System.arraycopy(elements, 0, newArray, 0, size)
        elements = newArray
    }
    System.arraycopy(newElements, 0, elements, size, newElements.size)
    size = newSize
}
```

#### 2. Write an API to enqueue all the elements of an array to a queue.

```
fun enqueueAll(newElements: Array<E>) {
    val newSize = size + newElements.size
    if (elements.size < newSize) {
        // New sizing can be of any logic as per requirement
        val newArray = arrayOfNulls<Any>(newSize + minCapacityIncrement)
        System.arraycopy(elements, 0, newArray, 0, size)
        elements = newArray
    }
    System.arraycopy(newElements, 0, elements, size, newElements.size)
    size = newSize
}
```

#### 3. Write an API to pop a given number of elements from the stack.

```
fun pop(count: Int) {
    if (size == 0 || size < count) throw StackUnderflowException()
    for (i in 0 until count) {
        elements[--size] = null
    }
}
```

#### 4. Write an API to dequeue a given number of elements from the queue.

```
fun dequeue(count: Int) {
    if (size == 0 || size < count) throw QueueUnderflowException()
    System.arraycopy(elements, count, elements, 0, size - count)
    size -= count
    for (i in 0 until count) {
        elements[size + i] = null
    }
}
```

#### 5. Write APIs called stackOf() and queueOf() which works similar to arrayOf().
We need to create a constructor in both Stack and Queue class, which accepts an array.

```
constructor(elements: Array<E>) {
    this.elements = elements as Array<Any?>
    size += elements.size
}
```

**stackOf()** API in Stack.kt:
```
inline fun <reified T> stackOf(vararg elements: T) = Stack<T>(elements as Array<T>)
```

**queueOf()** API in Queue.kt:
```
inline fun <reified T> queueOf(vararg elements: T) = Queue<T>(elements as Array<T>)
```
