/*
* This is an example for method chaining and sequences.
* */
fun main() {
    // Gets a sample list from another file.
    val devList =
        Developer11
            .sampleList()
    println("---> $devList")

    // Take and drop example from sequences.
    val example1 = devList
        .drop(1)
        .take(2)
        .toList()
    println(example1)

    val example2 = generateSequence(1) { it + 5 }
        .take(5)
        .toList()
    println(example2)

    val example3 = generateSequence(1) { it + 1 }
        .map { it * it }
        .filter { it % 2 == 0 }
        .take(10)
        .toList()
    println(example3)

    // Fibonacci example.
    val example4 = generateSequence(1 to 1) { it.second to it.first + it.second }
        .map { it.first }
        .take(10)
        .toList()
    println(example4)
}