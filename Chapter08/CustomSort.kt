import kotlin.Comparator

data class Employee(
        val employeeID: Int,
        val employeeName: String
)

fun main(args: Array<String>) {
    val employeeList = listOf(
            Employee(2, "Chandra Sekhar Nayak"),
            Employee(1, "Rivu Chakraborty"),
            Employee(4, "Indranil Dutta"),
            Employee(3, "Sonkho Deep Mondal"),
            Employee(6, "Debraj Dey"),
            Employee(5, "Koushik Mridha")
    )

    val sortedEmployeesList = employeeList.sortedWith(Comparator { e1, e2 ->
        when {
            e1?.employeeID ?: 0 <= e2?.employeeID ?: 0 -> -1
            e1?.employeeID ?: 0 == e2?.employeeID ?: 0 -> 0
            else -> 1
        }
    })

    for (employee in sortedEmployeesList) {
        println(employee)
    }
}
