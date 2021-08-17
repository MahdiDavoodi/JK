/*
* This is an example for Kotlin classes part 1.
* */

// 1
class One {}

// 2
class Two

// 3
private class Three {}

// 4
class Four constructor(name: String, age: Int) {}

class Five(age: Int) {}

class Six internal constructor(name: String) {}

// 5
class Seven(name: String) {
    val hello = "Hello $name"
}

class Eight(val name: String) {}

// 6
class Student(val name: String, val age: Int) {
    var grade = 0
        get() {
            return if (field < 10) 10 else field
        }

    override fun toString(): String {
        return "$name - $grade"
    }

}

fun main() {
    val seven = Seven("Mahdi")
    println(seven.hello)

    val eight = Eight("John")
    println(eight.name)

    val student = Student("Mahdi", 18)
    student.grade = 5
    println(student.grade)
    println(student)
}