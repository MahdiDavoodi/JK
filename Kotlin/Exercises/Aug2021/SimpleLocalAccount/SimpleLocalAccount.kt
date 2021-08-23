import java.io.File
import java.lang.Exception
import java.util.*

/*
* A simple practice of working with files.
* It creates local accounts and store them in text file.
* */
data class Account(val name: String, val password: String) {
    override fun toString(): String {
        return "$name-$password"
    }
}

class WorkFile(path: String) {
    var file: File

    init {
        file = File(path)
        if (!file.exists())
            file.writeText("")
    }

    fun saveAccount(account: Account) {
        file.appendText("$account\n")
    }

    fun doesAccountExist(name: String): Account {
        var aName: String
        var aPassword: String
        var temp: List<String>
        var account: Account? = null

        // IDK how to break from this shit. So it goes to the end.
        file.forEachLine {
            temp = it.split("-")
            aName = temp[0]
            aPassword = temp[1]
            if (aName.uppercase() == name.uppercase()) {
                account = Account(aName, aPassword)
            }
        }
        if (account != null) return account as Account
        else throw Exception("Account DOES NOT EXIST!")
    }
}

fun accountLogIn(scanner: Scanner, file: WorkFile) {
    val input = scanner.nextLine().trim().split("-")
    try {
        val account = file.doesAccountExist(input[0])
        if (account.password == input[1])
            println("---> LogIn was successful! Hello ${account.name}.")
        else
            println("---> Password was not correct!")
    } catch (e: Exception) {
        println("\n---> ${e.message}")
    }
}

fun createAccount(scanner: Scanner, file: WorkFile) {
    val input = scanner.nextLine().trim().split("-")
    try {
        file.doesAccountExist(input[0])
        println("---> Account already exists. Try to log in!")
    } catch (e: Exception) {
        val account = Account(input[0], input[1])
        file.saveAccount(account)
        println("---> Account created!")
    }
}

fun printUserInput() = print("$ ")
fun main() {
    val file = WorkFile("data.txt")
    val scanner = Scanner(System.`in`)
    println("---> LogIn or create account? [L / C]")
    printUserInput()
    val input = scanner.nextLine().trim().uppercase()
    println("---> Please input your information like username-password:")
    printUserInput()
    when (input) {
        "C" -> createAccount(scanner, file)
        "L" -> accountLogIn(scanner, file)
        else -> println("---> The input was not okay! Goodbye.")
    }
}