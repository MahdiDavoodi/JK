/*
* This is a challenge from Exercism.org.
* I have two iterations for solving it.
* First one is my way and second is the best answer by the community.
* */
object Hamming {
    // Iteration 2 - Learned this way from Graham Lea!
    fun compute(a: String, b: String): Int {
        require(a.length == b.length) { "left and right strands must be of equal length" }
        return a.zip(b).count { it.first != it.second }
    }

    // Iteration 1 - My way.
    /*

    fun compute(left: String, right: String): Int {
        if (left.length != right.length)
            throw IllegalArgumentException("left and right strands must be of equal length")
        var difference = 0
        left.forEachIndexed { index, ch ->
            if (ch != right[index])
                difference++
        }
        return difference
    }

    */
}