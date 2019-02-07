import java.util.Arrays

class LinkedQueue<E> {
    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E> constructor(internal var prev: Node<E>?, internal var element: E, internal var next: Node<E>?)

    fun enqueue(element: E) {
        val t = tail
        val newNode = Node<E>(t, element, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        size++
    }

    fun dequeue(): E {
        head?.let {
            val next = it.next
            it.next = null
            head = next
            if (next == null) {
                tail = null
            } else {
                next.prev = null
            }
            size--
            return it.element
        } ?: throw QueueUnderflowException()
    }

    fun front(): E {
        head?.let {
            return it.element
        } ?: throw QueueUnderflowException()
    }

    fun rear(): E {
        tail?.let {
            return it.element
        } ?: throw QueueUnderflowException()
    }

    fun isEmpty() = size == 0

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

class QueueUnderflowException : RuntimeException()

fun main(args: Array<String>) {
    val animals = LinkedQueue<String>()
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
    animals.dequeue()
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    System.out.println("$animals - Empty? -- ${animals.isEmpty()}")
    // First element
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    animals.enqueue("Peacock")
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    System.out.println("Rear element - ${animals.rear()} - Empty? -- ${animals.isEmpty()}")
    System.out.println("Rear element - ${animals.rear()} - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    animals.dequeue()
    System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")
    animals.dequeue()
    try {
        System.out.println("Front element - ${animals.front()} - Empty? -- ${animals.isEmpty()}")   
    } catch(e: QueueUnderflowException) {
        System.out.println("Already empty!!!")
    }
}
