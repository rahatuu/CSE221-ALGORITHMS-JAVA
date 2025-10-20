import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] deg = new int[n + 1];
        int[] u = new int[m];
        int[] v = new int[m];
        for (int i = 0; i < m; i++) {
            u[i] = sc.nextInt(); }
        for (int i = 0; i < m; i++) {
            v[i] = sc.nextInt(); }
        for (int i = 0; i < m; i++) {
            deg[u[i]]++;
            deg[v[i]]++; }
        int odd = 0;
        for (int i = 1; i <= n; i++) {
            if (deg[i] % 2 != 0) {
                odd++;} }
        if (odd == 0 || odd == 2) {
            System.out.println("YES");}
        else {
            System.out.println("NO");}
    }
}