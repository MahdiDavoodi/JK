/*
* Another simple challenge from Troy.
* I got to remove the duplicates in list.
* */
fun main() {
    val animals = listOf(
        "apple", "biscuit", "apple", "cat", "cat", "cat",
        "dog", "elephant", "fox", "goat", "elephant"
    )

    val animalsSet = animals.toSet()
    println("---> Without duplicates: $animalsSet")
}