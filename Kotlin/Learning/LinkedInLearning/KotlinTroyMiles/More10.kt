/*
* This is an example for destructuring.
* */
fun main() {
    val developer = Developer10("Mahdi", 18)
    // Pulls out parameters in order.
    val (name, age) = developer
    println("Developer ---> $name - $age")
    println(developer.component1())

    val writer = Writer10("Nathan", 5)
    val (writerName, books) = writer
    println("Writer ---> $writerName - $books")
}

// Data class does not need any implementation at all.
data class Developer10(
    val name: String,
    val age: Int
)

// A normal class needs an implementation.
class Writer10(private val name: String, private val books: Int) {
    operator fun component1(): String = name
    operator fun component2(): Int = books
}