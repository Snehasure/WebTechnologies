package sneha;
import java.util.*;
public class Fcfs {
	
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Number of processes: ");
	        int n = sc.nextInt();
	        sc.nextLine(); 

	        String[] p = new String[n];
	        int[] bt = new int[n], at = new int[n], ct = new int[n], tat = new int[n], wt = new int[n];

	        System.out.println("Enter process names, arrival times and burst times:");
	        for (int i = 0; i < n; i++) {
	            System.out.print("Process name, arrival time, burst time for process " + (i + 1) + ": ");
	            p[i] = sc.next();
	            at[i] = sc.nextInt();
	            bt[i] = sc.nextInt();
	        }

	        // Sorting processes based on arrival time
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = i + 1; j < n; j++) {
	                if (at[i] > at[j]) {
	                    // Swap arrival time
	                    int tempAt = at[i];
	                    at[i] = at[j];
	                    at[j] = tempAt;

	                    // Swap burst time
	                    int tempBt = bt[i];
	                    bt[i] = bt[j];
	                    bt[j] = tempBt;

	                    // Swap process name
	                    String tempP = p[i];
	                    p[i] = p[j];
	                    p[j] = tempP;
	                }
	            }
	        }

	        // Calculate completion time
	        ct[0] = at[0] + bt[0];
	        for (int i = 1; i < n; i++) {
	            if (at[i] > ct[i - 1]) {
	                ct[i] = at[i] + bt[i];
	            } else {
	                ct[i] = ct[i - 1] + bt[i];
	            }
	        }

	        // Calculate TAT, WT, and sum of WT
	        int sumWT = 0;
	        for (int i = 0; i < n; i++) {
	            tat[i] = ct[i] - at[i];
	            wt[i] = tat[i] - bt[i];
	            sumWT += wt[i];
	        }

	        float avgWT = (float) sumWT / n;
	        System.out.printf("\nAverage waiting time: %.2f\n", avgWT);

	        // Print scheduling order
	        System.out.println("\nCPU scheduling order: ");
	        for (int i = 0; i < n; i++) {
	            System.out.print("| " + p[i] + " | ");
	        }
	        System.out.print("\n    0 ");
	        for (int i = 0; i < n; i++) {
	            System.out.print("   " + ct[i] + " ");
	        }

	        // Sorting by process name for final display
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = i + 1; j < n; j++) {
	                if (p[i].compareTo(p[j]) > 0) {
	                    // Swap process name
	                    String tempP = p[i];
	                    p[i] = p[j];
	                    p[j] = tempP;

	                    // Swap arrival time
	                    int tempAt = at[i];
	                    at[i] = at[j];
	                    at[j] = tempAt;

	                    // Swap burst time
	                    int tempBt = bt[i];
	                    bt[i] = bt[j];
	                    bt[j] = tempBt;

	                    // Swap completion time
	                    int tempCt = ct[i];
	                    ct[i] = ct[j];
	                    ct[j] = tempCt;

	                    // Swap turnaround time
	                    int tempTat = tat[i];
	                    tat[i] = tat[j];
	                    tat[j] = tempTat;

	                    // Swap waiting time
	                    int tempWt = wt[i];
	                    wt[i] = wt[j];
	                    wt[j] = tempWt;
	                }
	            }
	        }

	        // Display process details
	        System.out.println("\n\nProcess details:");
	        System.out.println("Process | AT  | BT  | CT  | TAT  | WT");
	        for (int i = 0; i < n; i++) {
	            System.out.printf("%s      | %d   | %d   | %d   | %d   | %d\n", p[i], at[i], bt[i], ct[i], tat[i], wt[i]);
	        }

	        sc.close();
	    }
	}

