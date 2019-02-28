import java.util.*
import kotlin.math.*

class HashMap<K, V> {

    private val minCapacity = 1 shl 4
    private val maxCapacity = 1 shl 30
    private val loadFactor = 0.75f

    private var table: Array<Node<K, V>?>
    var size = 0
        private set

    constructor() {
        this.table = arrayOfNulls(minCapacity)
    }

    constructor(capacity: Int) {
        if (capacity < 0) throw IllegalArgumentException("Invalid Capacity: $capacity")
        val finalCapacity = when {
            capacity < minCapacity -> minCapacity
            capacity > maxCapacity -> maxCapacity
            else -> fetchNearestCapacity(capacity)
        }
        this.table = arrayOfNulls(finalCapacity)
    }

    constructor(map: Map<K, V>) {
        val size = map.size
        val newSize = when {
            size < minCapacity -> minCapacity
            else -> fetchNearestCapacity(size)
        }
        this.table = arrayOfNulls(newSize)
        if (size > 0) {
            for (entry in map) {
                putVal(entry.key, entry.value)
            }
        }
    }

    private fun hash(key: K): Int {
        val h = key?.hashCode() ?: 0
        return h xor (h ushr 16)
    }

    fun isEmpty() = size == 0

    fun get(key: K): V? {
        val e = getNode(hash(key), key)
        return if (e == null) null else e.value
    }

    fun getOrDefault(key: K, defaultVal: V): V? {
        val e = getNode(hash(key), key)
        return if (e == null) defaultVal else e.value
    }

    private fun getNode(hash: Int, key: K): Node<K, V>? {
        val n = table.size
        if (n > 0) {
            val first = table[(n - 1) and hash]
            if (first != null) {
                if (first.hash == hash) { // Checking the 1st node
                    val k = first.key
                    if (k === key || k == key) return first
                }
                var e = first.next ?: return null
                do {
                    if (e.hash == hash && e.key === key || e.key == key) return e
                } while (e.next != null)
            }
        }
        return null
    }

    fun containsKey(key: K) = getNode(hash(key), key) != null

    fun containsValue(value: V): Boolean {
        if (size > 0) {
            for (index in table.indices) {
                var e = table[index]
                while (e != null) {
                    if (value === e.value || value == e.value) return true
                    e = e.next
                }
            }
        }
        return false
    }

    fun put(key: K, value: V) {
        putVal(key, value)
    }

    fun putIfAbsent(key: K, value: V) {
        putVal(key, value, true)
    }

    fun replace(key: K, value: V) {
        val e = getNode(hash(key), key)
        if (e != null) e.value = value
    }

    private fun putVal(key: K, value: V, onlyIfAbsent: Boolean = false) {
        val hash = hash(key)
        val n = table.size
        val index = (n - 1) and hash
        var first = table[index]
        if (first == null) {
            table[index] = Node(hash, key, value, null)
            ++size
        } else {
            var node: Node<K, V>?
            var k = first.key
            if (first.hash == hash && (k === key || k == key) && !onlyIfAbsent) first.value = value
            else {
                while(true) {
                    node = first!!.next
                    if (node == null) {
                        first.next = Node(hash, key, value, null)
                        break
                    }
                    k = node.key
                    if (node.hash == hash
                     && (k === key || k == key)
                      && !onlyIfAbsent) {
                        node.value = value
                        break
                    }
                    first = node
                }
            }
        }
    }

    fun remove(key: K): V? {
        val hash = hash(key)
        val n = table.size
        val index = (n - 1) and hash
        var first = table[index]
        if (n > 0 && first != null) {
            var node: Node<K, V>? = null
            var k = first.key
            if (first.hash == hash && (key === k || key == k)) node = first
            else {
                var nextNode = first.next
                if (nextNode != null) {
                    do {
                        k = nextNode!!.key
                        if (nextNode.hash == hash && (key === k || key == k)) {
                            node = nextNode
                            break
                        }
                        first = nextNode
                        nextNode = nextNode.next
                    } while(nextNode != null)
                }
            }
            if (node != null) {
                if (node == first) table[index] = node.next
                else first!!.next = node.next
                --size
                return node.value
            }
        }
        return null
    }

    fun clear() {
        if (size > 0) {
            size = 0
            table.fill(null)
        }
    }

    private class Node<K, V>(
        val hash: Int,
        val key: K,
        var value: V,
        var next: Node<K, V>?) {

        override fun toString() = "$key=$value"

        override fun hashCode() = (key?.hashCode() ?: 0).xor(value?.hashCode() ?: 0)

        override fun equals(other: Any?): Boolean {
            if (other === this) return true
            if (other is Node<*, *> && this.key == other.key && this.value == other.value) return true
            return false
        }
    }

    private fun fetchNearestCapacity(i: Int): Int {
        var retVal = i - 1 // If input is a power of two, shift its high-order bit right.

        // "Smear" the high-order bit all the way to the right.
        retVal = retVal or retVal ushr 1
        retVal = retVal or retVal ushr 2
        retVal = retVal or retVal ushr 4
        retVal = retVal or retVal ushr 8
        retVal = retVal or retVal ushr 16

        return retVal + 1
    }
}

fun main(args: Array<String>) {
    val map = HashMap<String, String>()
    println(map.get("Test"))
    map.put("Test", "Testing")
    println(map.get("Test"))
    println(map.get("Testing"))
    println(map.size)

    map.put("Testing", "Test")
    println(map.get("Testing"))
    println(map.get("Test"))
    println(map.get("test"))

    println("After Removing Xyz")
    map.remove("Xyz")
    println(map.get("Test"))
    println(map.get("Testing"))

    println("After Removing Test")
    map.remove("Test")
    println(map.get("Test"))
    println(map.get("Testing"))


    println("Testing Put operation")
    val languages = HashMap<String, String>()
    languages.put("K", "Kotlin")
    languages.put("J", "Java")
    languages.put("C", "C++")
    println("Getting C - ${languages.get("C")}")
    languages.put("C", "C#")
    println("Getting C After replacement - ${languages.get("C")}")
    languages.putIfAbsent("C", "C++")
    println("Getting C After replacement - ${languages.get("C")}")

    println()
    println("Testing constructor with Map Argument")
    val fruits = hashMapOf("A" to "Apple", "B" to "Banana", "C" to "Cherries")
    val moreFruites = HashMap<String, String>(fruits)
    moreFruites.put("D", "Dates")
    println(moreFruites.get("A"))
    println(moreFruites.get("D"))
    println(moreFruites.get("M"))
    moreFruites.put("M", "Mango")
    println(moreFruites.get("M"))
    moreFruites.put("A", "Apricot")
    println(moreFruites.get("A"))
}
