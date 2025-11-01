import java.util.*;
import java.io.*;

public class ShortestPathDijkstra {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] g = new ArrayList[n+1];
        for (int i=1; i<=n; i++) g[i] = new ArrayList<int[]>();
        int[] u = new int[m], v = new int[m], w = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) u[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) v[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) w[i] = Integer.parseInt(st.nextToken());
        for (int i=0; i<m; i++) g[u[i]].add(new int[]{v[i],w[i]});

        int[] dist = new int[n+1], prev = new int[n+1];
        boolean[] vis = new boolean[n+1];
        for (int i=1; i<=n; i++) { dist[i]=Integer.MAX_VALUE; prev[i]=0; }
        dist[s]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{s,0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], dcur = cur[1];
            if (dcur > dist[node] || vis[node]) continue;
            vis[node] = true;
            for (int i=0; i<g[node].size(); i++) {
                int[] e = g[node].get(i);
                if (dist[e[0]] > dist[node] + e[1]) {
                    dist[e[0]] = dist[node] + e[1];
                    prev[e[0]] = node;
                    pq.add(new int[]{e[0], dist[e[0]]});
                }
            }
        }
        if (dist[d]==Integer.MAX_VALUE) { 
            System.out.println(-1);
        } else {
            System.out.println(dist[d]);
            ArrayList<Integer> path = new ArrayList<Integer>();
            for (int at=d; at!=0; at=prev[at]) path.add(at);
            for (int i=path.size()-1; i>=0; i--) {
                System.out.print(path.get(i));
                if (i>0) System.out.print(" ");
            }
            System.out.println();
        }
    }
}
