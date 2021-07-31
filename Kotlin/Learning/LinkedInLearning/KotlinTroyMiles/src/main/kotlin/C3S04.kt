/*
* In this example I want to take a look to Loops in Kotlin.
* For.
* While.
* Do-While.
* */
fun main() {

    //Simple for that works on collections and...
    for (n in 0..10)
        print("$n ")
    println()

    //You can create a list by "listOf()"
    val artists = listOf("Halsey", "Twenty One Pilots", "Dean Lewis", "PVRIS")

    //You can get the index like this:
    for ((index, artist) in artists.withIndex())
        println("${index + 1}. $artist")

    //You can use while with an ending condition.
    //Also, you can use break for end the loops And continue for skip rest of index.
    //The next while prints odd number below 10
    var z = 10
    while (z > 0) {
        if (z % 2 == 0) {
            z--
            continue
        }
        println(z)
        z--
    }

    //You can use do-while to first, do an action and then check the condition.
    //Next while print just one "Hello World"
    val boolean = false
    do {
        println("---> Hello World!")
    } while (boolean)
}