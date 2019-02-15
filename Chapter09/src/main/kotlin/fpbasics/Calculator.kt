package fpbasics

class Calculator {
    var anyVariable: Int = 0

    fun add(a: Int, b: Int): Int = a + b         // pure function
    fun multiply(a: Int, b: Int): Int = a * b    // pure function
    fun subtract(a: Int, b: Int): Int = a - b    // pure function
    fun divide(a: Int, b: Int): Int = a / b      // pure function

    fun anyFunction(x: Int): Int {               // not a pure function
        anyVariable = x + 2
        return anyVariable
    }
}