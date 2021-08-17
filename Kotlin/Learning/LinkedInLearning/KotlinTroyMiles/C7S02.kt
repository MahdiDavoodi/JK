/*
* This is an example for constructors and init blocks.
* Kotlin classes part 2.
* */

// 1 - Default parameter.
class Programmer(
    private val name: String,
    private val age: Int,
    private val nationality: String = "Canada"
) {
    var language = " "
    var area = " "

    // 3 - Simple example of init block.
    init {
        println("Creating the programmer! Please wait ...")
    }

    override fun toString(): String {
        return "$age years old $name from $nationality. $language - $area"
    }

    // 4 - Secondary constructors.
    constructor(
        name: String,
        age: Int,
        nationality: String = "Canada",
        language: String
    ) : this(name, age, nationality) {
        this.language = language
    }

    constructor(
        name: String,
        age: Int,
        nationality: String = "Canada",
        language: String,
        area: String = "Mobile"
    ) : this(name, age, nationality, language) {
        this.area = area
    }
}

fun main() {
    val programmer1 = Programmer("Nathan", 25)
    println(programmer1)

    val programmer2 = Programmer("Mahdi", 18, "Iran")
    println(programmer2)

    // 2 - Name parameters.
    val programmer3 = Programmer(age = 21, name = "Ellie")
    println(programmer3)

    val programmer4 = Programmer("Ali", 27, language = "C++", area = "Game")
    println(programmer4)

}