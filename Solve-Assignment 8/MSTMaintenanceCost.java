import java.io.*;
import java.util.*;
public class MSTMaintenanceCost {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[][] e = new int[M][3];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            e[i][0] = Integer.parseInt(st.nextToken());
            e[i][1] = Integer.parseInt(st.nextToken());
            e[i][2] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(e, (a, b) -> Integer.compare(a[2], b[2]));
        int[] p = new int[N + 1], r = new int[N + 1];
        for (int i = 1; i <= N; i++) p[i] = i;
        long total = 0; int used = 0;
        for (int i = 0; i < M; i++) {
            int u = e[i][0], v = e[i][1], w = e[i][2];
            int x = u;
            while (p[x] != x) {
                p[x] = p[p[x]]; x = p[x];
            }
            int px = x;
            int y = v;
            while (p[y] != y) {
                p[y] = p[p[y]]; y = p[y];
            }
            int py = y;
            if (px != py) {
                if (r[px] < r[py]) p[px] = py;
                else {
                    p[py] = px;
                    if (r[px] == r[py]) r[px]++;
                }
                total += w; used++;
                if (used == N - 1) break;
            }
        }
        System.out.println(total);
    }
}
