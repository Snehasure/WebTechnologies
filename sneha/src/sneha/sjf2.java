package sneha;
import java.util.*;

class Process {
    String name;
    int arrivalTime, burstTime, completionTime, turnAroundTime, waitingTime;

    public Process(String name, int at, int bt) {
        this.name = name;
        this.arrivalTime = at;
        this.burstTime = bt;
    }
}

public class sjf2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        sc.nextLine();
        
        Process[] processes = new Process[n];
        
        System.out.println("Enter process name, arrival time, and burst time:");
        for (int i = 0; i < n; i++) {
            System.out.print("Process name, arrival time, burst time for process " + (i + 1) + ": ");
            processes[i] = new Process(sc.next(), sc.nextInt(), sc.nextInt());
        }

        // Sort processes based on arrival time
        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0, completed = 0, totalWT = 0;
        boolean[] isCompleted = new boolean[n];
        
        // To store the order of processes that are completed
        List<Process> ganttChart = new ArrayList<>();

        System.out.println("\nGantt Chart:");
        System.out.print("|");

        // Run the simulation
        while (completed < n) {
            int shortestIndex = -1;
            int minBurst = Integer.MAX_VALUE;

            // Find the process with the shortest burst time that has arrived
            for (int i = 0; i < n; i++) {
                if (!isCompleted[i] && processes[i].arrivalTime <= currentTime && processes[i].burstTime < minBurst) {
                    minBurst = processes[i].burstTime;
                    shortestIndex = i;
                }
            }

            if (shortestIndex == -1) {
                currentTime++; // Idle time
            } else {
                Process p = processes[shortestIndex];
                p.completionTime = currentTime + p.burstTime;
                p.turnAroundTime = p.completionTime - p.arrivalTime;
                p.waitingTime = p.turnAroundTime - p.burstTime;
                totalWT += p.waitingTime;
                
                isCompleted[shortestIndex] = true;
                currentTime = p.completionTime;
                completed++;
                
                ganttChart.add(p); // Add completed process to gantt chart
                System.out.print(" " + p.name + " |");
            }
        }

        System.out.print("\n0");
        currentTime = 0;
        // Print the time axis for the Gantt chart
        for (Process p : ganttChart) {
            currentTime = p.completionTime;
            System.out.print("    " + currentTime);
        }
        
        System.out.printf("\n\nAverage waiting time: %.2f\n", (float) totalWT / n);
        System.out.println("\nProcess details:");
        System.out.println("Process | AT  | BT  | CT  | TAT  | WT");
        for (Process p : processes) {
            System.out.printf("%s      | %d   | %d   | %d   | %d   | %d\n", p.name, p.arrivalTime, p.burstTime, p.completionTime, p.turnAroundTime, p.waitingTime);
        }

        sc.close();
    }
}
