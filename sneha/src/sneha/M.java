package sneha;
import java.util.*;
public class M {
	


	public class Main {
	    public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	                int t = sc.nextInt();  
	                String s = "01032025";  
	                while (t-- > 0) {
	                    int n = sc.nextInt();
	                    int[] digits = new int[n];
	                    for (int i = 0; i < n; i++) {
	                        digits[i] = sc.nextInt();
	                    }
	                    int index = 0;  
	                    for (int i = 0; i < n; i++) {
	                        if (digits[i] == s.charAt(index) - '0') {
	                            index++;
	                        }
	                        if (index == s.length()) {
	                           
	                            System.out.println(i + 1);  
	                            break;
	                        }
	                    }
	                    if (index < s.length()) {
	                        System.out.println(0);  
	                    }
	                }
	                sc.close();
	            }
	}

}
