import java.util.Arrays

data class User(val firstName: String,
               val lastName: String,
               val phone: String,
               val email: String)

fun main(args: Array<String>) {
    val friends = arrayOf("Rivu", "Subin", "Sid", "Susri", "Ramya", "Sachin")
    println("My friends are - ${Arrays.toString(friends)}")

    // String Array
    val languages = arrayOf("Kotlin", "Java", "C", "C++", "C#", "JavaScript", "Python")
    println("Some of the top programming languages around the world are : ${Arrays.toString(languages)}")

    // int Array
    val oddNums = intArrayOf(1, 3, 5, 7, 9)
    println("1st five odd numbers are : ${Arrays.toString(oddNums)}")

    // Integer Array (Wrapper Objects)
    val oddWrapperNums = arrayOf(1, 3, 5, 7, 9)
    println("1st five odd numbers in wrapped object form are : ${Arrays.toString(oddWrapperNums)}")

    // Array of Any
    val sachin = arrayOf("Sachin", 29, "sachin@xyz.com", "A", 5.4)
    println("Details of Sachin : ${Arrays.toString(sachin)}")

    // Array of User
    val users = arrayOf(User("Chandra Sekhar", "Nayak", "0909090909", "chansek@live.com"),
                        User("Utkarsh", "Asthana", "1234123412", "utku@xyz.com"),
                        User("Sachin", "Kamble", "7878787878", "sachin@abc.com"),
                        User("Ramya", "K", "0000000000", "ramu@zzz.com"),
                        User("Subin", "S", "1234512345", "sub@s.com"))
    println("Users are : ${Arrays.toString(users)}")
}
