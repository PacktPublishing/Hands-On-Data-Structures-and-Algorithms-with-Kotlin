package category

import arrow.core.*


fun main() {
    val name: Option<String> = Some("Rivu")
    val company: Option<String> = Some("BYJUS")
    val city: Option<String> = Some("Bangalore")

    val authorInfo: Option<Tuple3<String, String, String>> =
        applicative<String, String, String, Tuple3<String, String, String>>(name, company, city) { a, b, c ->
            Tuple3(a, b, c)
        }
    println("Author: $authorInfo")

}

fun <A, B, C, R> applicative(
    optiona: Option<A>,
    optionb: Option<B>,
    optionc: Option<C>,
    block: (A, B, C) -> R
): Option<R> {
    return Some(block(optiona.getOrElse { None as A },
        optionb.getOrElse { None as B },
        optionc.getOrElse { None as C }
    ))
}