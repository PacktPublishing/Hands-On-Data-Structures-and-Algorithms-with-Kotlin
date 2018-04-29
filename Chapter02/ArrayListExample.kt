fun main(args: Array<String>) {
    val companies = arrayListOf<String>("Google", "Mocrosoft", "Facebook", "Apple", "JetBrains")
    println("Companies list - ${companies.toString()}")

    companies.add("Amazon")
    companies.add("Samsung")
    println("Companies list - ${companies.toString()}")

    companies.set(2, "Twitter")
    println("Companies list - ${companies.toString()}")

    companies.remove("Samsung")
    companies.removeAt(2)
    println("Companies list - ${companies.toString()}")
}
