import java.io.*;
import java.util.*;
public class FriendCircleSize {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] parent = new int[N + 1], size = new int[N + 1];
        for (int i = 1; i <= N; i++) { parent[i] = i; size[i] = 1; }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
            int x = a;
            while (parent[x] != x) {
                parent[x] = parent[parent[x]]; x = parent[x];
            }
            int px = x;
            int y = b;
            while (parent[y] != y) {
                parent[y] = parent[parent[y]]; y = parent[y];
            }
            int py = y;
            int ans;
            if (px == py) ans = size[px];
            else {
                if (size[px] < size[py]) {
                    parent[px] = py; size[py] += size[px]; ans = size[py];
                } else {
                    parent[py] = px; size[px] += size[py]; ans = size[px];
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb);
    }
}
