import java.util.Arrays

class Deque<E> {
    private val minCapacityIncrement = 12

    private var elements: Array<Any?>
    private var size = 0

    constructor() {
        this.elements = arrayOf()
    }

    constructor(initialCapacity: Int) {
        this.elements = arrayOfNulls(initialCapacity)
    }

    fun enqueueFront(element: E) {
        if (size == elements.size) {
            val newArray = arrayOfNulls<Any>(size + if (size < minCapacityIncrement / 2)
                minCapacityIncrement
            else
                size shr 1)
            System.arraycopy(elements, 0, newArray, 1, size)
            elements = newArray
        } else {
            System.arraycopy(elements, 0, elements, 1, size)
        }
        elements[0] = element
        size++
    }

    fun enqueueRear(element: E) {
        if (size == elements.size) {
            val newArray = arrayOfNulls<Any>(size + if (size < minCapacityIncrement / 2)
                minCapacityIncrement
            else
                size shr 1)
            System.arraycopy(elements, 0, newArray, 0, size)
            elements = newArray
        }
        elements[size++] = element
    }

    fun dequeueFront(): E {
        if (size == 0) throw DequeUnderflowException()
        val oldVal = elements[0]
        elements[0] = null
        System.arraycopy(elements, 1, elements, 0, --size)
        return oldVal as E
    }

    fun dequeueRear(): E {
        if (size == 0) throw DequeUnderflowException()
        val oldVal = elements[--size]
        elements[size] = null
        return oldVal as E
    }

    fun front() = try {
        elements[0] as E
    } catch (e: IndexOutOfBoundsException) {
        throw DequeUnderflowException();
    }
    
    fun rear() = try {
        elements[size - 1] as E
    } catch (e: IndexOutOfBoundsException) {
        throw DequeUnderflowException();
    }

    fun isEmpty() = size == 0

    fun isFull() = size == elements.size

    override fun toString(): String {
        if (size == 0) return "[]"
        val length = size - 1
        val builder = StringBuilder(size * 16)
        builder.append('[')
        for (i in 0 until length) {
            builder.append(elements[i])
            builder.append(", ")
        }
        builder.append(elements[length])
        builder.append(']')
        return builder.toString()
    }
}

class DequeUnderflowException : RuntimeException()

fun main(args: Array<String>) {
    val animals = Deque<String>(10)
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.enqueueRear("Lion")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.enqueueRear("Tiger")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.enqueueRear("Crocodile")
    animals.enqueueRear("Cat")
    animals.enqueueRear("Dog")
    animals.enqueueRear("Cow")
    animals.enqueueRear("Cangaroo")
    animals.enqueueRear("Rat")
    animals.enqueueRear("Bull")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueueRear("Ox")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueueRear("Zebra")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeueFront()
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeueFront()
    println("Animals - $animals")
    animals.dequeueRear()
    println("Animals - $animals")
    animals.enqueueFront("Zebra")
    println("Animals - $animals")
    animals.enqueueRear("Tiger")
    println("Animals - $animals")
    animals.enqueueFront("Octopus")
    println("Animals - $animals")
}
