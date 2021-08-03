/*
* In this example I'm going to take a look at arrays in Kotlin.
* To see: How to create them,
* How to use them,
* How to access their properties.
*  */
fun main() {
    //We can define an array like this
    val array1 = arrayOf("Hello", "Goodbye", 1, 2, 3, "Android")

    //And we can have access to an object in array like this
    println("---> ${array1[0]} ${array1[5]}!")

    //You can define an array with fixed type
    val array2 = arrayOf<Person>(
        Person("Mahdi", "Developer"),
        Person("Taha", "Director")
    )

    //Another way to create array is to use Array,
    //And pass a function or lambda to its constructor.
    val array3 = Array(5, ::multiplyFour)

    //We can access array's properties like this
    println("---> We have ${array2.size} person")
    println("---> Indices in array 3 is between ${array3.indices}")
    println("---> The last index in array 1 is: ${array1.lastIndex}")

    //We can move on arrays objects like this
    for (person in array2)
        println(person.name)

    //Also, we can create primitive arrays like this
    val array4 = intArrayOf(1, 2, 3, 4, 5)
    println("---> ${array4[0]}")
}

fun multiplyFour(input: Int): Int {
    return input * 4
}

data class Person(val name: String, val job: String)
