import java.io.*;
import java.util.*;
public class ShortestLexBFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int N = Integer.parseInt(first[0]);
        int M = Integer.parseInt(first[1]);
        int S = Integer.parseInt(first[2]);
        int D = Integer.parseInt(first[3]);

        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for(int i=0;i<=N;i++) adj[i]=new ArrayList<>();

        String[] uLine = br.readLine().split(" ");
        String[] vLine = br.readLine().split(" ");
        int[] u=new int[M], v=new int[M];
        for(int i=0;i<M;i++){
            u[i]=Integer.parseInt(uLine[i]);
            v[i]=Integer.parseInt(vLine[i]);
            adj[u[i]].add(v[i]);
            adj[v[i]].add(u[i]);
        }

        for(int i=1;i<=N;i++) Collections.sort(adj[i]);

        int[] dist = new int[N+1];
        int[] parent = new int[N+1];
        Arrays.fill(dist,-1);
        Queue<Integer> q = new LinkedList<>();
        dist[S]=0; parent[S]=-1; q.add(S);

        while(!q.isEmpty()){
            int uNode=q.poll();
            for(int i=0;i<adj[uNode].size();i++){
                int nbr=adj[uNode].get(i);
                if(dist[nbr]==-1){
                    dist[nbr]=dist[uNode]+1;
                    parent[nbr]=uNode;
                    q.add(nbr);
                }
            }
        }

        if(dist[D]==-1){
            System.out.println(-1);
            return;
        }

        System.out.println(dist[D]);
        Stack<Integer> path=new Stack<>();
        int curr=D;
        while(curr!=-1){
            path.push(curr);
            curr=parent[curr];
        }
        while(!path.isEmpty()) System.out.print(path.pop()+" ");
    }
}
