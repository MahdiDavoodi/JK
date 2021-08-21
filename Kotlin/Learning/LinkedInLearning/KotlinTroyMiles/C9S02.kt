import kotlinx.coroutines.*

/*
* This is my example of coroutines.
* This time is about time out and canceling them.
* */
private class Person private constructor(val name: String, val lastName: String) {
    companion object {
        suspend fun makePerson(name: String, lastName: String): Person {
            println("---> Creating a person. Please wait...")
            delay(800)
            return Person(name, lastName)
        }
    }

    override fun toString(): String {
        return "$name - $lastName"
    }
}

// We can use time out like this.
fun makePersonWithTimeOut() = runBlocking {
    val result = withTimeoutOrNull(600) {
        val p1 = async { Person.makePerson("Nathan", "Drake") }
        val p2 = async { Person.makePerson("Joel", "Miller") }
        val people = listOf(p1, p2).awaitAll()
        println(people)
        "Task finished successfully."
    } ?: "Timed-Out!"
    println(result)
}

fun makePerson() = runBlocking {
    val p1 = async { Person.makePerson("Nathan", "Drake") }
    val p2 = async { Person.makePerson("Joel", "Miller") }
    val people = listOf(p1, p2).awaitAll()
    println(people)
}

fun main() {
    makePerson()
    println("-------------------------")
    makePersonWithTimeOut()
}