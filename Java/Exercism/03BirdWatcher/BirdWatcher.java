
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return new int[] {0, 2, 5, 3, 7, 8, 4};
    }

    public int getToday() {
        if(birdsPerDay.length == 0) return 0;
        else return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
       birdsPerDay[birdsPerDay.length - 1] = birdsPerDay[birdsPerDay.length - 1] + 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int x : birdsPerDay)
            if (x == 0)
                return true;
        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        if(numberOfDays > birdsPerDay.length)
            numberOfDays = birdsPerDay.length;
        int sum = 0;
        for(int x = 0; x < numberOfDays; x++)
            sum += birdsPerDay[x];
        return sum;
    }

    public int getBusyDays() {
       int busyDays = 0;
        for(int x: birdsPerDay)
            if(x >= 5)
                busyDays++;
        return busyDays;
    }
}
/*
This is a challenge on Exercism.
Link --->   https://exercism.org/tracks/java/exercises/bird-watcher
*/
