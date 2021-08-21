/*
* This is an example for Kotlin objects.
* */
data class Developer(val name: String)

fun main() {
    // 1
    val companyDevs = object {
        val mainDev = Developer("Mahdi")
        var secondDev = Developer("Nathan")

        fun printNames() {
            println("${mainDev.name} - ${secondDev.name}")
        }
    }

    companyDevs.secondDev = Developer("Ellie")
    println(companyDevs.mainDev)
    companyDevs.printNames()

    println(Test.list[8])
}

// 2
object Test {
    val list = listOf(10, 20, 30, 40, 50, 60, 70, 80, 90)
}