/*
* In this example I want to take a look at sets
* */
fun main() {
    //You can define a set like this
    val set1 = setOf("Java", "Kotlin", "Android", 2)
    println(set1)

    //Duplicates are not allowed in sets
    val set2 = setOf(5, 5, 5, 5, 5)
    println("---> ${set2.size}")

    //You can define a mutable set like this
    val set3 = mutableSetOf("Hello", "World")
    val set4 = mutableSetOf("World", "Hello")
    println("---> ${set3 == set4}")
    println("---> ${set3.first() == set4.first()}")

    //You can add or remove items to mutable sets
    set4.remove("Hello")
    set3.add("Java")
    println(set3)
    println(set4)

    //Create a hash set like this
    val hash1 = hashSetOf("Hello", "World")
    val hash2 = hashSetOf("World", "Hello")
    println("---> ${hash1 == hash2}")
    println("---> ${hash1.first() == hash2.first()}")


    //Convert a set to list like this
    val list1 = hash1.toList()
    println(list1)
}