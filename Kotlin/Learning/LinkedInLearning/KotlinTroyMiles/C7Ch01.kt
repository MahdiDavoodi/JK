/*
* This is a challenge from the course I've been watching.
* Task: Count the number of instances that we create.
* Solved by me.
* */
class Bosco {
    init {
        count++
    }

    companion object {
        var count = 0
        fun show() {
            println(count)
        }
    }
}

fun nop() {
    val b = Bosco()
}

fun main() {
    val b1 = Bosco()
    val b2 = Bosco()
    nop()
    val b3 = Bosco()
    Bosco.show()
}