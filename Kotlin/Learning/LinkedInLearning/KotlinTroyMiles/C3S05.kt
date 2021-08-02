/*
* In this example I want to take a look at null in Kotlin,
* Tools that help us prevent null pointer exceptions,
* Data classes in Kotlin and a lot more...
* */

fun main() {

    //We can define a nullable variable like this
    var val1: String? = "Android"
    val val2: Int? = null
    var artist: Artist? = null

    //We have to check nullable variables before use.
    if (val2 != null)
        println("---> ${val2 + 2}")


    //Tool 1: Safe call for variables properties. ("?.")
    //Notice after giving a value to "artist" safe call is unnecessary.
    println("---> My favorite artist is ${artist?.name}")

    artist = Artist("Twenty One Pilots", 11)

    println("---> My favorite artist is ${artist.name}")

    //Tool 2: Elvis operator to check a variable and assign a default value.
    val1 = null
    var val3: String? = val1 ?: "Mahdi"

    println("---> $val3")

    //Tool 3: not-null operator to tell Kotlin to back off! We are sure that this variable is not null.
    val val4: Int = val3!!.length
    println("---> $val4")
    val3 = "Ow"

    //Tool 4: Safe cast.
    val val5: Long? = val3!!.length as? Long
    println("---> $val5")
}

// A data class is like a record class in Java! It contains data!
data class Artist(val name: String, val age: Int)