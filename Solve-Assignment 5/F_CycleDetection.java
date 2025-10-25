import java.util.*;
public class F_CycleDetection{
    static ArrayList<Integer>[] g;
    static int[] vis;
    static boolean hasCycle;

    static void dfs(int u){
        vis[u]=1;
        for(int i=0;i<g[u].size();i++){
            int v=g[u].get(i);
            if(vis[v]==0) dfs(v);
            else if(vis[v]==1) hasCycle=true;
        }
        vis[u]=2;
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int N=sc.nextInt(), M=sc.nextInt();
        g=new ArrayList[N+1]; vis=new int[N+1];
        for(int i=1;i<=N;i++) g[i]=new ArrayList<>();
        for(int i=0;i<M;i++){
            int u=sc.nextInt(), v=sc.nextInt();
            g[u].add(v);
        }
        hasCycle=false;
        for(int i=1;i<=N;i++) if(vis[i]==0) dfs(i);
        System.out.println(hasCycle?"YES":"NO");
    }
}
