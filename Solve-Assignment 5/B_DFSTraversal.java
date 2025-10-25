import java.io.*;
import java.util.*;
public class DFSTraversal {
    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] parts=br.readLine().split(" ");
        int N=Integer.parseInt(parts[0]);
        int M=Integer.parseInt(parts[1]);
        ArrayList<Integer>[] adj=new ArrayList[N+1];
        for(int i=0;i<=N;i++) adj[i]=new ArrayList<>();
        String[] uLine=br.readLine().split(" ");
        String[] vLine=br.readLine().split(" ");
        for(int i=0;i<M;i++){
            int u=Integer.parseInt(uLine[i]);
            int v=Integer.parseInt(vLine[i]);
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] vis=new boolean[N+1];
        Stack<Integer> s=new Stack<>();
        s.push(1);

        ArrayList<Integer> output=new ArrayList<>();
        while(!s.isEmpty()){
            int u=s.pop();
            if(vis[u]) continue;
            vis[u]=true;
            output.add(u);
            for(int i=adj[u].size()-1;i>=0;i--){
                int v=adj[u].get(i);
                if(!vis[v]) s.push(v);
            }
        }

        for(int i=0;i<output.size();i++){
            System.out.print(output.get(i));
            if(i!=output.size()-1) System.out.print(" ");
        }
    }
}
