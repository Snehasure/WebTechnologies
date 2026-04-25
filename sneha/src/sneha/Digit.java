package sneha;
import java.util.Scanner;
import java.util.*;



public class Digit {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt(); // Number of test cases

	        while (t-- > 0) {
	            int n = sc.nextInt(); // Number of elements (always even)
	            int[] a = new int[n];

	            for (int i = 0; i < n; i++) {
	                a[i] = sc.nextInt();
	            }

	            System.out.println(canMakeBagsEqual(a, n) ? "YES" : "NO");
	        }
	        sc.close();
	    }

	    public static boolean canMakeBagsEqual(int[] a, int n) {
	        Map<Integer, Integer> freq = new HashMap<>();

	        // Count frequency of each number in the first bag
	        for (int num : a) {
	            freq.put(num, freq.getOrDefault(num, 0) + 1);
	        }

	        Set<Integer> secondBag = new HashSet<>();
	        List<Integer> uniqueNumbers = new ArrayList<>(freq.keySet()); // Store unique keys

	        // Sort the numbers to process them in increasing order
	        Collections.sort(uniqueNumbers);

	        for (int num : uniqueNumbers) {
	            int count = freq.get(num);
	            
	            // Add numbers to the second bag ensuring they are unique
	            while (count > 0) {
	                while (secondBag.contains(num)) {
	                    num++; // Increase if already present
	                }
	                secondBag.add(num);
	                count--;
	            }
	        }

	        return secondBag.size() == n / 2; // Both bags should have exactly n/2 unique elements
	    }
	}


