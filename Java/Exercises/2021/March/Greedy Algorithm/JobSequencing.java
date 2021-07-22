package ir.blog.mahdidavoodi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*
 * Greedy Algorithm examples solved by myself!
 * */
public class JobSequencing {
    static class Job {
        Double ratio;
        String id;
        int deadline, profit;

        public Job(int deadline, int profit, String id) {
            this.deadline = deadline;
            this.profit = profit;
            this.id = id;
            ratio = (double) profit / (double) deadline;
        }
    }

    private static void jobs(int[] deadlines, int[] profits, String[] id) {
        Job[] jobs = new Job[deadlines.length];

        for (int i = 0; i < deadlines.length; i++) {
            jobs[i] = new Job(deadlines[i], profits[i], id[i]);
        }

        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job job1, Job job2) {
                return job2.ratio.compareTo(job1.ratio);
            }
        });

        int deadline = 0;
        ArrayList<String> selectedJobs = new ArrayList<>();

        for (Job job : jobs)
            if (job.deadline > deadline)
                selectedJobs.add(deadline++, job.id);

        System.out.println(selectedJobs);
    }

    public static void main(String[] args) {
        String[] id = {"a", "b", "c", "d", "e"};
        int[] deadlines = {2, 1, 2, 1, 3};
        int[] profits = {100, 19, 27, 25, 15};
        if (deadlines.length == profits.length && profits.length == id.length)
            jobs(deadlines, profits, id);
    }
}