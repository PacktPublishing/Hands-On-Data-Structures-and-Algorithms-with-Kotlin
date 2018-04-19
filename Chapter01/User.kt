data class User(val firstName: String,
               val lastName: String,
               val phone: String,
               val email: String)

fun main(args: Array<String>) {
    val user = User("Chandra", "Sekhar", "123456789", "chansek@live.com")
    println("User : $user")
}
