package sneha;

import java.util.Scanner;

public class Ma {

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        int t = sc.nextInt();  // Number of test cases
	        String target = "01032025";  // Target date without dots

	        while (t-- > 0) {
	            int n = sc.nextInt();
	            int[] digits = new int[n];
	            for (int i = 0; i < n; i++) {
	                digits[i] = sc.nextInt();
	            }

	            int targetIndex = 0;  // Pointer for target string
	            for (int i = 0; i < n; i++) {
	                if (digits[i] == target.charAt(targetIndex) - '0') {
	                    targetIndex++;
	                }
	                if (targetIndex == target.length()) {
	                    // Found all characters of the target
	                    System.out.println(i + 1);  // Output the step (1-based index)
	                    break;
	                }
	            }
	            if (targetIndex < target.length()) {
	                System.out.println(0);  // Impossible to form the date
	            }
	        }
	        sc.close();
	    }
	}


