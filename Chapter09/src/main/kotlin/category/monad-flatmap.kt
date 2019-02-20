package category

import arrow.core.None
import arrow.core.Option
import arrow.core.Some

fun main() {
    var someValue: Option<Int> = Some(10)
    println(someValue.flatMap { Some(it + 5) })
}