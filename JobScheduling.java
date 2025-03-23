import java.util.Arrays;

class Job {
    char id;   // Job Id
    int dead;  // Deadline of job
    int profit; // Profit if job is completed before or on deadline

    public Job(char id, int dead, int profit) {
        this.id = id;
        this.dead = dead;
        this.profit = profit;
    }
}

public class JobScheduling {
    // Comparison function to sort jobs in descending order of profit
    private static void sortJobsByProfit(Job[] jobs) {
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
    }

    // Function to find the job sequence that maximizes profit
    public static void printJobScheduling(Job[] jobs, int n) {
        // Sort jobs by descending profit
        sortJobsByProfit(jobs);

        int maxDeadline = 0;
        for (Job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.dead);
        }

        char[] result = new char[maxDeadline]; // Stores job sequence
        boolean[] slot = new boolean[maxDeadline]; // Slot availability
        int totalProfit = 0;

        // Iterate through jobs and place them in the latest available slot before their deadline
        for (Job job : jobs) {
            for (int j = Math.min(maxDeadline - 1, job.dead - 1); j >= 0; j--) {
                if (!slot[j]) {
                    result[j] = job.id;
                    slot[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        // Print job sequence and total profit
        System.out.println("Job Sequence:");
        System.out.println("-----------------------------");
        System.out.println("| Job | Deadline | Profit    |");
        System.out.println("-----------------------------");
        for (int i = 0; i < maxDeadline; i++) {
            if (slot[i]) {
                for (Job job : jobs) {
                    if (job.id == result[i]) {
                        System.out.printf("|  %c  |    %d     |   %d     |\n", job.id, job.dead, job.profit);
                        break;
                    }
                }
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Total Profit: " + totalProfit);
    }

    // Driver code
    public static void main(String[] args) {
        Job[] jobs = {
                new Job('a', 2, 100),
                new Job('b', 1, 19),
                new Job('c', 2, 27),
                new Job('d', 1, 25),
                new Job('e', 3, 15)
        };

        System.out.println("Following is the maximum profit sequence of jobs:");
        printJobScheduling(jobs, jobs.length);
    }
}
