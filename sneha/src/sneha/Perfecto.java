package sneha;
import java.util.*;
public class Perfecto {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int k=sc.nextInt();
			if(k==1)
			{
				System.out.println("-1");
				continue;
			}
			int p[]=new int[k];
			if (k % 2 == 0) {
                for (int i = 0; i < k; i += 2) {
                    p[i] = i + 2;
                    p[i + 1] = i + 1;
                }
            } 
			else {
            	for (int i = 0; i < k - 3; i += 2) {
                    p[i] = i + 2;
                    p[i + 1] = i + 1;
                
            }
			p[k - 3] = k;
            p[k - 2] = k - 2;
            p[k - 1] = k - 1;
			}
			for(int v:p)
			{
				System.out.print(v+" ");
			}
			System.out.println();
		}
	}
}
