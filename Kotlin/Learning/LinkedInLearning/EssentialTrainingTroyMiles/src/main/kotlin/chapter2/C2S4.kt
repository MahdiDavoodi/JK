package chapter2

/*
* This is an example for understanding strings in Kotlin.
* */
fun main() {
    //Define a simple string.
    val string1 = "Hello Friend! This is Mahdi."
    println(string1)

    //Usage of $ and \
    val owe = 223_234
    val google = "Google"
    val string2 = "$google owes Oracle \$${owe - 23}\tdollars!"
    println(string2)

    val sampleString = "Hello Android. We are here. Now with Kotlin."
    //Size of string
    println("The size of sample string is ---> ${sampleString.length}")

    //Get characters with .get or []
    println("The fist char is ---> ${sampleString[0]}")

    //Get subsequence.
    println(sampleString.subSequence(6, 13))

    //MultiLine Text with """ TEXT """
    val string3 = """
        Hello World
        This is Mahdi speaking
        Be happy!
    """
    println(string3)

    //For loop on string
    for (letter in sampleString)
        print("$letter-")
    
}