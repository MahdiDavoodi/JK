import java.util.*

/*
* An example for getting user's input.
* */
fun main() {
    //We can use readLine to read the input.
    print("---> Please enter you name: ")
    val name = readLine()

    print("\n---> Hello $name! How old are you? ")

    //Elvis' operation.(Mentioned before)
    val age: Int = readLine()?.toIntOrNull() ?: 0

    print("\n---> So you are $age years old.")

    //Call a function.
    scanner()
}

fun scanner() {
    //Also, we can use scanner to get data.
    val scanner = Scanner(System.`in`)
    print("\n---> What is your phone number? ")
    val number: Int = scanner.nextInt()

    println("\n---> Your phone number is $number.")
}