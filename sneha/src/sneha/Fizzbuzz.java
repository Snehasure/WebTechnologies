package sneha;



import java.util.*;
public class Main{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int[] v={0,1,2};
        StringBuilder s=new StringBuilder();
        while(t-->0)
        {
            int n=sc.nextInt();
            int c=n/15;
            int count=c*3;
            int r=n%15;
            for(int i:v)
            {
                if(i<=r)
                {
                    count++;
                }
            }
            s.append(count).append("\n");
        }
        System.out.print(s.toString());
        
    }
}


