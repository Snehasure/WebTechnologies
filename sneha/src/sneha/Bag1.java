package sneha;
import java.util.*;

public class Bag1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = sc.nextInt();
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

        List<Integer> keys = new ArrayList<>(freq.keySet()); // Store keys separately to avoid modification error

        for (int num : keys) {
            int count = freq.get(num);
            
            while (count > 1) { // If a number appears more than once, increment and move it
                count--;
                freq.put(num, count); // Update original count
                num++; 
                freq.put(num, freq.getOrDefault(num, 0) + 1);
            }
        }

        return freq.size() == n / 2; // Both bags should have exactly n/2 unique elements
    }
}

