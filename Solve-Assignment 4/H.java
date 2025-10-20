import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),q=sc.nextInt();
        ArrayList<Integer>[] g=new ArrayList[n+1];
        for(int i=1;i<=n;i++)g[i]=new ArrayList<>();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i!=j&&gcd(i,j)==1)g[i].add(j);}}
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<q;i++){
            int x=sc.nextInt(),k=sc.nextInt();
            if(k>g[x].size())sb.append("-1\n");
            else sb.append(g[x].get(k-1)).append("\n");}
        System.out.print(sb);
        sc.close();}
    static int gcd(int a,int b){
        while(b!=0){
            int t=a%b;
            a=b;
            b=t;
        }
        return a;
    }
}