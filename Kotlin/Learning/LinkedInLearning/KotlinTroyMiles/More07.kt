/*
* This is an example of using annotations.
* */
fun main() {
    val java1 = Java01("1995")
    println(java1)
}

@Deprecated(
    "This version is not recommended!",
    ReplaceWith("Java16")
)
data class Java01(val releaseData: String)

data class Java16(val releaseData: String)