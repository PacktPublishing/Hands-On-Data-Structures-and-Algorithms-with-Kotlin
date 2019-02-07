import java.util.Arrays

class CircularFixedQueue<E> {

    private val capacity: Int
    private var front = -1
    private var rear = -1
    private val elements: Array<Any?>

    constructor(capacity: Int) {
        this.capacity = capacity
        this.elements = arrayOfNulls(capacity)
    }

    fun enqueue(element: E) {
        if (isFull()) throw QueueOverflowException()
        rear = (rear + 1) % capacity
        elements[rear] = element
        if (front == -1 ) front = rear
    }

    fun dequeue(): E {
        if (isEmpty()) throw QueueUnderflowException()
        val oldVal = elements[front]
        elements[front] = null
        if (front == rear) {
            front = -1
            rear = -1
        } else front = (front + 1) % capacity
        return oldVal as E
    }

    fun front() = try {
        elements[front] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
    }

    fun rear() = try {
        elements[rear] as E
    } catch (e: IndexOutOfBoundsException) {
        throw QueueUnderflowException();
    }

    fun isEmpty() = front == -1

    fun isFull() = (rear + 1) % capacity == front

    override fun toString(): String {
        return Arrays.toString(elements)
    }
}

class QueueUnderflowException : RuntimeException()

class QueueOverflowException : RuntimeException()

fun main() {
    val animals = CircularFixedQueue<String>(10)
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")

    animals.enqueue("Lion")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Tiger")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Crocodile")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Cat")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Dog")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Cow")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Cangaroo")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Rat")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Bull")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.enqueue("Ox")
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    try {
        animals.enqueue("Zebra")
    } catch(e: QueueOverflowException) {
        System.out.println("Exception Expected!!!")
    }
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    animals.dequeue()
    System.out.println("$animals -- Empty? - ${animals.isEmpty()} -- Full? - ${animals.isFull()}")
    try {
        animals.dequeue()
    } catch (e: QueueUnderflowException) {
        System.out.println("Exception Expected!!!")
    }
}
