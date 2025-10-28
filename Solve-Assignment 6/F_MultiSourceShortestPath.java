import java.io.*;
import java.util.*;
public class MultiSourceShortestPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);}
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < s; i++) {
            int src = Integer.parseInt(st.nextToken());
            dist[src] = 0;
            queue.add(src);}
        int[] destinations = new int[q];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < q; i++) destinations[i] = Integer.parseInt(st.nextToken());
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int j = 0; j < graph[cur].size(); j++) {
                int next = graph[cur].get(j);
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    queue.add(next);}}}
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            sb.append(dist[destinations[i]]).append(" ");}
        System.out.println(sb.toString()); }}