package chapter2

/*
* In this session we want to get familiar with Kotlin numeric variables.
* */
fun main() {
    val totalGrade: Byte = 120
    val numLessons: Short = 6
    val average = totalGrade / numLessons

    println("---> The average grade is: $average")

    var phonePrice = 1235.56F
    println("---> Phone A has a price of: $phonePrice")

    phonePrice = 3425.8F
    println("---> Phone B has a price of: $phonePrice")
}