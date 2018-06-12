import java.util.*
import kotlin.math.*

class HashMap<K, V> {
    class Node<K, V>(
        val hash: Int,
        val key: K,
        var value: V,
        var next: Node<K, V>) {

        override fun toString() = "$key=$value"

        override fun hashCode() = (key?.hashCode() ?: 0).toDouble().pow(value?.hashCode() ?: 0).toInt()

        override fun equals(other: Any?): Boolean {
            if (other === this) return true
            if (other is Node<*, *> && this.key == other.key && this.value == other.value) return true
            return false
        } 
    }
}
