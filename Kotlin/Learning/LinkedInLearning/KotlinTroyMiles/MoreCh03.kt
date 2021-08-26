/*
* This is challenge by Troy Miles in his course.
* The task is to overload the plus and minus operators for Cubic class.
* */
fun main() {
    val c1 = Cubic03(10, 20, 30)
    val c2 = Cubic03(5, 8, 28)
    val c3 = c1 + c2
    val c4 = c1 - c2

    println(c3)
    println(c4)
}

data class Cubic03(val a: Int, val b: Int, val c: Int) {
    infix operator fun plus(other: Cubic03): Cubic03 {
        return Cubic03(
            a + other.a,
            b + other.b,
            c + other.c
        )
    }

    infix operator fun minus(other: Cubic03): Cubic03 {
        return Cubic03(
            a - other.a,
            b - other.b,
            c - other.c
        )
    }

    override fun toString(): String {
        return "A = $a | B = $b | C = $c"
    }
}