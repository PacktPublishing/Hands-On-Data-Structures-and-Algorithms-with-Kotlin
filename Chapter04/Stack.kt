import java.util.Arrays

class Stack<E> {
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

    fun push(element: E) {
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

    fun pop(): E {
        if (size == 0) throw StackUnderflowException()
        val index = --size
        val obj = elements[index]
        elements[index] = null
        return obj as E
    }

    fun pop(count: Int) {
        if (size == 0 || size < count) throw StackUnderflowException()
        for (i in 0 until count) {
            elements[--size] = null
        }
    }

    fun peek() = try {
        elements[size - 1] as E
    } catch (e: IndexOutOfBoundsException) {
        throw StackUnderflowException();
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

class StackUnderflowException : RuntimeException()

inline fun <reified T> stackOf(vararg elements: T) = Stack<T>(elements as Array<T>)

fun main(args: Array<String>) {
    val animals = Stack<String>(10)
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.push("Lion")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.push("Tiger")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    animals.push("Crocodile")
    animals.push("Cat")
    animals.push("Dog")
    animals.push("Cow")
    animals.push("Cangaroo")
    animals.push("Rat")
    animals.push("Bull")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.push("Ox")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.push("Zebra")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.pop()
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")

    println()
    val languages = Stack(arrayOf("Kotlin", "Java"))
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.push("C")
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.pop()
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.pop()
    println("$languages - Empty? -- ${languages.isEmpty()}")
    languages.pop()
    println("$languages - Empty? -- ${languages.isEmpty()}")

    testPushAll()
    testPop()
    testStackOf()
}

fun testPushAll() {
    println()
    println("Testing pushAll")
    val numbers = Stack<Int>(10)
    numbers.pushAll(Array<Int>(100) { i -> i })
    println(numbers)
    numbers.pop()
    numbers.pushAll(arrayOf(1, 2, 12, 909))
    println(numbers)
}

fun testPop() {
    println()
    println("Testing pop count")
    val numbers = Stack<Int>(10)
    numbers.pushAll(Array<Int>(100) { i -> i })
    println(numbers)
    numbers.pop(20)
    numbers.pushAll(arrayOf(1, 2, 12, 909))
    println(numbers)
}

fun testStackOf() {
    val languages = stackOf("Kotlin", "Java")
    println(languages)
    languages.push("C")
    println(languages)
    languages.pop()
    println(languages)
}
