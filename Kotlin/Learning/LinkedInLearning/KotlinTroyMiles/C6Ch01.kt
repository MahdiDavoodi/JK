/*
* Another simple challenge from Troy.
* In this challenge I have to define a function for Troy's replicate function.
* I prefer lambda in this case.
* Funny thing is, I solved this problem exactly like him.
* */

fun replicate(func: (Int, String) -> Unit) {
    func(3, "Be Cool.")
}

fun main() {
    replicate { x: Int, string: String ->
        for (n in 1..x)
            println(string)
    }
}