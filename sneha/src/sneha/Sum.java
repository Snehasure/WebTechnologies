package sneha;
import java.util.*;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 

        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            System.out.println(Max(a));
        }
        sc.close();
    }

    static int Max(int[] a) {
        Arrays.sort(a); 
        int g = 0;

        for (int i = 1; i < a.length; i++) {
            g = gcd(g, a[i] - a[i - 1]); 
        }

        return g;
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b); 
    }
}
