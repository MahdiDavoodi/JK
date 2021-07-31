/*
* In this example,
* I want to use Boolean and Characters,
* Do a little work with && and ||,
* Create another function that returns a value,
* Use if statement for first time,
* Use $ to use a variable in string or do some logical thing with ${}.
* */
fun main() {

    var isAwesome = true
    val isCool = true
    val mChar = 'm'
    val tChar: Char
    val number = 123

    //Usage of .toChar
    tChar = number.toChar()

    // If both of these variables are true, then print...
    if (isAwesome && isCool)
        println("$tChar -- $mChar")


    isAwesome = false
    // If one of them is true, print...
    if (isAwesome || isCool)
        println("---> One of them is true!")

    println(myFun())
}

// We can create function and return a value like this:
fun myFun(): String {
    //Usage of ${}
    return "---> Hello function! We are in ${22081 - 20060}!"
}