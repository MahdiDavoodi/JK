import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.io.File
import java.lang.Exception

/*
* This is a challenge from the course I've been watching.
* I added some more things like delay, exception and...
* */
private const val filePath = "/home/mahdi/Programming/IntelliJ/Test/src/main/resources/Felina.txt"
fun main() {
    val file = File(filePath)
    printFile(file)
}

fun printFile(file: File) = runBlocking {
    val list = async { readFile(file) }
    list.await().forEach {
        delay(300)
        print(it)
    }
}

fun readFile(file: File): List<Char> {
    if (file.exists()) {
        val list = mutableListOf<Char>()
        file.forEachLine {
            for (ch in it)
                list.add(ch)
            list.add('\n')
        }
        return list
    } else throw Exception("FILE DOES NOT EXIST!")
}