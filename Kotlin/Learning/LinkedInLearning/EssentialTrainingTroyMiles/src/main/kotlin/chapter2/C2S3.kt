package chapter2

/*
* In this example I learned to use Boolean and Characters variables.
* && and || in Kotlin.
* Logical calculation in strings.
* And a lot more.
* */
fun main() {
    //Boolean and numbers
    val aNum = 2_323_232
    val bNum = 23
    val haveVal = true
    print("---> The bigger number is:")
    if (aNum > bNum && haveVal)
        println(aNum)

    //Chars
    val a = 'a'
    val b = 'b'
    val tap = '\t'
    val digitFour = '୪'
    println(
        "---> The chars = $a $b $tap" +
                " $digitFour"
    )
    println(result())
}

//Create function that returns and usage of ${}, $
fun result(): String {
    val a = 23
    val b = 20
    return "---> Result is: ${a - b}"
}