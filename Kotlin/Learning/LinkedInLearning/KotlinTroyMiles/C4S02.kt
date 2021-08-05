/*
* In this example I want to take a brief look at Lists collections in Kotlin
* */
fun main() {
    //You can easily define a list like this
    val test1 = listOf("Hello", 2, "Android")

    //You have access to items with index
    println("---> ${test1[0]} ${test1[2]}")

    //You can get a copy like this
    val test2 = test1.subList(0, 1)
    println("---> ${test2.size}")

    //In a mutable list you can change items
    val test3 = mutableListOf("Hello", "This", "Is", "Mutable")
    test3[0] = "Goodbye"
    println("---> ${test3[0]}")

    //You can add or remove items to mutable list.
    test3.add("List!")
    test3.remove("Mahdi")
    test3.removeAt(0)
    for (item in test3)
        print("$item ")
}