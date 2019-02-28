import java.util.*

class IntMap<V> constructor(capacity: Int = 10) {

    private var hashes: IntArray
    private var array: Array<Any?>

    var size = 0
        private set

    init {
        hashes = IntArray(if (capacity < 0) 0 else capacity)
        array = arrayOfNulls(if (capacity < 0) 0 else capacity)
    }

    fun isEmpty() = size <= 0

    operator fun get(key: Int) = get(key, null)

    fun get(key: Int, valueIfKeyNotFound: V?): V? {
        val index = Arrays.binarySearch(hashes, 0, size, key)
        return if (index < 0) valueIfKeyNotFound else array[index] as V
    }

    fun delete(key: Int) {
        val index = Arrays.binarySearch(hashes, 0, size, key)
        if (index >= 0) removeAt(index)
    }

    fun removeAt(index: Int) {
        System.arraycopy(hashes, index + 1, hashes, index, size - (index + 1))
        System.arraycopy(array, index + 1, array, index, size - (index + 1));
        size--
    }

    fun put(key: Int, value: V) {
        var index = Arrays.binarySearch(hashes, 0, size, key)
        if (index >= 0) array[index] = value
        else {
            index = index.inv()
            if (size >= hashes.size) {
                val newSize = if (size < 4) 4 else size + (size shr 1)
                val tempHashes = hashes
                val tempArray = array
                allocArrays(newSize)

                System.arraycopy(tempHashes, 0, hashes, 0, tempHashes.size)
                System.arraycopy(tempArray, 0, array, 0, tempArray.size)
            }

            if (index < size) {
                System.arraycopy(hashes, index, hashes, index + 1, size - index)
                System.arraycopy(array, index, array, index + 1, size - index)
            }

            hashes[index] = key
            array[index] = value
            size++
        }
    }

    fun indexOfKey(key: Int): Int {
        return Arrays.binarySearch(hashes, 0, size, key)
    }

    fun containsKey(key: Int) = indexOfKey(key) >= 0

    fun keyAt(index: Int) = hashes[index]

    fun valueAt(index: Int) = array[index] as V

    fun setValueAt(index: Int, value: V) {
        array[index] = value
    }

    private fun allocArrays(size: Int) {
        hashes = IntArray(size)
        array = arrayOfNulls(size)
    }
}

fun main(args: Array<String>) {
    val map = IntMap<String>()
    map.put(1, "Apple")
    map.put(2, "Banana")
    map.put(3, "Cucumber")

    // Testing get
    println(map.get(1))
    println(map.get(2))
    println(map.get(3))
    println(map.get(4))

    // Testing indexOfKey
    println("Index Of Key - ${map.indexOfKey(1)}")
    println("Index Of Key - ${map.indexOfKey(2)}")
    println("Index Of Key - ${map.indexOfKey(3)}")
    println("Index Of Key - ${map.indexOfKey(4)}")

    // Testing containsKey
    println("Contains Key - ${map.containsKey(1)}")
    println("Contains Key - ${map.containsKey(2)}")
    println("Contains Key - ${map.containsKey(3)}")
    println("Contains Key - ${map.containsKey(0)}")

    // Testing valueAt
    println("Value At - ${map.valueAt(0)}")
    println("Value At - ${map.valueAt(1)}")
    println("Value At - ${map.valueAt(2)}")
    println("Value At - ${map.valueAt(3)}")
    try {
        println("Value At - ${map.valueAt(8)}")
    } catch(e: ArrayIndexOutOfBoundsException) {
        e.printStackTrace()
    }
    try {
        println("Value At - ${map.valueAt(-2)}")
    } catch(e: ArrayIndexOutOfBoundsException) {
        e.printStackTrace()
    }

    // Testing keyAt
    println("Key At - ${map.keyAt(0)}")
    println("Key At - ${map.keyAt(1)}")
    println("Key At - ${map.keyAt(2)}")
    println("Key At - ${map.keyAt(3)}")

    // Testing setValueAt
    map.setValueAt(1, "Beet")
    println(map.get(1))
    println(map.get(2))
    println(map.get(3))
    println(map.get(4))

    // Testing delete
    println(map.delete(2))
    println(map.get(1))
    println(map.get(2))
    println(map.get(3))
    println(map.get(4))
    map.put(2, "Banana")
    println(map.get(1))
    println(map.get(2))
    println(map.get(3))
    println(map.get(4))

    // Testing isEmpty
    println(map.isEmpty())
    map.delete(1)
    map.delete(2)
    map.delete(3)
    println(map.isEmpty())
}
