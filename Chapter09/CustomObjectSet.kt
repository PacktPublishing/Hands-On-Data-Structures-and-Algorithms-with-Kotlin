data class MyDataClass (val someNumericValue: Int, val someStringValue: String)

fun main(args: Array<String>) {
    val dataClassSet = setOf(
            MyDataClass(1, "1st obj"),
            MyDataClass(2, "2nd obj"),
            MyDataClass(3, "3rd obj"),
            MyDataClass(2, "2nd obj"),
            MyDataClass(4, "4th obj"),
            MyDataClass(5, "5th obj"),
            MyDataClass(2, "will be added"),
            MyDataClass(3, "3rd obj")
    )

    println("Printing items of dataClassSet one by one")
    for(item in dataClassSet) {
        println(item)
    }
}
