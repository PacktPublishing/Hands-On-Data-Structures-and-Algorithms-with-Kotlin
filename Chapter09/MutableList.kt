fun main(args: Array<String>) {
    val list = mutableListOf(1, 2, 5)

    println("-----Created With Items-----")
    for (i in list) {
        println("list item $i")
    }

    // Adding Items

    list.add(6)     //(1)
    list.add(2, 3)  //(2)
    list.add(3, 4)  //(3)


    println("-----After Adding Items-----")
    for (i in list) {
        println("list item $i")
    }
}
