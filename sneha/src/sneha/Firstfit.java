package sneha;
import java.util.Scanner;
public class Firstfit {
	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        // Get number of partitions
	        System.out.print("Enter number of partitions: ");
	        int k = sc.nextInt();

	        int[] a = new int[k], t = new int[k];
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
	        int[] l = new int[k];
	        for (int i = 0; i < k; i++) {
	            l[i] = 0; // Initialize l array to 0
	        }

	        // Get memory requirement for each process
	        System.out.print("Enter memory requirement of each process: ");
	        for (int i = 0; i < n; i++) {
	            p[i] = sc.nextInt();
	        }

	        // First Fit Allocation
	        for (int i = 0; i < n; i++) {
	            boolean allocated = false;
	            for (int j = 0; j < k; j++) {
	                if (a[j] >= p[i] && l[j] == 0) { // Ensure partition is free
	                    l[j] = i + 1;
	                    System.out.println("Process " + (i + 1) + " (" + p[i] + " KB) ---> Partition " + (j + 1) + " (" + t[j] + " KB)");
	                    a[j] -= p[i]; // Reduce available partition size
	                    allocated = true;
	                    break;
	                }
	            }
	            if (!allocated) {
	                System.out.println("Process " + (i + 1) + " (" + p[i] + " KB) cannot be allocated");
	            }
	        }

	        sc.close();
	    }
	}

