import java.util.*;
public class BFSTraversal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt();
        ArrayList<Integer>[] adj = new ArrayList[N+1];
        for (int i = 0; i <= N; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt(), v = sc.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> bfs = new ArrayList<>();
        q.add(1);
        visited[1] = true;
        while (!q.isEmpty()) {
            int u = q.poll();
            bfs.add(u);
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
        for (int i = 0; i < bfs.size(); i++) {
            System.out.print(bfs.get(i));
            if (i != bfs.size() - 1) System.out.print(" ");
        }
    }
}
