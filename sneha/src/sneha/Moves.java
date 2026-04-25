package sneha;
import java.util.*;
public class Moves {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		
		while(t-->0) {
		int n=sc.nextInt();
		sc.nextLine();
		String s=sc.nextLine();
		
		int f=-1,l=-1;
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)=='1')
			{
				if(f==-1)
				{
					f=i;
				}
				l=i;
			}
		}
		if(f==-1)
		{
			System.out.println(0);
			continue;
		}
		int m=0;
		for(int i=f;i<=l;i++)
		{
			if(s.charAt(i)=='0')
			{
				m++;
			}
		}
		System.out.println(m);
		
		}
	}
}
