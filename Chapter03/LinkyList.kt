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

    fun addV2(index: Int, element: E) {
        validatePositionIndex(index)
        if (index == 0) linkHead(element)
        else {
            var x = head
            val prevIndex = index - 1
            for (i in 0 until prevIndex) {
                x = x!!.next
            }
            val next = x!!.next
            val newNode = Node(element, next)
            x.next = newNode
            size++
        }
    }

    fun remove(index: Int): E {
        validateElementIndex(index)
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
                head = null
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
    testAddV2()
    testGet()
    testSet()
    testRemoveFirst()
    testRemoveLast()
    testRemoveValue()
    testAddAll()
}

fun testGetFirst() {
    println()
    println("==================================")
    println("getFirst method testing started")
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

    println("getFirst method testing ended")
    println("==================================")
    println()
    linkyList.clear()
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Kotlin")
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Kotlin")
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Java")
    println("Elements at LinkyList - $linkyList")

    linkyList.addFirst("Python")
    println("Elements at LinkyList - $linkyList")
}

fun testAddV2() {
    println()
    println("==================================")
    println("testAddV2 method testing started")
    val linkyList = LinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(1, "JavaScript")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(2, "TypeScript")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(3, "CofeeScript")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(7, "MongoDB")
    println("Elements at LinkyList - $linkyList")

    println()
    linkyList.addV2(0, "SQL")
    println("Elements at LinkyList - $linkyList")

    println("testAddV2 method testing started")
    println("==================================")
}

fun testGet() {
    println()
    println("=================================")
    println("Testing get started")
    val linkyList = LinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("0th Index - ${linkyList.get(0)}")
    println("1st Index - ${linkyList.get(1)}")
    println("2nd Index - ${linkyList.get(2)}")
    println("3rd Index - ${linkyList.get(3)}")
    println("4th Index - ${linkyList.get(4)}")
    println("Testing get ended")
    println("=================================")
}

fun testSet() {
    println()
    println("=================================")
    println("Testing set started")
    val linkyList = LinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("0th Index - ${linkyList.set(0, "Edited Kotlin")}")
    println("1st Index - ${linkyList.set(1, "Edited Java")}")
    println("2nd Index - ${linkyList.set(2, "Edited C#")}")
    println("3rd Index - ${linkyList.set(3, "Edited C")}")
    println("4th Index - ${linkyList.set(4, "Edited C++")}")
    println("Final list - $linkyList")
    println("Testing set ended")
    println("=================================")
}

fun testRemoveFirst() {
    println()
    println("=================================")
    println("Testing removeFirst started")
    val linkyList = LinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    linkyList.removeFirst()
    println("List - $linkyList")
    println("Testing removeFirst ended")
    println("=================================")
}

fun testRemoveLast() {
    println()
    println("=================================")
    println("Testing removeLast started")
    val linkyList = LinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    linkyList.removeLast()
    println("List - $linkyList")
    println("Testing removeLast ended")
    println("=================================")
}

fun testRemoveValue() {
    println()
    println("=================================")
    println("Testing testRemoveValue started")
    val linkyList = LinkyList<String>()
    linkyList.add("Kotlin")
    linkyList.add("Java")
    linkyList.add("C#")
    linkyList.add("C")
    linkyList.add("C++")

    println("JavaScript" in linkyList)
    println("Kotlin" in linkyList)

    println("List - $linkyList")
    linkyList.remove("Java")
    println("List - $linkyList")
    linkyList.remove("Kotlin")
    println("List - $linkyList")
    linkyList.remove("JavaScript")
    println("List - $linkyList")
    linkyList.remove("Python")
    println("List - $linkyList")
    println("Testing testRemoveValue ended")
    println("=================================")
}

fun testAddAll() {
    println()
    println("=================================")
    println("Testing testAddAll started")
    
    val linkyList = LinkyList<String>()

    // Add few elements at begining of the linkedlist
    linkyList.addAll(0, arrayOf<String>("C", "C++"))
    println("List - $linkyList")
    linkyList.addAll(0, arrayOf<String>("Java", "Kotlin"))
    println("List - $linkyList")
    // Add few elements at middle of the linkedlist
    linkyList.addAll(2, arrayOf<String>("Python", "R"))
    println("List - $linkyList")
    // Add few elements at end of the linkedlist
    linkyList.addAll(linkyList.size(), arrayOf<String>("C#", "MATLAB"))
    println("List - $linkyList")
    println("Testing testAddAll ended")
    println("=================================")
}
