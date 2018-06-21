import java.util.*
import kotlin.math.*

class HashMap<K, V> {

    private val minCapacity = 4
    private val maxCapacity = 1 shl 30

    private var table: Array<Node<K, V>?>

    constructor() {
        this.table = arrayOfNulls(minCapacity)
    }

    constructor(capacity: Int) {
        val finalCapacity: Int
        if (capacity < 0) throw IllegalArgumentException("Invalid Capacity: " + capacity);
        if (capacity < minCapacity) finalCapacity = minCapacity
        else if (capacity > maxCapacity) finalCapacity = maxCapacity
        else finalCapacity = fetchNearestCapacity(capacity)
        this.table = makeTable(finalCapacity)
    }

    private fun makeTable(capacity: Int): Array<Node<K, V>?> {
        return arrayOfNulls(capacity)
    }

    class Node<K, V>(
        val hash: Int,
        val key: K,
        var value: V,
        var next: Node<K, V>) {

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
