package sneha;

import java.util.Scanner;

public class Arraysum {
	public static void msin(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
		int n=sc.nextInt();
		int k=sc.nextInt();
		int p=sc.nextInt();
		int maxs=n*p;
		int mins=n*(-p);
		if(k<mins||k>maxs)
		{
			System.out.println(-1);
			continue;
		}
		int absk=Math.abs(k);
		int c=0;
		while(absk>0)
		{
			if(absk>=p)
			{
				absk-=p;
				c++;
			}
			else
			{
				absk=0;
				c++;
			}
		}
		System.out.println(c);
		}
	}
}
