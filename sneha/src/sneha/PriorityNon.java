package sneha;
import java.util.Scanner;

public class PriorityNon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        int[] at = new int[n];
        int[] bt = new int[n];
        int[] priority = new int[n];
        int[] ct = new int[n];
        int[] wt = new int[n];
        int[] tat = new int[n];
        int[] process = new int[n];
        int[] remaining_bt = new int[n];

        System.out.print("Enter arrival time: ");
        for (int i = 0; i < n; i++) {
            at[i] = sc.nextInt();
        }

        System.out.print("Enter burst time: ");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
            remaining_bt[i] = bt[i];
            process[i] = i + 1;
        }

        System.out.print("Enter priority (Lower value means higher priority): ");
        for (int i = 0; i < n; i++) {
            priority[i] = sc.nextInt();
        }

        int completed = 0, time = 0;
        StringBuilder ganttChart = new StringBuilder();
        StringBuilder timeChart = new StringBuilder();

        // Find the minimum arrival time
        int minArrivalTime = Integer.MAX_VALUE;
        for (int arrivalTime : at) {
            minArrivalTime = Math.min(minArrivalTime, arrivalTime);
        }
        time = minArrivalTime;
        timeChart.append(time).append(" "); // Start time of Gantt Chart

        while (completed < n) {
            int highestPriority = Integer.MAX_VALUE;
            int pos = -1;

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && remaining_bt[i] > 0) {
                    if (priority[i] < highestPriority) {
                        highestPriority = priority[i];
                        pos = i;
                    } else if (priority[i] == highestPriority) {
                        // Break tie using arrival time (optional but better)
                        if (at[i] < at[pos]) {
                            pos = i;
                        }
                    }
                }
            }

            if (pos != -1) {
                ganttChart.append("P").append(process[pos]).append(" ");
                time += remaining_bt[pos];
                ct[pos] = time;
                tat[pos] = ct[pos] - at[pos];
                wt[pos] = tat[pos] - bt[pos];
                remaining_bt[pos] = 0;
                completed++;
                timeChart.append(time).append(" ");
            } else {
                ganttChart.append("Idle ");
                time++;
                timeChart.append(time).append(" ");
            }
        }

        System.out.println("\nProcess\tAT\tBT\tPriority\tCT\tTAT\tWT");
        float totalWT = 0, totalTAT = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("P" + process[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + priority[i] + "\t\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
            totalWT += wt[i];
            totalTAT += tat[i];
        }

        System.out.println("\nAverage Waiting Time: " + (totalWT / n));
        System.out.println("Average Turnaround Time: " + (totalTAT / n));

        System.out.println("\nGantt Chart:");
        System.out.println(ganttChart.toString().trim());
        System.out.println(timeChart.toString().trim());

        sc.close();
    }
}
