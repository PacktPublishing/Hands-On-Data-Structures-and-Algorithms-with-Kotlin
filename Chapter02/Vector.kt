import java.util.Arrays

class Vector<E> {
    private val minCapacityIncrement = 12

    var elements: Array<Any?>
    private var size = 0

    constructor() {
        this.elements = arrayOf()
    }

    constructor(initialCapacity: Int) {
        if (initialCapacity > 0) {
            this.elements = Array(initialCapacity) {i -> null}
        } else if (initialCapacity == 0) {
            this.elements = emptyArray()
        } else {
            throw IllegalArgumentException("Illegal Capacity: $initialCapacity")
        }
    }

    fun add(element: E): Boolean {
        var a = elements
        val s = size
        if (s == a.size) {
            val newArray = arrayOfNulls<Any>(s + if (s < minCapacityIncrement / 2)
                minCapacityIncrement
            else
                s shr 1)
            System.arraycopy(a, 0, newArray, 0, s)
            a = newArray
            elements = a
        }
        a[s] = element
        size = s + 1
        return true
    }

    fun add(index: Int, element: E) {
        var a = elements
        val s = size
        if (index > s || index < 0) {
            throwIndexOutOfBoundsException(index, s)
        }
        if (s < a.size) {
            System.arraycopy(a, index, a, index + 1, s - index)
        } else {
            val newArray = arrayOfNulls<Any>(newCapacity(s))
            System.arraycopy(a, 0, newArray, 0, index)
            System.arraycopy(a, index, newArray, index + 1, s - index)
            a = newArray
            elements = a
        }
        a[index] = element
        size = s + 1
    }

    fun get(index: Int): E {
        if (index >= size)
            throwIndexOutOfBoundsException(index, size)
        return elements[index] as E
    }

    fun set(index: Int, element: E): E {
        if (index >= size)
            throwIndexOutOfBoundsException(index, size)

        val oldValue = elements[index] as E
        elements[index] = element
        return oldValue
    }

    fun remove(index: Int): E {
        if (index >= size)
            throwIndexOutOfBoundsException(index, size)

        val oldValue = elements[index] as E

        val numMoved = size - index - 1
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved)
        elements[--size] = null // clear to let GC do its work

        return oldValue
    }

    fun remove(element: E): Boolean {
        for (index in 0 until size) {
            if (element == elements[index]) {
                val numMoved = size - index - 1
                if (numMoved > 0)
                    System.arraycopy(elements, index + 1, elements, index, numMoved)
                elements[--size] = null // clear to let GC do its work
                return true
            }
        }
        return false
    }

    fun isEmpty() = size == 0

    fun size() = size

    operator fun contains(element: E): Boolean {
        return indexOf(element) >= 0
    }

    fun indexOf(element: E): Int {
        if (element == null) {
            for (i in 0 until size)
                if (elements[i] == null)
                    return i
        } else {
            for (i in 0 until size)
                if (element == elements[i])
                    return i
        }
        return -1
    }

    fun lastIndexOf(element: E): Int {
        if (element == null) {
            for (i in size - 1 downTo 0)
                if (elements[i] == null)
                    return i
        } else {
            for (i in size - 1 downTo 0)
                if (element == elements[i])
                    return i
        }
        return -1
    }

    fun clear() {
        // clear to let GC do its work
        for (i in 0 until size)
            elements[i] = null
        size = 0
    }

    fun toArray(): Array<out Any?> {
        return Arrays.copyOf(elements, size)
    }

    private fun newCapacity(currentCapacity: Int): Int {
        val increment = if (currentCapacity < minCapacityIncrement / 2)
            minCapacityIncrement
        else
            currentCapacity shr 1
        return currentCapacity + increment
    }

    private fun throwIndexOutOfBoundsException(index: Int, size: Int): IndexOutOfBoundsException {
        throw IndexOutOfBoundsException("Invalid index $index, size is $size")
    }

    override fun toString() = Arrays.toString(elements)
}

fun main(args: Array<String>) {
    val vector = Vector<String>(10)
    println("Size of newly created vector is : ${vector.size()}")
    println("Elements in vector are : $vector")

    vector.add("Kotlin")
    vector.add("Java")
    vector.add("Python")
    println("Elements in vector are : $vector")

    vector.set(2, "JavaScript")
    println("Elements in vector are : $vector")

    vector.remove("Java")
    println("Elements in vector are : $vector")

    vector.add("Python")
    vector.remove(2)
    println("Elements in vector are : $vector")
}
