package sneha;
import java.util.Scanner;
public class Bestfit {
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Get number of partitions
	        System.out.print("Enter number of partitions: ");
	        int k = sc.nextInt();

	        int[] a = new int[k], t = new int[k], l = new int[k];
	        // Initialize l array to 0
	        for (int i = 0; i < k; i++) {
	            l[i] = 0;
	        }

	        // Get partition values
	        System.out.print("Enter partition values: ");
	        for (int i = 0; i < k; i++) {
	            a[i] = sc.nextInt();
	            t[i] = a[i]; // Store original values
	        }

	        // Get number of processes
	        System.out.print("Enter number of processes: ");
	        int n = sc.nextInt();

	        int[] p = new int[n];
	        // Get memory requirement for each process
	        System.out.print("Enter memory requirement of each process: ");
	        for (int i = 0; i < n; i++) {
	            p[i] = sc.nextInt();
	        }

	        // Best Fit Allocation
	        for (int i = 0; i < n; i++) {
	            int minIdx = -1;
	            int min = Integer.MAX_VALUE;

	            for (int j = 0; j < k; j++) {
	                if (a[j] >= p[i] && a[j] < min) { // Find the smallest suitable partition
	                    minIdx = j;
	                    min = a[j];
	                }
	            }

	            if (minIdx != -1) {
	                System.out.printf("Process %d (%d KB) ---> Partition %d (%d KB)\n", i + 1, p[i], minIdx + 1, t[minIdx]);
	                a[minIdx] -= p[i]; // Reduce available partition size
	                l[minIdx] = i + 1; // Mark partition as allocated
	            } else {
	                System.out.printf("Process %d (%d KB) cannot be allocated\n", i + 1, p[i]);
	            }
	        }

	        sc.close();
	    }
	}


