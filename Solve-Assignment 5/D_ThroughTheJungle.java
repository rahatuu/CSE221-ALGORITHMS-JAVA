import java.io.*;
import java.util.*;

public class D_ThroughTheJungle{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken()),s=Integer.parseInt(st.nextToken()),d=Integer.parseInt(st.nextToken()),k=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] g=new ArrayList[n+1];
        for(int i=1;i<=n;i++) g[i]=new ArrayList<>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken()),v=Integer.parseInt(st.nextToken());
            g[u].add(v);
        }
        int[] p1=new int[n+1],p2=new int[n+1];
        Arrays.fill(p1,-1);Arrays.fill(p2,-1);
        Queue<Integer> q=new ArrayDeque<>();
        boolean[] vis=new boolean[n+1];
        q.add(s);vis[s]=true;
        while(!q.isEmpty()){
            int u=q.poll();if(u==k)break;
            for(int i=0;i<g[u].size();i++){
                int v=g[u].get(i);
                if(!vis[v]){vis[v]=true;p1[v]=u;q.add(v);}
            }
        }
        if(!vis[k]){System.out.println(-1);return;}
        Arrays.fill(vis,false);q.clear();q.add(k);vis[k]=true;
        while(!q.isEmpty()){
            int u=q.poll();if(u==d)break;
            for(int i=0;i<g[u].size();i++){
                int v=g[u].get(i);
                if(!vis[v]){vis[v]=true;p2[v]=u;q.add(v);}
            }
        }
        if(!vis[d]){System.out.println(-1);return;}
        ArrayList<Integer> path=new ArrayList<>();
        for(int cur=k;cur!=-1;cur=p1[cur]) path.add(cur);
        Collections.reverse(path);
        ArrayList<Integer> tmp=new ArrayList<>();
        for(int cur=d;cur!=-1;cur=p2[cur]) tmp.add(cur);
        Collections.reverse(tmp);
        for(int i=1;i<tmp.size();i++) path.add(tmp.get(i));
        StringBuilder sb=new StringBuilder();
        sb.append(path.size()-1).append("\n");
        for(int i=0;i<path.size();i++) sb.append(path.get(i)).append(i+1<path.size()?" ":"");
        System.out.println(sb);
    }
}
