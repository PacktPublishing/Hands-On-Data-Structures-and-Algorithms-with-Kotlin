### 1. Create a list of users and sort them
The below snipet is a data class to hold user information
```
data class User (
    val id: Int,
    val name: String,
    val dob: String
)
```
#### a. By ID
The below snipet shows you how to sort list of users by ID
```
val list: List<User> = getDataIntoTheList()
list.sortedBy { it.id }
```

#### b. By Name
The below snipet shows you how to sort list of users by Name
```
val list: List<User> = getDataIntoTheList()
list.sortedBy { it.name }
```

#### c. By DOB
The below snipet shows you how to sort list of users by DOB (Considering it is in yyyy-mm-dd format)
```
val list: List<User> = getDataIntoTheList()
list.sortedBy { it.dob }
```
### 2. Create a list of employees and filter out those whose salary is less than $800.
Below is the code snipet which filters out employees with salaries below $800 and will return only those employees with a higher salary.
```
data class Employee (
    val id: Int,
    val name: String,
    val salary: Int
)
```
```
val list<Employee> = getDataIntoTheList()
list.filter { 
    it.salary>800 
}
```
### 3. Let's assume a queue is there to buy movie tickets. Write a snippet that gives a ticket until the theater is house full. Assume the theatre has 200 seats.
Please refer to the directory Answer3 for this question.

### 4. Create a list of only prime numbers between 1 to 100.
```
val Int.isPrime: Boolean
    get() {
        for (i in 2..this/2) {
            if(this%i == 0) return false
        }
        return true
    }
```
```
(1..100).filter { it.isPrime }
```




