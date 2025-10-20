import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] u = new int[M];
        int[] v = new int[M];
        int[] w = new int[M];
        for (int i = 0; i < M; i++) {
            u[i] = sc.nextInt();}
        for (int i = 0; i < M; i++) {
            v[i] = sc.nextInt();}
        for (int i = 0; i < M; i++) {
            w[i] = sc.nextInt();}
        String[][] adj = new String[N + 1][M];
        int[] count = new int[N + 1];
        for (int i = 0; i < M; i++) {
            adj[u[i]][count[u[i]]] = "(" + v[i] + "," + w[i] + ")";
            count[u[i]]++; }
        for (int i = 1; i <= N; i++) {
            System.out.print(i + ":");
            for (int j = 0; j < count[i]; j++) {
                System.out.print(" " + adj[i][j]);}
            System.out.println(); }
    }
}