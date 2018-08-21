import java.util.*
import kotlin.math.*

class ArrayMap<K, V> constructor(capacity: Int = 0) {

    private val minCapacity = 4
    private lateinit var hashes: IntArray
    private lateinit var array: Array<Any?>

    var size = 0
        private set

    init {
        if(capacity <= 0) {
            hashes = IntArray(0)
            array = arrayOf()
        } else allocArrays(capacity)
    }

    fun isEmpty() = size <= 0

    operator fun get(key: K): V? {
        val index = indexOfKey(key)
        return if (index >= 0) array[(index shl 1) + 1] as V? else null
    }

    fun indexOfKey(key: K): Int {
        return if (key == null) indexOfNull() else indexOf(key)
    }

    fun containsKey(key: K) = indexOfKey(key) >= 0

    fun keyAt(index: Int) = array[index shl 1] as K

    fun valueAt(index: Int) = array[(index shl 1) + 1] as V

    fun setValueAt(index: Int, value: V): V? {
        var index = index
        index = (index shl 1) + 1
        val old = array[index] as V
        array[index] = value
        return old
    }

    fun put(key: K, value: V): V? {
        
    }

    private fun indexOf(key: K): Int {
        val hash = key!!.hashCode()

        if (size == 0) return 0.inv()
        val index = Arrays.binarySearch(hashes, hash)

        // Key not found, return -ve value
        if (index < 0) return index

        if (key == array[index shl 1]) return index

        // Search for a matching key after the index.
        var end = index + 1
        while (end < size && hashes[end] == hash) {
            if (key == array[end shl 1]) return end
            end++
        }

        // Search for a matching key before the index.
        var i = index - 1
        while (i >= 0 && hashes[i] == hash) {
            if (key == array[i shl 1]) return i
            i--
        }
        return end.inv()
    }

    private fun indexOfNull(): Int {
        if (size == 0) return 0.inv()
        val index = Arrays.binarySearch(hashes, 0)

        // Key not found, return -ve value
        if (index < 0) return index

        if (null == array[index shl 1]) return index

        // Search for a matching key after the index.
        var end = index + 1
        while (end < size && hashes[end] == 0) {
            if (null == array[end shl 1]) return end
            end++
        }

        // Search for a matching key before the index.
        var i = index - 1
        while (i >= 0 && hashes[i] == 0) {
            if (null == array[i shl 1]) return i
            i--
        }
        return end.inv()
    }

    private fun allocArrays(capacity: Int) {
        hashes = IntArray(capacity)
        array = arrayOfNulls(capacity shl 1)   // capacity * 2
    }    
}

fun main(args: Array<String>) {
    
}
