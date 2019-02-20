package category

import arrow.*
import arrow.core.*


fun main() {
    var optionalVal: Option<Int>
    optionalVal = Some(10)
    println(optionalVal.map { it+1 })//1
    println(optionalVal.map { Some(it+1) })//2
}