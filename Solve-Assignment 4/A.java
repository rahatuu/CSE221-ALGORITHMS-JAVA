import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] matrix = new int[N][N];
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            matrix[u-1][v-1] = w; }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N-1) {
                    System.out.print(matrix[i][j]+" ");}
                else { 
                    System.out.print(matrix[i][j]);}
            }
            System.out.println();
        }
    }
}