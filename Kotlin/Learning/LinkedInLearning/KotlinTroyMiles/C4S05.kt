/*
* In this example I want to get familiar with collections operators
* */
fun main() {
    val map = mapOf(1 to 10, 2 to 20, 3 to 30, 4 to 40)
    val set = setOf(23, 44, 13, 245, 50, 10)
    val list = listOf(5, 5, 3, 3, 28, 45, 56, 4, 12)

    //We can use .map to create new collection from another
    val mList = list.map { it * 5 }
    val mMap = map.map { Pair(it.key, it.value - 20) }.toMap()
    println("---> $mList")
    println("---> $mMap")

    //We can use filter to create a collection from items we want.
    val fSet = set.filter { it % 2 == 0 }
    val fList = list.filter { x -> x == 5 }
    println("---> $fSet")
    println("---> $fList")

    //We can sort collections like this
    val sSet = set.sortedDescending()
    println("---> $sSet")

    //Use first and last for getting an item
    //It will return the last one bigger than 20
    val item = set.last { x -> x > 20 }
    println("---> $item")

    //We can convert collections like this
    val cSet = list.toSet()
    println("---> $cSet")
}