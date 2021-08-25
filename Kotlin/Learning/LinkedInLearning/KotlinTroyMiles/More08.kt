import kotlin.reflect.full.memberProperties

/*
* This is an example for simple usage of reflection in Kotlin.
* */
fun main() {
    val sea = Book08("Sea", "Mahdi")
    val ref = sea.javaClass.kotlin
    println("---> Sea class name = ${ref.simpleName}")

    for (info in ref.memberProperties)
        println(info.name)
}

data class Book08(val name: String, val writer: String)