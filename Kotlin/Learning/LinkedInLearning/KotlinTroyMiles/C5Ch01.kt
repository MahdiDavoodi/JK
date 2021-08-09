import java.io.File

/*
* A simple challenge from Troy.
* I have to read some data from a file.
* I could write this better but hey, It works. 😅
* */
fun main() {
    val path = "/home/mahdi/Programming/IntelliJ/Kotlin/src/main/resources/sales.txt"
    val file = File(path)

    val list = mutableListOf<Double>()
    if (file.exists())
        file.forEachLine { x -> if (xIsNumber(x)) list.add(x.toDouble()) }

    println(list)
}

//Got help from my Java knowledge.
fun xIsNumber(input: String): Boolean {
    return try {
        val number = input.toDouble()
        true
    } catch (exception: NumberFormatException) {
        false
    }
}