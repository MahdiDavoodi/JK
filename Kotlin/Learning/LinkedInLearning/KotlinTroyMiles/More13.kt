import arrow.core.*

/*
* This is an example for Funktionale library.(Arrow)
* */
fun main() {
    // 1 -> Composition.
    val add10 = { x: Int -> x + 10 }
    val divideBy2 = { x: Int -> x / 2 }
    val add10AndDivideBy2 = divideBy2 compose add10
    println("---> (10 + 10) / 2 = ${add10AndDivideBy2(10)}")

    val divideBy2AndAdd10 = add10 compose divideBy2
    println("---> 10 / 2 + 10 = ${divideBy2AndAdd10(10)}")

    // 2 -> Currying.
    val sumOfThree = { X: Int, Y: Int, Z: Int -> X + Y + Z }.curried()
    println("---> 2 + 3 + 4 = ${sumOfThree(2)(3)(4)}")

    // 3 -> Partial application.
    val from: (String, String, String) -> String =
        { prefix: String, name: String, country: String ->
            "$prefix $name from $country!"
        }
    val weAllAmerican: (String, String) -> String =
        from.partially3("United States")
    val justSayHello: (String) -> String =
        weAllAmerican.partially1("Hello")
    println("---> ${justSayHello("Nathan")}")
}