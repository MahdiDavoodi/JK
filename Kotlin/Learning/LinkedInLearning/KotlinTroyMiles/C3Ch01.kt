/*
* A simple challenge to replace Troy's if expression with when.
* I don't have access to his files so my version is little different.
* */

fun main() {
    val points = 7_000

    val level = when (points) {
        in 0..999 -> "pearl"
        in 1000..4999 -> "silver"
        in 5000..9999 -> "gold"
        else -> "platinum"
    }

    println(
        "---> You have $points point${
            if (points > 1) "s "
            else " "
        }" + "at the $level level!"
    )
}