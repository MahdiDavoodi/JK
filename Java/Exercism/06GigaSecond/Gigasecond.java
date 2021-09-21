import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {
    private final LocalDateTime time;

    public Gigasecond(LocalDate date) {
        this.time = date.atStartOfDay();
    }

    public Gigasecond(LocalDateTime date) {
        this.time = date;
    }

    public LocalDateTime getDateTime() {
        return time.plusSeconds(1_000_000_000L);
    }
}
/*
 * This is a challenge on Exercism.
 * Link ---> https://exercism.org/tracks/java/exercises/gigasecond
 */