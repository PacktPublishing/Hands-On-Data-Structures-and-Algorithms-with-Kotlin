import java.util.Arrays

class Queue<E> {
    private val minCapacityIncrement = 12

    private var elements: Array<Any?>
    private var size = 0

    constructor() {
        this.elements = arrayOf()
    }

    constructor(initialCapacity: Int) {
        this.elements = arrayOfNulls(initialCapacity)
    }

    fun enqueue(element: E) {
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

    fun dequeue(): E {
        if (size == 0) throw QueueUnderflowException()
        val oldVal = elements[0]
        elements[0] = null
        System.arraycopy(elements, 1, elements, 0, --size)
        return oldVal as E
    }

    fun front() = try {
        elements[0] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
    }
    
    fun rear() = try {
        elements[size - 1] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
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

class QueueUnderflowException : RuntimeException()

fun main(args: Array<String>) {
    val animals = Queue<String>(10)
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.enqueue("Lion")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.enqueue("Tiger")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.enqueue("Crocodile")
    animals.enqueue("Cat")
    animals.enqueue("Dog")
    animals.enqueue("Cow")
    animals.enqueue("Cangaroo")
    animals.enqueue("Rat")
    animals.enqueue("Bull")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Ox")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Zebra")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
}
