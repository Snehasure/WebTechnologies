package sneha;
import java.util.*;
public class Bag {
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt(); 
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
	        Arrays.sort(a); 
	        Set<Integer> secondBag = new HashSet<>();

	        for (int num : a) {
	            while (secondBag.contains(num)) {
	                num++; 
	            }
	            secondBag.add(num);
	        }

	        return secondBag.size() == n / 2; 
	    }
	}


