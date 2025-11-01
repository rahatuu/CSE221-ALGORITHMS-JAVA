import java.io.*;
import java.util.*;
public class MinimaxDanger {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken()),m=Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] g=new ArrayList[n+1];
        for(int i=1;i<=n;i++) g[i]=new ArrayList<int[]>();
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken()),b=Integer.parseInt(st.nextToken()),w=Integer.parseInt(st.nextToken());
            g[a].add(new int[]{b,w});
            g[b].add(new int[]{a,w});}
        int[] danger=new int[n+1];
        for(int i=1;i<=n;i++) danger[i]=Integer.MAX_VALUE;
        danger[1]=0;
        PriorityQueue<int[]> pq=new PriorityQueue<int[]>(new Comparator<int[]>(){public int compare(int[]a,int[]b){return a[1]-b[1];}});
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] cur=pq.poll(); int u=cur[0],maxD=cur[1];
            if(maxD>danger[u]) continue;
            for(int i=0;i<g[u].size();i++){
                int[] e=g[u].get(i); int v=e[0],w=e[1];
                int pathD=Math.max(danger[u],w);
                if(pathD<danger[v]){
                    danger[v]=pathD;
                    pq.add(new int[]{v,pathD}); }}}
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(danger[i]==Integer.MAX_VALUE?-1:danger[i]);
            if(i<n) sb.append(" ");}
        System.out.println(sb.toString());}}
