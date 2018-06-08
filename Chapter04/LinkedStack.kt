import java.util.Arrays

class LinkedStack<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(internal var element: E, internal var next: Node<E>?)

    fun push(element: E) {
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

    fun pop(): E {
        if (size == 0) throw LinkedStackUnderflowException()
        val index = --size
        val obj = elements[index]
        elements[index] = null
        return obj as E
    }

    fun peek() = try {
        elements[size - 1] as E
    } catch (e: IndexOutOfBoundsException) {
        throw LinkedStackUnderflowException();
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

class LinkedStackUnderflowException : RuntimeException()

fun main(args: Array<String>) {
    val animals = LinkedStack<String>(10)
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
}
