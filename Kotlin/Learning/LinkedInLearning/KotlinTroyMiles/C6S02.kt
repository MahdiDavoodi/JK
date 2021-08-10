/*
* This is an example for lambda functions.
* */
fun main() {
    // 1) Declare lambda.
    val plus: (Int, Int) -> Int = { x: Int, y: Int -> x + y }

    // 2) Call the lambda.
    println("---> 5 + 10 = ${plus(5, 10)}")

    // 3) Shorter declaration.
    val minus = { x: Int, y: Int -> x - y }

    // 5) Invoke.
    println("---> 100 - 75 = ${minus.invoke(100, 75)}")

    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    // 4) Use lambda without declaration.
    val mList = list.map { x -> x * 2 }
    // 6) Even shorter lambda!
    val fList = mList.filter { it % 2 == 0 }

    println(fList)

    // 7) Extend classes.
    val hello: String.() -> String = { "Hello $this!" }
    println("Mahdi".hello())
}