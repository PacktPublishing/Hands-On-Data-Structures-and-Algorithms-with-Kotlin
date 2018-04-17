private fun find(input: IntArray, item: Int) {
   for (i in input.indices) {
       if (input[i] == item) {
           print("Item found at index - $i")
       }
   }
}

fun main(args: Array<String>) {
    find(intArrayOf(32, 34, 45, 87, 343, 5667, 98, 67, 32, 543, 1), 67)
}
