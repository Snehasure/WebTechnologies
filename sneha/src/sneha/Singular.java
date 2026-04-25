package sneha;
import java.util.*;

public class Singular {
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		sc.nextLine();
		for(int i=0;i<t;i++) {
		String W=sc.nextLine().toLowerCase();
		if(W.length()<=10&&W.length()>=2)
		{
			String s=W.substring(0,W.length()-2)+"i";
			System.out.println(s);
		}
		}
		sc.close();
	}

}
