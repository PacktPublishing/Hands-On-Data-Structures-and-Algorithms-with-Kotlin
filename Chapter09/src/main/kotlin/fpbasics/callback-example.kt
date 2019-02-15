package fpbasics

interface ACallBack {
    fun someCallBackFunction()
}

fun listenToSomeEvent(callback: ACallBack) {
    // Event occurred
    callback.someCallBackFunction()
}

fun listenToSomeEvent(lambda: () -> Unit) {
    // Event Occurred
    lambda()
}

fun main() {
    // Using callback
    listenToSomeEvent(object : ACallBack {
        override fun someCallBackFunction() {
            println("Event occurred")
        }
    })

    // Using Lambda
    listenToSomeEvent {
        println("Event occurred")
    }
}