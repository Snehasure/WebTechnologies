package sneha;
import java.util.Scanner;
public class Worstfit {
	
	    // Function to find the index of the largest available partition
	    public static int findMax(int[] a, int n) {
	        int max = Integer.MIN_VALUE;
	        int idx = -1;
	        for (int i = 0; i < n; i++) {
	            if (a[i] > max) {
	                max = a[i];
	                idx = i;
	            }
	        }
	        return idx;
	    }

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

	        // Worst Fit Allocation
	        for (int i = 0; i < n; i++) {
	            int x = findMax(a, k); // Find the largest available partition
	            if (x != -1 && a[x] >= p[i]) { // Ensure partition is large enough
	                l[x] = i + 1; // Mark partition as allocated
	                System.out.printf("Process %d (%d KB) ---> Partition %d (%d KB)\n", i + 1, p[i], x + 1, t[x]);
	                a[x] -= p[i]; // Reduce available partition size
	            } else {
	                System.out.printf("Process %d (%d KB) cannot be allocated\n", i + 1, p[i]);
	            }
	        }

	        sc.close();
	    }
	}


