/*
* Challenge is to find the shortest name in a list.
* */
fun main() {
    val students = listOf(
        Student("Mahdi"),
        Student("Nathan"),
        Student("Joe"),
        Student("Avy")
    ).map { it.name }
    val shortestLength = students.map { it.length }
        .minByOrNull { it } ?: 0

    val output = students.filter { it.length == shortestLength }
    println("---> Short names: $output")
}

data class Student(val name: String)