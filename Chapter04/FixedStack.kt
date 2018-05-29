import java.util.Arrays

class FixedStack<E> {

    private val elements: Array<Any?>
    private var size = 0

    constructor(capacity: Int) {
        this.elements = arrayOfNulls(capacity)
    }

    fun push(element: E) {
        if (size == elements.size) {
            throw StackOverflowException()
        }
        elements[size++] = element
    }

    fun pop(): E {
        if (size == 0) throw StackUnderflowException()
        val index = --size
        val obj = elements[index]
        elements[index] = null
        return obj as E
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

class StackOverflowException : RuntimeException()

fun main(args: Array<String>) {
    val animals = FixedStack<String>(10)
    System.out.println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    animals.push("Lion")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    animals.push("Tiger")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")

    animals.push("Crocodile")
    animals.push("Cat")
    animals.push("Dog")
    animals.push("Cow")
    animals.push("Cangaroo")
    animals.push("Rat")
    animals.push("Bull")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")
    animals.push("Ox")
    System.out.println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")
    try {
        animals.push("Zebra")
    } catch(e: StackOverflowException) {
        System.out.println("Exception Expected!!!")
    }
    animals.pop()
    System.out.println("$animals - Empty? -- ${animals.isEmpty()} - Full? -- ${animals.isFull()}")
}
