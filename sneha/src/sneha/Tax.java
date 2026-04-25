package sneha;


import java.util.*;


public class Tax {
	public static void main(String args[]) {
	Scanner sc=new Scanner(System.in);
	int t=sc.nextInt();
	while(t-- >0)
	{
		int n=sc.nextInt();
		int m=sc.nextInt();
	int a[]=new int[n];
	for(int i=0;i<n;i++)
	{
		a[i]=sc.nextInt();
	}
	int b=sc.nextInt();
	

	for(int i=0;i<n;i++)
	{
		a[i]=Math.min(a[i],b-a[i]);
	}

	boolean x=true;
	for(int i=1;i<n;i++)
	{
		if(a[i]<a[i-1])
		{
			x=false;
			break;
		}
	}
	System.out.println(x?"YES":"NO");
	
	
	}
	sc.close();
	}
}