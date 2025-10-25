import java.io.*;
import java.util.*;
public class E_EasyTreeQueries{
    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] parts=br.readLine().split(" ");
        int N=Integer.parseInt(parts[0]), R=Integer.parseInt(parts[1]);
        ArrayList<Integer>[] g=new ArrayList[N+1];
        int[] sub=new int[N+1];
        for(int i=1;i<=N;i++) g[i]=new ArrayList<>();
        for(int i=0;i<N-1;i++){
            String[] e=br.readLine().split(" ");
            int u=Integer.parseInt(e[0]), v=Integer.parseInt(e[1]);
            g[u].add(v); g[v].add(u);
        }

        Stack<Integer> st=new Stack<>();
        boolean[] vis=new boolean[N+1];
        st.push(R);
        int[] parent=new int[N+1];
        Arrays.fill(parent,-1);
        while(!st.isEmpty()){
            int u=st.peek();
            if(!vis[u]){
                vis[u]=true;
                for(int i=0;i<g[u].size();i++){
                    int v=g[u].get(i);
                    if(!vis[v]){ st.push(v); parent[v]=u; }
                }
            }else{
                st.pop();
                sub[u]=1;
                for(int i=0;i<g[u].size();i++){
                    int v=g[u].get(i);
                    if(v!=parent[u]) sub[u]+=sub[v];
                }
            }
        }

        int Q=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<Q;i++) sb.append(sub[Integer.parseInt(br.readLine())]).append("\n");
        System.out.print(sb);
    }
}
