import java.io.File

/*
* In this example we want to work with files. Read and write.
* */
fun main() {
    val res = "/home/mahdi/Programming/IntelliJ/Kotlin/src/main/resources"
    val sampleName = "sample.txt"
    val sample = File("$res/$sampleName")

    //Read file.
    if (sample.exists())
        sample.forEachLine { println(it) }


    println("-------------------------------------------------")

    //Write file.
    //We have to use appendText because writeText clears the file.
    val new = File("$res/new.txt")
    if (new.exists())
        new.writeText("")
    val list = listOf("Android", "IOS", "Windows", "Linux", "MacOS")
    list.forEach { x -> new.appendText("$x\n") }


    // Read the file we created.
    if (new.exists())
        new.forEachLine { x -> println(x) }
}