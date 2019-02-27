#### 1. Write an API in linked list (LinkyList in this book) which adds all the elements of an array to the list.

```
fun <T> addAll(index: Int, arr: Array<T>): Boolean where T : E {

    validatePositionIndex(index)

    val numNew = arr.size
    if (numNew == 0) return false
    var pred: Node<E>?
    var succ: Node<E>?
    when (index) {
        0 -> {
            succ = head
            pred = null
        }
        size -> {
            succ = null
            pred = tail
        }
        else -> {
            pred = node(index - 1)
            succ = pred.next
        }
    }

    for (item in arr) {
        val e = item as E
        val newNode = Node<E>(e, null)
        if (pred == null)
            head = newNode
        else
            pred.next = newNode
        pred = newNode
    }

    if (succ == null) {
        tail = pred
    } else {
        pred!!.next = succ
    }
    size += numNew
    return true
}
```

#### 2. Write the above API for doubly linked list (DoublyLinkyList in this book).

```
fun <T> addAll(index: Int, arr: Array<T>): Boolean where T : E {
    validatePositionIndex(index)

    val numNew = arr.size
    if (numNew == 0) return false

    var pred: Node<E>?
    var succ: Node<E>?
    when (index) {
        0 -> {
            succ = head
            pred = null
        }
        size -> {
            succ = null
            pred = tail
        }
        else -> {
            succ = node(index)
            pred = succ.prev
        }
    }

    for (item in arr) {
        val e = item as E
        val newNode = Node<E>(pred, e, null)
        if (pred == null)
            head = newNode
        else
            pred.next = newNode
        pred = newNode
    }

    if (succ == null) {
        tail = pred
    } else {
        pred!!.next = succ
        succ!!.prev = pred
    }

    size += numNew
    return true
}
```

#### 3. Write a snippet to link a node at head of a circular linked list.

```
private fun linkHead(element: E) {
    val h = head
    val newNode = Node<E>(tail, element, h)
    head = newNode
    if (h == null) {
        tail = newNode
        newNode!!.prev = tail
        newNode.next = head
    } else {
        h.prev = newNode
        tail!!.next = newNode
    }
    size++
}
```

#### 4. Write a snippet to unlink a node from circular linked list.

```
private fun unlink(curr: Node<E>): E {
    val element = curr.element
    val next = curr.next
    val prev = curr.prev

    if (curr == head) {
        head = next
    }
    if (curr == tail) {
        tail = prev
    }
    prev?.next = next
    next?.prev = prev
    curr.prev = null
    curr.next = null
    size--
    if (size == 0) {
        head = null
        tail = null
    }
    return element
}
```

#### 5. Implement toString() method of circular linked list.

```
override fun toString(): String {
    var curr = head
    if (curr == null) return "[]"
    else {
        val sb = StringBuilder()
        sb.append('[')
        for (i in 0 until size) {
            sb.append(curr!!.element)
            curr = curr.next
            if (curr == head) {
                sb.append(']')
            } else {
                sb.append(',').append(' ')
            }
        }
        return sb.toString()
    }
}
```