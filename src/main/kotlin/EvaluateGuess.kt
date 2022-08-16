package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {

    val rightPositions = secret.zip(guess).count { it.first == it.second }

    val commonLetters = "ABCDEF".sumOf { ch ->

        secret.count { it == ch }.coerceAtMost(guess.count { it == ch })
    }
    return Evaluation(rightPositions, commonLetters - rightPositions)
}

fun main() {
    evaluateGuess("BCDF", "ACEB")
    evaluateGuess("AAAF", "ABCA")
    evaluateGuess("ABCA", "AAAF")
}
