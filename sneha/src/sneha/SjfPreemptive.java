package sneha;
import java.util.Scanner;
public class SjfPreemptive {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        System.out.print("Enter number of processes: ");
	        int n = sc.nextInt();
	        
	        int[] at = new int[n];
	        int[] bt= new int[n];
	        int[] remaining_bt = new int[n];
	        int[] ct = new int[n];
	        int[] wt = new int[n];
	        int[] tat = new int[n];
	        int[] process = new int[n];
	        
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
	        
	        int completed = 0, time = 0, ganttCount = 0;
	        StringBuilder ganttChart = new StringBuilder();
	        StringBuilder timeChart = new StringBuilder();
	        
	        while (completed < n) {
	            int minBurstTime = Integer.MAX_VALUE;
	            int pos = -1;
	            
	            for (int i = 0; i < n; i++) {
	                if (at[i] <= time && remaining_bt[i] > 0) {
	                    if (remaining_bt[i] < minBurstTime) {
	                        minBurstTime = remaining_bt[i];
	                        pos = i;
	                    }
	                }
	            }
	            
	            if (pos != -1) {
	                if (ganttCount == 0 || ganttChart.charAt(ganttChart.length() - 1) != ('P' + process[pos])) {
	                    ganttChart.append(" P" + process[pos] + " ");
	                    timeChart.append(time + "    ");
	                }
	                remaining_bt[pos]--;
	                time++;
	                
	                if (remaining_bt[pos] == 0) {
	                    ct[pos] = time;
	                    tat[pos] = ct[pos] - at[pos];
	                    wt[pos] = tat[pos] - bt[pos];
	                    completed++;
	                }
	            } else {
	                ganttChart.append(" - ");
	                timeChart.append(time + " ");
	                time++;
	            }
	        }
	        
	        timeChart.append(time);
	        
	        System.out.println("\nProcess\tAT\tBT\tCT\tTAT\tWT");
	        float totalWT = 0, totalTAT = 0;
	        for (int i = 0; i < n; i++) {
	            System.out.println("P" + process[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + tat[i] + "\t" + wt[i]);
	            totalWT += wt[i];
	            totalTAT += tat[i];
	        }
	        
	        System.out.println("\nAverage Waiting Time: " + (totalWT / n));
	        System.out.println("Average Turnaround Time: " + (totalTAT / n));
	        
	        System.out.println("\nGantt Chart:");
	       
	        System.out.println(ganttChart);
	        System.out.println(timeChart);
	        sc.close();
	    }
	}


