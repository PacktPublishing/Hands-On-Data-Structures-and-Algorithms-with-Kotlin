fun main() {
    val list = IntArray(100) { it -> it * 10 }

    println("list.take(10) -> ${list.take(10)}")                                            //(1)
    println("list.takeLast(10) -> ${list.takeLast(10)}")                                    //(2)
    println("list.takeWhile { it <= 50 } -> ${list.takeWhile { it <= 50 }}")                //(3)
    println("list.takeLastWhile { it >= 900 } -> ${list.takeLastWhile { it >= 900 }}")      //(4)
}
