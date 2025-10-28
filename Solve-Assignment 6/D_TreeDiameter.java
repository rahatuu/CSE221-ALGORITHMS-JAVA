import java.io.*;
import java.util.*;
public class TreeDiameter{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] g=new ArrayList[N+1];
        for(int i=0;i<=N;i++) g[i]=new ArrayList<>();
        for(int i=0;i<N-1;i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            g[u].add(v); g[v].add(u);}
        int[] dist=new int[N+1];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<=N;i++) dist[i]=-1;
        q.add(1); dist[1]=0; int far1=1;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int j=0;j<g[u].size();j++){
                int v=g[u].get(j);
                if(dist[v]==-1){
                    dist[v]=dist[u]+1; q.add(v);
                    if(dist[v]>dist[far1]) far1=v;}}}
        for(int i=0;i<=N;i++) dist[i]=-1;
        q.add(far1); dist[far1]=0; int far2=far1;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int j=0;j<g[u].size();j++){
                int v=g[u].get(j);
                if(dist[v]==-1){
                    dist[v]=dist[u]+1; q.add(v);
                    if(dist[v]>dist[far2]) far2=v;}}}
        System.out.println(dist[far2]);
        System.out.println(far1+" "+far2); }}