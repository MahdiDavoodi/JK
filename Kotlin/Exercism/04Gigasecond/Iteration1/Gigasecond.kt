import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(input: LocalDateTime) {
    val date: LocalDateTime = input.plusSeconds(1_000_000_000)

    constructor(input: LocalDate) : this(input.atStartOfDay())
}
/*
* This is a challenge in Exercism.org
* Link --->  https://exercism.org/tracks/kotlin/exercises/gigasecond
* This is my first try - Iteration 1.
* */