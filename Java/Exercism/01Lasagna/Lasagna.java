package mahdi.davoodi;

/*
 * This is a challenge from Exercism Java track.
 * Link of the challenge --->    https://exercism.org/tracks/java/exercises/lasagna
 * */
public class Lasagna {
    public int expectedMinutesInOven() {
        return 40;
    }

    public int remainingMinutesInOven(int n) {
        return expectedMinutesInOven() - n;
    }

    public int preparationTimeInMinutes(int l) {
        return l * 2;
    }

    public int totalTimeInMinutes(int l, int t) {
        return t + preparationTimeInMinutes(l);
    }
}
