class CircularLinkyList<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(internal var prev: Node<E>?, internal var element: E, internal var next: Node<E>?)

    fun getFirst() = head?.element

    fun getLast() = tail?.element

    fun removeFirst() = if (head == null) null else unlink(head!!)

    fun removeLast() = if (tail == null) null else unlink(tail!!)

    fun addFirst(element: E) {
        linkHead(element)
    }

    fun addLast(element: E) {
        linkTail(element)
    }

    fun add(element: E) {
        linkTail(element)
    }

    fun remove(element: E): Boolean {
        if (head == null) return false
        var curr = head
        do {
            if (curr!!.element == element) {
                unlink(curr)
                return true
            }
            curr = curr.next
        } while (curr != head)
        return false
    }

    fun size() = size

    operator fun contains(element: E) = indexOf(element) != -1

    fun get(index: Int): E {
        validateElementIndex(index)
        return node(index).element
    }

    fun set(index: Int, element: E): E {
        validateElementIndex(index)
        val x = node(index)
        val oldVal = x.element
        x.element = element
        return oldVal
    }

    fun add(index: Int, element: E) {
        validatePositionIndex(index)
        if (index == size) {
            linkTail(element)
        } else {
            linkBefore(element, node(index))
        }
    }

    fun remove(index: Int): E {
        validateElementIndex(index)
        return unlink(node(index))
    }

    fun indexOf(element: E): Int {
        if (head == null) return -1
        var index = 0
        var x = head
        do {
            if (element == x!!.element)
                return index
            index++
            x = x.next
        } while (x != tail)
        return -1
    }

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

    private fun linkTail(element: E) {
        val t = tail
        val newNode = Node<E>(t, element, head)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
            head!!.prev = newNode
        }
        size++
    }

    private fun linkBefore(element: E, succ: Node<E>) {
        val pred = succ.prev
        val newNode = Node(pred, element, succ)
        succ.prev = newNode
        if (pred == tail) {
            head = newNode
        }
        pred?.next = newNode
        size++
    }

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

    private fun node(index: Int): Node<E> {
        if (index < size shr 1) {
            var x = head
            for (i in 0 until index)
                x = x!!.next
            return x!!
        } else {
            var x = tail
            for (i in size - 1 downTo index + 1)
                x = x!!.prev
            return x!!
        }
    }

    private fun validateElementIndex(index: Int) {
        if (index < 0 || index >= size)
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
    }

    private fun validatePositionIndex(index: Int) {
        if (index < 0 && index > size)
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
    }

    private fun outOfBoundsMsg(index: Int): String {
        return "Index: $index, Size: $size"
    }

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
}

fun main(args: Array<String>) {
    val list = CircularLinkyList<String>()
    println("First item of the linky list is - ${list.getFirst()}")
    println("Last item of the linky list is - ${list.getLast()}")

    println()
    list.add("Kotlin")
    println("First item of the linky list is - ${list.getFirst()}")
    println("Last item of the linky list is - ${list.getLast()}")

    println()
    list.add("Java")
    println("First item of the linky list is - ${list.getFirst()}")
    println("Last item of the linky list is - ${list.getLast()}")

    list.add("C#")
    list.add("Python")
    list.add("JavaScript")

    println()
    println("Elements at list - $list")
    list.remove("JavaScript")
    println("Elements at list after removing JavaScript - $list")
    list.remove("Kotlin")
    println("Elements at list after removing Kotlin - $list")
    list.remove("C#")
    println("Elements at list after removing C# - $list")
    list.remove("Java")
    println("Elements at list after removing Java - $list")
    list.remove("Python")
    println("Elements at list after removing Python - $list")

    testGetFirst()
    testAdd()
    testGet()
    testSet()
    testRemoveFirst()
    testRemoveLast()
    testRemoveValue()
}

fun testGetFirst() {
    println()
    println("==================================")
    println("getFirst method testing started")
    val list = CircularLinkyList<String>()
    println(list.getFirst() == null)

    list.add("Kotlin")
    println(list.getFirst() == "Kotlin")

    list.add("Java")
    println(list.getFirst() == "Kotlin")

    list.add("Python")
    println(list.getFirst() == "Kotlin")

    list.add(0, "Python")
    println(list.getFirst() == "Python")

    list.add(1, "JavaScript")
    println(list.getFirst() == "Python")

    list.set(0, "JavaScript")
    println(list.getFirst() == "JavaScript")

    list.set(1, "Kotlin")
    println(list.getFirst() == "JavaScript")

    list.addFirst("Kotlin")
    println(list.getFirst() == "Kotlin")

    list.addLast("JavaScript")
    println(list.getFirst() == "Kotlin")

    println("getFirst method testing ended")
    println("==================================")
    println()
    println("Elements at LinkyList - $list")

    list.addFirst("Kotlin")
    println("Elements at LinkyList - $list")

    list.addFirst("Kotlin")
    println("Elements at LinkyList - $list")

    list.addFirst("Java")
    println("Elements at LinkyList - $list")

    list.addFirst("Python")
    println("Elements at LinkyList - $list")
}

fun testAdd() {
    println()
    println("==================================")
    println("testAdd method testing started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")
    println("Elements at LinkyList - $list")

    println()
    list.add(1, "JavaScript")
    println("Elements at LinkyList - $list")

    println()
    list.add(2, "TypeScript")
    println("Elements at LinkyList - $list")

    println()
    list.add(3, "CofeeScript")
    println("Elements at LinkyList - $list")

    println()
    list.add(7, "MongoDB")
    println("Elements at LinkyList - $list")

    println()
    list.add(0, "SQL")
    println("Elements at LinkyList - $list")

    println("testAdd method testing started")
    println("==================================")
}

fun testGet() {
    println()
    println("=================================")
    println("Testing get started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("0th Index - ${list.get(0)}")
    println("1st Index - ${list.get(1)}")
    println("2nd Index - ${list.get(2)}")
    println("3rd Index - ${list.get(3)}")
    println("4th Index - ${list.get(4)}")
    println("Testing get ended")
    println("=================================")
}

fun testSet() {
    println()
    println("=================================")
    println("Testing set started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("0th Index - ${list.set(0, "Edited Kotlin")}")
    println("1st Index - ${list.set(1, "Edited Java")}")
    println("2nd Index - ${list.set(2, "Edited C#")}")
    println("3rd Index - ${list.set(3, "Edited C")}")
    println("4th Index - ${list.set(4, "Edited C++")}")
    println("Final list - $list")
    println("Testing set ended")
    println("=================================")
}

fun testRemoveFirst() {
    println()
    println("=================================")
    println("Testing removeFirst started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    list.removeFirst()
    println("List - $list")
    println("Testing removeFirst ended")
    println("=================================")
}

fun testRemoveLast() {
    println()
    println("=================================")
    println("Testing removeLast started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    list.removeLast()
    println("List - $list")
    println("Testing removeLast ended")
    println("=================================")
}

fun testRemoveValue() {
    println()
    println("=================================")
    println("Testing testRemoveValue started")
    val list = CircularLinkyList<String>()
    list.add("Kotlin")
    list.add("Java")
    list.add("C#")
    list.add("C")
    list.add("C++")

    println("JavaScript" in list)
    println("Kotlin" in list)

    println("List - $list")
    list.remove("Java")
    println("List - $list")
    list.remove("Kotlin")
    println("List - $list")
    list.remove("JavaScript")
    println("List - $list")
    list.remove("Python")
    println("List - $list")
    println("Testing testRemoveValue ended")
    println("=================================")
}
