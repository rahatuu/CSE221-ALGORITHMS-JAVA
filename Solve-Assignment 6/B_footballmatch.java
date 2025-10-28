import java.util.*;
public class footballmatch{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt();
        ArrayList<Integer>[] g=new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            g[i]=new ArrayList<>();}
        for(int i=0;i<m;i++){
            int u=sc.nextInt(), v=sc.nextInt();
            g[u].add(v);
            g[v].add(u);}
        boolean[] visited=new boolean[n+1];
        int[] col=new int[n+1];
        int maxrohu=0;
        for(int i=1;i<=n;i++){
            if(!visited[i]){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                visited[i]=true;
                int[] count=new int[2];
                col[i]=0; count[0]=1;
                while(!q.isEmpty()){
                    int u=q.poll();
                    for(int j=0;j<g[u].size();j++){
                        int v=g[u].get(j);
                        if(!visited[v]){
                            col[v]=1-col[u];
                            count[col[v]]++;
                            visited[v]=true;
                            q.add(v);}}}
                maxrohu+=Math.max(count[0],count[1]); }}
        System.out.println(maxrohu);  }}