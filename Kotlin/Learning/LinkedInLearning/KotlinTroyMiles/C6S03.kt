/*
* This example is about anonymous functions.
* */
fun main() {
    val list = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    // 1) Declaration and regular usage.
    val list2 = list.filter(fun(x: Int): Boolean { return x > 5 })
    println(list2)

    // 2) Expression form.
    val list3 = list.filter(fun(x) = (x % 2 == 0))
    println(list3)

    // 3) Lambda multiple return.
    val greeting = lambda@{ x: Int ->
        if (x == 0)
            return@lambda "Hello"
        else
            return@lambda "Goodbye"
    }

    // 4) Anonymous function multiple return.
    val name = fun(x: Int): String {
        return if (x == 0)
            "Mahdi"
        else "John"
    }
    println("---> ${greeting(0)} ${name(0)}!")
}