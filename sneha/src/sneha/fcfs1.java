package sneha;
import java.util.*;

class Process{
    String name;
    int arrivalTime, burstTime, completionTime, turnAroundTime, waitingTime;

    public Process(String name, int at, int bt) {
        this.name = name;
        this.arrivalTime = at;
        this.burstTime = bt;
    }
}

public class fcfs1{
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

        Arrays.sort(processes, Comparator.comparingInt(p -> p.arrivalTime));

        int currentTime = 0, totalWT = 0;
        System.out.println("\nGantt Chart:");
        System.out.print("|");
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            p.completionTime = currentTime + p.burstTime;
            p.turnAroundTime = p.completionTime - p.arrivalTime;
            p.waitingTime = p.turnAroundTime - p.burstTime;
            totalWT += p.waitingTime;
            
            System.out.print(" " + p.name + " |");
            currentTime = p.completionTime;
        }
        
        System.out.print("\n0");
        currentTime = 0;
        for (Process p : processes) {
            if (currentTime < p.arrivalTime) {
                currentTime = p.arrivalTime;
            }
            currentTime += p.burstTime;
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
