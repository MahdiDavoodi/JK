/*
* This is an example of using Java from Kotlin.
* */
fun main() {
    val javaDevs = listOf(
        JavaDeveloper("Mahdi", 18, "Java / Kotlin"),
        JavaDeveloper("Ellie", 28, "Java"),
        JavaDeveloper("Nathan", 16, "Java / Groovy")
    )
    for (dev in javaDevs)
        println(dev)
}