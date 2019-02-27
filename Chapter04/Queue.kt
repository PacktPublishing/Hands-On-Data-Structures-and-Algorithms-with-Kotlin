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

    constructor(elements: Array<E>) {
        this.elements = elements as Array<Any?>
        size += elements.size
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

    fun dequeue(): E {
        if (size == 0) throw QueueUnderflowException()
        val oldVal = elements[0]
        elements[0] = null
        System.arraycopy(elements, 1, elements, 0, --size)
        return oldVal as E
    }

    fun dequeue(count: Int) {
        if (size == 0 || size < count) throw QueueUnderflowException()
        System.arraycopy(elements, count, elements, 0, size - count)
        size -= count
        for (i in 0 until count) {
            elements[size + i] = null
        }
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

inline fun <reified T> queueOf(vararg elements: T) = Queue<T>(elements as Array<T>)

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

    println()
    val languages = Queue(arrayOf("Kotlin", "Java"))
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.enqueue("C")
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.dequeue()
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.dequeue()
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.dequeue()
    println("$languages - Empty? -- ${languages.isEmpty()}")

    testEnqueueDequeue()
    testQueueOf()
}

fun testEnqueueDequeue() {
    println()
    val numbers = Queue<Int>(10)
    numbers.enqueueAll(Array<Int>(100) { i -> i })
    println(numbers)
    println()
    numbers.enqueueAll(arrayOf(300, 400, 500))
    println(numbers)
    println()
    numbers.dequeue(10)
    println(numbers)
    println()
    numbers.enqueueAll(arrayOf(100, 200, 1000))
    println(numbers)
    println()
    numbers.dequeue(60)
    println(numbers)
    println()
}

fun testQueueOf() {
    val languages = queueOf("Kotlin", "Java")
    println(languages)
    languages.enqueue("C")
    println(languages)
    languages.dequeue()
    println(languages)
}
