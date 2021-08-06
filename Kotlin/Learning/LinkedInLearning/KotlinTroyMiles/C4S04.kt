/*
* This example is for maps.
* */
fun main() {
    //You can define a map like this
    val map1 = mapOf(1 to "Android", 2 to "IOS", 3 to "Windows")
    val map2 = mapOf(3 to "Windows", 2 to "IOS", 1 to "Android")

    println("---> ${map1 == map2}")
    println("---> ${map1[1]}")

    //You can use getOrDefault
    println("---> ${map2.getOrDefault(4, "MacOS")}")

    //You can define a mutable map like
    val map3 = mutableMapOf("Hello" to 2021, "Android" to 2080)
    println("---> ${map3.size}")

    //You can add or remove items in maps like this
    map3["Goodbye"] = 2020
    map3.remove("Hello")
    println(map3)

    //Usage of in operator(Check for item or iterate).
    for (item in map1)
        println(item)

    println("---> ${2 in map1}")
    println("---> ${"IOS" in map2.values}")
}