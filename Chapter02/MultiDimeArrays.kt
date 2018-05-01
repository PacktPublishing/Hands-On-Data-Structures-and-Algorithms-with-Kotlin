import java.util.Arrays

fun main(args: Array<String>) {
    // Creating Multidimensional array
    val numbers = arrayOf(
            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6),
            arrayOf(7, 8, 9)
    )
    println(Arrays.deepToString(numbers))
    println("Type of the numbers array - $numbers")

    val food = arrayOf(
            arrayOf("Apple", "Apricot", "Avocado"),
            arrayOf("Banana", "Broccoli", "Beetroot"),
            arrayOf("Cherry", "Carrot")
    )
    println(Arrays.deepToString(food))
    println("Type of the food array - $numbers")

    // Accessing elements froma multidimensional array
    val row1 = food[0]
    val row2 = food[1]
    println("Foods starting with A : ${Arrays.toString(row1)}")
    println("Foods starting with B : ${Arrays.toString(row2)}")

    val firstFoodWithA = row1[0]
    val firstFoodWithB = row2[0]
    println("1st food starting with A : $firstFoodWithA")
    println("1st food starting with B : $firstFoodWithB")

    println("2nd food item which starts from B is : ${food[1][1]}")
    println("2nd food item which starts from C is : ${food[2][1]}")

    food[0] = arrayOf("Date", "Damson", "Durian")
    println("Updated array - ${Arrays.deepToString(food)}")

    food[2][1] = "Coconut"
    println("Updated array - ${Arrays.deepToString(food)}")

    for (row in food) {
        print("Item : ")
        for (item in row) {
            print("$item ")
        }
        println()
    }    
}
