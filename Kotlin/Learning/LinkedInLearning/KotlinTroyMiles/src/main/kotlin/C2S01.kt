/*
* In this example, we take a look at numeric data types in Kotlin.
* */
fun main() {
    val number = 123
    var longNumber = 12_345_654L

    println("---> The number is : $number")
    println("---> The Long number is: $longNumber")

    longNumber = 12_342_442L
    println("---> Ow sorry! The long number is: $longNumber")

    val shortNumber: Short = 2
    val byteNumber: Byte = 28

    val floatNumber = 123.5F

    val floatToInt = floatNumber.toInt()

    println("$shortNumber -- $byteNumber -- $floatToInt")
}