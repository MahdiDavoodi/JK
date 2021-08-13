/*
* An example for local functions.
* */
fun main() {
    val list = listOf("Wow", "Cat", "Level", "SOS", "Cat")
    list.forEach { println("---> Is $it palindrome? ${isPalindrome(it)}") }
}

fun isPalindrome(word: String): Boolean {
    fun charsEqual(x: Int, y: Int): Boolean {
        return if (x >= y) true
        else if (word[x].lowercaseChar() == word[y].lowercaseChar())
            return charsEqual(x + 1, y - 1)
        else return false
    }
    return if (word.length < 2) true
    else charsEqual(0, word.lastIndex)
}