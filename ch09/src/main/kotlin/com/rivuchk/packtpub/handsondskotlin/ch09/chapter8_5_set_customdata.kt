package com.rivuchk.packtpub.handsondskotlin.ch09

data class MyDataClass (val someNumericValue:Int, val someStringValue:String)
class MyCustomClass (val someNumericValue:Int, val someStringValue:String) {
    override fun toString(): String {
        return "MyCustomClass(someNumericValue=$someNumericValue, someStringValue=$someStringValue)"
    }

    override fun hashCode() = someStringValue.hashCode()+someNumericValue.hashCode()

    override fun equals(other: Any?): Boolean {
        return other is MyCustomClass && other.someNumericValue == someNumericValue && other.someStringValue==someStringValue
    }
}

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

    val customClassSet = setOf(
            MyCustomClass(1, "1st obj"),
            MyCustomClass(2, "2nd obj"),
            MyCustomClass(3, "3rd obj"),
            MyCustomClass(2, "2nd obj"),
            MyCustomClass(4, "4th obj"),
            MyCustomClass(5, "5th obj"),
            MyCustomClass(5, "5th obj"),
            MyCustomClass(3, "3rd obj")
    )

    println("Printing items of customClassSet one by one ${MyCustomClass(2, "2nd obj").equals(MyCustomClass(2, "2nd obj"))}")
    for(item in customClassSet) {
        println(item)
    }
}