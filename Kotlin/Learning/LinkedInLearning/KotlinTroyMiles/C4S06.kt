/*
* This is an exercise fo sequences
* */
fun main() {
    //You can convert a collection to a sequence like
    //This will get first odd number.
    val output = (20 until 100).asSequence()
        .map { X -> X - 20 }
        .filter { X -> X % 2 != 0 }
        .first()

    println(output)

    //You can define a sequence like this
    val seq = sequenceOf(1, 2, 3, 4, 5, 6).filter { it % 2 == 0 }
    println(seq)

    //If you want the proper output, you have to convert it to a collection
    println(seq.toList())
}