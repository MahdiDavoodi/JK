/*
* In this exercise we take a look at:
* when expressions and examples,
* Enum classes!(More later!)
* */

enum class Android {
    Java, Kotlin
}

fun main() {
    val beProgrammer = 1
    val age = 18
    val name = "Mahdi"
    val currentSkill = Android.Kotlin

    //simple usage of "when" expression that does an action
    //As you can see, you can set multiple condition for a line.
    //In "when", just one line will execute!
    when (beProgrammer) {
        1 -> println("---> I will be a good programmer.")
        2, 3 -> println("---> I won't be a programmer.")
    }

    //"when" supports ranges with "in". Also, it has "else" for other conditions.
    val yourAge = when (age) {
        in 0..12 -> "Child"
        in 13..19 -> "Teenager"
        in 20..65 -> "Adult"
        else -> "Senior"
    }
    println("---> You are a $yourAge.")

    //It can get and return any type!
    val lastName = when (name) {
        "Mahdi" -> "Kotlin"
        "Karim" -> "Koltin"
        else -> "Android"
    }

    println("---> $name $lastName.")

    when (currentSkill) {
        Android.Java -> println("---> Learned before!")
        Android.Kotlin -> println("---> Learning...")
    }
}