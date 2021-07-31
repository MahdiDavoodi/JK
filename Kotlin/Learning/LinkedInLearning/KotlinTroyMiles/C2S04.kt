/*
* In this example I want to:
* See the usage of strings and their built-in functions,
* See the first loop in kotlin(But not dive in),
* And create a raw string!*/

fun main() {
    val string = "Hello Kotlin! You are good.\u2764"

    println("---> String: $string")

    //String size
    println("---> String length: ${string.length}")

    //Get a char or letter
    println("---> First letter is: ${string[0]}")

    //Get subString or subSequence
    println("---> Index 6 to 12 is: ${string.substring(6, 12)}")

    //Get every char(with for loop)
    for (letter in string)
        print("$letter - ")

    //Define raw string
    val text = """
       You can write a big text in between the triple "
       This is very cool!
    """

    println(text)
}