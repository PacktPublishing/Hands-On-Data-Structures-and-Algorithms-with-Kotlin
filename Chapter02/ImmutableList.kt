import java.util.Arrays

class ImmutableList<E> {
    private val minCapacityIncrement = 12

    var elements: Array<Any?>
    private var size = 0

    constructor() {
        this.elements = arrayOf()
    }

    constructor(initialCapacity: Int) {
        if (initialCapacity > 0) {
            this.elements = Array(initialCapacity) {_ -> null}
        } else if (initialCapacity == 0) {
            this.elements = emptyArray()
        } else {
            throw IllegalArgumentException("Illegal Capacity: $initialCapacity")
        }
    }

    constructor(vararg items: E) {
        this.elements = items as Array<Any?>
        size = items.size
    }

    fun add(element: E): ImmutableList<E> {
        val s = size
        val newList = ImmutableList<E>(s + 1)
        System.arraycopy(elements, 0, newList.elements, 0, s)
        newList.elements[s] = element
        newList.size = s + 1
        return newList
    }

    fun get(index: Int): E {
        if (index >= size)
            throwIndexOutOfBoundsException(index, size)
        return elements[index] as E
    }

    fun set(index: Int, element: E): ImmutableList<E> {
        if (index >= size)
            throwIndexOutOfBoundsException(index, size)

        val s = size
        val newList = ImmutableList<E>(s)
        System.arraycopy(elements, 0, newList.elements, 0, s)
        newList.elements[index] = element
        newList.size = s
        return newList
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
    val immutableList = ImmutableList<String>("A", "B", "C")
    val modifiedList = immutableList.add("D")
    println("Initial List - $immutableList")
    println("List after adding an element - $modifiedList")

    val list2 = immutableList.set(1, "E")
    println("Initial List - $immutableList")
    println("List after replacing an element at 1st index - $list2")
}
