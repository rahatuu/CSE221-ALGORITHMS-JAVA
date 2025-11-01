import java.io.*;
import java.util.*;
public class NodeWeightPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] w = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            w[i] = Integer.parseInt(st.nextToken());}
        ArrayList<Integer>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<Integer>();}
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            g[u].add(v);}
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];} });
        dist[s] = w[s];
        pq.add(new int[]{s, dist[s]});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], cost = cur[1];
            if (cost > dist[u]) continue;
            for (int i = 0; i < g[u].size(); i++) {
                int v = g[u].get(i);
                if (dist[v] > dist[u] + w[v]) {
                    dist[v] = dist[u] + w[v];
                    pq.add(new int[]{v, dist[v]}); }}}
        int ans = dist[d];
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);  }}
