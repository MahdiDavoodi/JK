/*
* This is about companion object in Kotlin.
*  */

class Test private constructor(val name: String, val age: Int) {
    fun printName() {
        println("---> Name: $name - $age")
    }

    companion object Comp {
        const val language = "Kotlin"
        fun factory(name: String, age: Int): Test {
            return Test(name, age)
        }

        fun printThis(self: Test) {
            self.printName()
        }
    }
}

fun main() {
    // We can't use val test1 = Test("Mahdi",18). We want to use factory method.
    val test1 = Test.factory("Mahdi", 18)
    Test.printThis(test1)
    println(Test.language)
}