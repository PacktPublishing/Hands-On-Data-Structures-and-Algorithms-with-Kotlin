class LinkyList<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(internal var element: E, internal var next: Node<E>?)

    fun getFirst() = head?.element

    fun getLast() = tail?.element

    fun removeFirst() = unlinkHead()

    fun removeLast() = unlinkTail()

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
        var curr = head
        while (curr != null) {
            if (curr.element == element) {
                unlink(curr)
                return true
            }
            curr = curr.next
        }
        return false
    }

    fun clear() {
        var x = head
        while (x != null) {
            val next = x.next
            x.next = null
            x = next
        }
        tail = null
        head = tail
        size = 0
    }

    fun size() = size

    operator fun contains(element: E) = indexOf(element) != -1

    fun get(index: Int): E {
        validateIndex(index)
        return node(index).element
    }

    fun set(index: Int, element: E): E {
        validateIndex(index)
        val x = node(index)
        val oldVal = x.element
        x.element = element
        return oldVal
    }

    fun add(index: Int, element: E) {
        validateIndex(index)
        if (index == size) {
            linkTail(element)
        } else {
            linkBefore(element, node(index))
        }
    }

    fun remove(index: Int): E {
        validateIndex(index)
        return unlink(node(index))
    }

    fun indexOf(element: E): Int {
        var index = 0
        var x = head
        while (x != null) {
            if (element == x.element)
                return index
            index++
            x = x.next
        }
        return -1
    }

    private fun linkHead(element: E) {
        val h = head
        val newNode = Node<E>(element, h)
        head = newNode
        if (h == null) {
            tail = newNode
        }
        size++
    }

    private fun linkTail(element: E) {
        val t = tail
        val newNode = Node<E>(element, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        size++
    }

    private fun linkBefore(element: E, succ: Node<E>) {
        val pred = getPrevious(succ)
        val newNode = Node(element, succ)
        if (pred == null) {
            head = newNode
        } else {
            pred.next = newNode
        }
        size++
    }

    private fun unlinkHead() {
        head?.let {
            val next = it.next
            it.next = null
            head = next
            if (next == null) {
                tail = null
            }
            size--
        }
    }

    private fun unlinkTail() {
        tail?.let {
            val prev = getPrevious(it)
            tail = prev
            if (prev == null) {
                tail = null
            } else {
                prev.next = null
            }
            size--
        }
    }

    private fun unlink(curr: Node<E>): E {
        val element = curr.element
        val next = curr.next
        val prev = getPrevious(curr)

        if (prev == null) {
            head = next
        } else {
            prev.next = next
            curr.next = null
        }

        if (next == null) {
            prev?.next = null
            tail = prev
        } else {
            prev?.next = next
            curr.next = null
        }

        size--
        return element
    }

    private fun getPrevious(node: Node<E>): Node<E>? {
        if (head != null && node == head) return null
        var curr = head
        while (curr != null) {
            if (curr.next == node) {
                return curr
            }
            curr = curr.next
        }
        return null
    }

    private fun node(index: Int): Node<E> {
        var x = head
        for (i in 0 until index) {
            x = x!!.next
        }
        return x!!
    }

    private fun validateIndex(index: Int) {
        if (index < 0 || index >= size)
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
            while (curr != null) {
                sb.append(curr.element)
                curr = curr.next
                if (curr?.element == null) {
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
    val linkyList = LinkyList<String>()
    println("First item of the linky list is - ${linkyList.getFirst()}")
    println("Last item of the linky list is - ${linkyList.getLast()}")

    println()
    linkyList.add("Kotlin")
    println("First item of the linky list is - ${linkyList.getFirst()}")
    println("Last item of the linky list is - ${linkyList.getLast()}")

    println()
    linkyList.add("Java")
    println("First item of the linky list is - ${linkyList.getFirst()}")
    println("Last item of the linky list is - ${linkyList.getLast()}")

    linkyList.add("C#")
    linkyList.add("Python")
    linkyList.add("JavaScript")

    println()
    println("Elements at linkyList - $linkyList")
    linkyList.remove("JavaScript")
    println("Elements at linkyList after removing JavaScript - $linkyList")
    linkyList.remove("Kotlin")
    println("Elements at linkyList after removing Kotlin - $linkyList")
    linkyList.remove("C#")
    println("Elements at linkyList after removing C# - $linkyList")
    linkyList.remove("Java")
    println("Elements at linkyList after removing Java - $linkyList")
    linkyList.remove("Python")
    println("Elements at linkyList after removing Python - $linkyList")

    testGetFirst()
}

fun testGetFirst() {
    println()
    println("Add method testing started")
    val linkyList = LinkyList<String>()
    println(linkyList.getFirst() == null)

    linkyList.add("Kotlin")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.add("Java")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.add("Python")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.add(0, "Python")
    println(linkyList.getFirst() == "Python")

    linkyList.add(1, "JavaScript")
    println(linkyList.getFirst() == "Python")

    linkyList.set(0, "JavaScript")
    println(linkyList.getFirst() == "JavaScript")

    linkyList.set(1, "Kotlin")
    println(linkyList.getFirst() == "JavaScript")

    linkyList.addFirst("Kotlin")
    println(linkyList.getFirst() == "Kotlin")

    linkyList.addLast("JavaScript")
    println(linkyList.getFirst() == "Kotlin")
}
