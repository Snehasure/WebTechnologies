package sneha;
import java.util.*;
public class Play {
	

	    public static void main(String args[])
	    {
	        Scanner sc=new Scanner(System.in);
	        int t=sc.nextInt();
	        while(t-->0)
	        {
	            long k=sc.nextLong();
	            System.out.println((k%3==1)?"YES":"NO");
	        }
	    }
	}

