/*
* An example for inheritance and composition.
* */
// 3
abstract class Human(val name: String, val age: Int)

// 1 - 2
class Dev(name: String, age: Int, val job: String) : Human(name, age) {
    override fun toString(): String {
        return "$name - $job"
    }
}

// 4 - 5
interface Being {
    val name: String
    val age: Int
    fun name(): String
}

interface Developing {
    val job: String
}

class IBeing(override val name: String, override val age: Int) : Being {
    override fun name(): String {
        return name
    }
}

class IDeveloping(override val job: String) : Developing {

}

// 6
class DevCompos(being: Being, developing: Developing) :
    Being by being, Developing by developing {
    fun print() {
        println("$job - $name")
    }
}

fun main() {
    val dev = Dev("Mahdi", 18, "Mobile Developer")
    println("---> Dev is a child of Human = ${dev is Human}")

    // 7
    val devC = DevCompos(IBeing("Mahdi", 18), IDeveloping("Mobile"))
    devC.print()
}