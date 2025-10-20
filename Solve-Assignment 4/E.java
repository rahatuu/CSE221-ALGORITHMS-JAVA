import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int[] indeg=new int[n+1];
        int[] outdeg=new int[n+1];
        st=new StringTokenizer(br.readLine());
        int[] u=new int[m];
        for(int i=0;i<m;i++){
            u[i]=Integer.parseInt(st.nextToken());}
        st=new StringTokenizer(br.readLine());
        int[] v=new int[m];
        for(int i=0;i<m;i++){
            v[i]=Integer.parseInt(st.nextToken());}
        for(int i=0;i<m;i++){
            outdeg[u[i]]++;indeg[v[i]]++;}
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(indeg[i]-outdeg[i]).append(" ");}
        System.out.print(sb.toString().trim());
    }
}