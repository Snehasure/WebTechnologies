package sneha;
import java.util.*;


public class RoundRobin {
	public static class Process {
	    String name;
	    int arrivalTime, burstTime, completionTime, originalBT;

	    Process(String name, int arrivalTime, int burstTime) {
	        this.name = name;
	        this.arrivalTime = arrivalTime;
	        this.burstTime = burstTime;
	        this.originalBT = burstTime;
	    }
	}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        List<Process> processes = new ArrayList<>();
        System.out.println("Enter the process name, arrival time, burst time: ");
        for (int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split(" ");
            processes.add(new Process(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2])));
        }

        System.out.print("Enter time slice: ");
        int timeSlice = sc.nextInt();

        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

        Queue<Process> rq = new LinkedList<>();
        List<Process> temp = new ArrayList<>(processes);

        int clk = 0, tbt = processes.stream().mapToInt(p -> p.burstTime).sum();

        while (clk < tbt) {
            for (Process p : new ArrayList<>(temp)) {
                if (p.arrivalTime == clk) {
                    rq.add(p);
                    temp.remove(p);
                }
            }

            if (!rq.isEmpty()) {
                Process curr = rq.poll();
                if (curr.burstTime > timeSlice) {
                    clk += timeSlice;
                    curr.burstTime -= timeSlice;

                    for (Process p : new ArrayList<>(temp)) {
                        if (p.arrivalTime >= clk - timeSlice && p.arrivalTime <= clk) {
                            rq.add(p);
                            temp.remove(p);
                        }
                    }

                    rq.add(curr);
                } else {
                    clk += curr.burstTime;
                    curr.completionTime = clk;
                    curr.burstTime = 0;

                    for (Process p : new ArrayList<>(temp)) {
                        if (p.arrivalTime >= clk - curr.originalBT && p.arrivalTime <= clk) {
                            rq.add(p);
                            temp.remove(p);
                        }
                    }
                }
            } else {
                clk++;
            }
        }

        processes.sort(Comparator.comparing(p -> p.name));

        System.out.println("\nProcess\t  AT\tBT\tCT\tTAT\t  WT");
        double totalWT = 0, totalTAT = 0;
        
        for (Process p : processes) {
            int tat = p.completionTime - p.arrivalTime;
            int wt = tat - p.originalBT;
            totalWT += wt;
            totalTAT += tat;
            System.out.println(p.name + "\t\t  " + p.arrivalTime + "\t    " + p.originalBT + "\t " + p.completionTime + "\t " + tat + "\t  " + wt);
        }

        System.out.printf("Average waiting time: %.2f\n", totalWT / n);
        System.out.printf("Average turnaround time: %.2f\n", totalTAT / n);

        sc.close();
    }
}