import java.io.*;
import java.util.*;
public class ParityShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] u = new int[m], v = new int[m], w = new int[m];
        st = new StringTokenizer(br.readLine()); 
        for (int i = 0; i < m; i++) u[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) v[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) w[i] = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        for (int i = 0; i < m; i++)
            g[u[i]].add(new int[]{v[i], w[i]});

        int[][] dist = new int[n + 1][2]; // dist[node][parity]
        for (int i = 1; i <= n; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        dist[1][0] = 0; dist[1][1] = 0;
        pq.add(new int[]{1, -1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int uNode = cur[0], prevParity = cur[1], d = cur[2];
            for (int[] e : g[uNode]) {
                int vNode = e[0], eWeight = e[1], parity = eWeight % 2;
                if (prevParity == -1 || prevParity != parity) {
                    if (dist[vNode][parity] > d + eWeight) {
                        dist[vNode][parity] = d + eWeight;
                        pq.add(new int[]{vNode, parity, dist[vNode][parity]});}}}}
        int ans = Math.min(dist[n][0], dist[n][1]);
        System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
