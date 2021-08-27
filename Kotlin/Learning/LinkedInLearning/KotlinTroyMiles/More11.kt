/*
* This is an example for lambdas and closures.
* */
fun main() {
    // Lambdas examples.
    val devs = Developer11.sampleList()
    val seniorDevs = devs.filter { dev -> dev.age > 30 }
    println("---> Senior Devs = $seniorDevs")
    val langDevs = devs.map { it.language }.toSet()
    println("---> Languages they are using = $langDevs")
    val oldestDev = devs.maxByOrNull { it.age }
    println("---> Oldest dev is = $oldestDev")
    /*------------------------------------------------*/
    // Closures example.
    val closure1 = closureExample()
    val closure2 = closureExample()
    closure1("One")
    closure1("One")
    closure1("One")
    closure1("One")
    closure1("One")
    closure2("Two")
    closure2("Two")
    closure2("Two")
    closure1("One")
}

data class Developer11(
    val name: String,
    val age: Int,
    val language: String
) {
    override fun toString(): String {
        return "Name = $name / Age = $age / Language = $language"
    }

    companion object Creator {
        fun sampleList(): List<Developer11> {
            return listOf(
                Developer11("Mahdi", 18, "Java"),
                Developer11("Nathan", 23, "C++"),
                Developer11("Ellie", 16, "Kotlin"),
                Developer11("Bob", 32, "Python"),
                Developer11("Sully", 56, "Python"),
                Developer11("Cristian", 35, "Java"),
                Developer11("Sarah", 27, "JavaScript"),
            )
        }
    }
}

// It returns a function that returns void(Unit in Kotlin)
fun closureExample(): (name: String) -> Unit {
    var x = 0
    return { s -> println("$s -> ${x++}") }
}