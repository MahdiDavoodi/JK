/*
* This belongs to More05.java
* */
class KotlinDeveloper(var name: String, var age: Int, var language: String) {
    init {
        println("You created a new Kotlin developer!")
    }

    override fun toString(): String {
        return "$name - $age. Codes with $language"
    }
}