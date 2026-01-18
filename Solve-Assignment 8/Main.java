import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v, w, idx;
        Edge(int u,int v,int w,int idx){this.u=u;this.v=v;this.w=w;this.idx=idx;}
        public int compareTo(Edge o){return this.w-o.w;}
    }
    static int n,m,LOG;
    static ArrayList<Edge>[] g;
    static int[][] par, mx1, mx2, depth;
    static Edge[] edges;

    static int[] p,r;
    static int find(int x){return x==p[x]?x:(p[x]=find(p[x]));}
    static boolean unite(int a,int b){
        a=find(a);b=find(b);
        if(a==b)return false;
        if(r[a]<r[b])p[a]=b; else{p[b]=a;if(r[a]==r[b])r[a]++;}
        return true;
    }
    static int[] lift(int u,int v){
        int best1=0,best2=0;
        if(depth[0][u]<depth[0][v]){int t=u;u=v;v=t;}
        for(int k=LOG-1;k>=0;k--)if(depth[0][u]-(1<<k)>=depth[0][v]){
            int w1=mx1[k][u],w2=mx2[k][u];
            int[] arr={best1,best2,w1,w2};
            Arrays.sort(arr);
            best1=arr[3];best2=arr[2];
            u=par[k][u];
        }
        if(u==v)return new int[]{best1,best2,u};
        for(int k=LOG-1;k>=0;k--)if(par[k][u]!=0&&par[k][u]!=par[k][v]){
            int[] arr={best1,best2,mx1[k][u],mx2[k][u],mx1[k][v],mx2[k][v]};
            Arrays.sort(arr);
            best1=arr[5];best2=arr[4];
            u=par[k][u];v=par[k][v];
        }
        int[] arr={best1,best2,mx1[0][u],mx1[0][v]};
        Arrays.sort(arr);
        best1=arr[3];best2=arr[2];
        return new int[]{best1,best2,par[0][u]};
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());m=Integer.parseInt(st.nextToken());
        edges=new Edge[m];
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            edges[i]=new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),i);
        }
        Arrays.sort(edges);
        p=new int[n+1];r=new int[n+1];
        for(int i=1;i<=n;i++)p[i]=i;
        g=new ArrayList[n+1];
        for(int i=1;i<=n;i++)g[i]=new ArrayList<>();
        boolean[] used=new boolean[m];
        long mst=0;int cnt=0;
        for(Edge e:edges){
            if(unite(e.u,e.v)){
                used[e.idx]=true;mst+=e.w;cnt++;
                g[e.u].add(e);g[e.v].add(e);
            }
        }
        if(cnt!=n-1){System.out.println(-1);return;}
        LOG=1;while((1<<LOG)<=n)LOG++;
        par=new int[LOG][n+1];mx1=new int[LOG][n+1];mx2=new int[LOG][n+1];depth=new int[1][n+1];
        Deque<Integer> q=new ArrayDeque<>();q.add(1);
        boolean[] vis=new boolean[n+1];vis[1]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            for(Edge e:g[u]){
                int v=(e.u==u?e.v:e.u);
                if(!vis[v]){
                    vis[v]=true;depth[0][v]=depth[0][u]+1;
                    par[0][v]=u;mx1[0][v]=e.w;mx2[0][v]=0;
                    q.add(v);
                }
            }
        }
        for(int k=1;k<LOG;k++)for(int v=1;v<=n;v++){
            if(par[k-1][v]!=0){
                par[k][v]=par[k-1][par[k-1][v]];
                int[] arr={mx1[k-1][v],mx2[k-1][v],mx1[k-1][par[k-1][v]],mx2[k-1][par[k-1][v]]};
                Arrays.sort(arr);
                mx1[k][v]=arr[3];mx2[k][v]=arr[2];
            }
        }
        long ans=Long.MAX_VALUE;
        for(Edge e:edges)if(!used[e.idx]){
            int[] up=lift(e.u,e.v);
            int max1=up[0],max2=up[1];
            long cost=mst+(e.w>max1?e.w-max1:(max2==0?Long.MAX_VALUE:e.w-max2));
            if(cost>mst)ans=Math.min(ans,cost);
        }
        System.out.println(ans==Long.MAX_VALUE?-1:ans);
    }
}
