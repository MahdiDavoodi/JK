/*
* This is an example of operator overloading.
* */
fun main() {
    val mahdi = Employee06("Mahdi", 80000)
    val nathan = Employee06("Nathan", 60000)
    val group = mahdi + nathan

    println(mahdi)
    println(nathan)
    println("---> Group = $group")
}

data class Employee06(val name: String, val salary: Int) {
    // Overloading the plus operator.
    infix operator fun plus(next: Employee06): Employee06 {
        return Employee06(
            "$name, ${next.name}",
            salary + next.salary
        )
    }

    override fun toString(): String {
        return "---> $name -> $salary$"
    }
}