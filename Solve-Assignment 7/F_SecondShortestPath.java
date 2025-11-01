import java.io.*;
import java.util.*;
public class SecondShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
        ArrayList<int[]>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), w = Integer.parseInt(st.nextToken());
            g[a].add(new int[]{b, w});
            g[b].add(new int[]{a, w});}
        int[][] dist = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = dist[i][1] = Integer.MAX_VALUE;}
        dist[S][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) { return a[1] - b[1]; } });
        pq.add(new int[]{S, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], dcur = cur[1];
            for (int j = 0; j < g[u].size(); j++) {
                int[] e = g[u].get(j);
                int v = e[0], w = e[1], newDist = dcur + w;
                if (newDist < dist[v][0]) {
                    dist[v][1] = dist[v][0];
                    dist[v][0] = newDist;
                    pq.add(new int[]{v, newDist});
                } else if (dist[v][0] < newDist && newDist < dist[v][1]) {
                    dist[v][1] = newDist;
                    pq.add(new int[]{v, newDist});}}}
        int ans = dist[D][1];
        if (ans == Integer.MAX_VALUE){ 
            ans = -1;}
        System.out.println(ans); }}
