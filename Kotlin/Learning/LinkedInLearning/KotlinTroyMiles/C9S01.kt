import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.math.pow
import kotlin.system.measureTimeMillis

/*
* This is a basic example for coroutines.
*  */

fun main() {
    val sTime = measureTimeMillis { sync() }
    println("---> The time for synchronous: $sTime")

    val aTime = measureTimeMillis { async() }
    println("---> The time for asynchronous: $aTime")
}

suspend fun powPlusFive(number: Double, power: Double): Double {
    delay(1000)
    return number.pow(power) + 5
}

fun sync() = runBlocking {
    val a = powPlusFive(5.0, 5.0)
    val b = powPlusFive(20.0, 3.0)
    val c = powPlusFive(9.0, 4.0)
    val sum = listOf(a, b, c).sum()
    println(sum)
}

fun async() = runBlocking {
    val a = async { powPlusFive(5.0, 5.0) }
    val b = async { powPlusFive(20.0, 3.0) }
    val c = async { powPlusFive(9.0, 4.0) }
    val sum = listOf(a, b, c).awaitAll().sum()
    println(sum)
}