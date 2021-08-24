import java.util.*

/*
* This is a challenge by Troy Miles in his Kotlin for Java Devs course.
* */
fun main() {
    println("---> Please input the values like A|B:")
    print("^ ")
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().trim().split("|")
    println(
        "---> The smaller one is: ${
            smaller(
                input[0],
                input[1]
            )
        }"
    )
}

// We have to check if they have compareTo method or not.
// The string compareTo does not compare length.
fun <V : Comparable<V>> smaller(A: V, B: V): V {
    if (A is String && B is String)
        return if (A.length > B.length) B
        else A
    return if (A > B)
        B
    else A
}