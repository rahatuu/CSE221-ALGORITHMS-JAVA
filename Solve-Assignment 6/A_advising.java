import java.io.*;
import java.util.*;
public class advising {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()), m=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] g=new ArrayList[n+1];
        for(int i=0;i<=n;i++){ g[i]=new ArrayList<>();}
        int[] indeg=new int[n+1];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()), b=Integer.parseInt(st.nextToken());
            g[a].add(b); indeg[b]++; }
        Queue<Integer> q=new LinkedList<>();
        for(int i=1;i<=n;i++){ if(indeg[i]==0){ q.add(i);}}
        int count=0;
        StringBuilder sb=new StringBuilder();
        while(!q.isEmpty()){
            int u=q.poll();
            sb.append(u).append(" ");
            count++;
            for(int j=0;j<g[u].size();j++){
                int v=g[u].get(j);
                if(--indeg[v]==0) q.add(v);}}
        if(count<n){ System.out.println(-1);}
        else{ System.out.println(sb.toString());}
    }
}