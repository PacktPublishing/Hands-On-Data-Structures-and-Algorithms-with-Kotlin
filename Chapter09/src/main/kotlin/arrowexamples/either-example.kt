package arrowexamples

import arrow.core.*
import java.lang.Exception

fun main() {
    printResponse(fetchAPIData(Some(10)))
    printResponse(fetchAPIData(None))

}

fun fetchAPIData(someParameter: Option<Int>) : Either<Exception, String> {
    if(someParameter is None) {
        return Either.left(Exception("No value passed"))
    } else {
        return Either.right("The value is ${someParameter.getOrElse { 0 }}")
    }
    listOf<String>().size
}

fun printResponse(response : Either<Exception, String>) {
    println(if(response.isRight()) "Success $response" else "Failure $response")
}