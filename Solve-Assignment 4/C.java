import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[][] list = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] parts = sc.nextLine().split(" ");
            int k = Integer.parseInt(parts[0]);
            for (int j = 1; j <= k; j++) {
                int dest = Integer.parseInt(parts[j]);
                list[i][dest] = 1;  } }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (j < N - 1) {
                    System.out.print(list[i][j]+" "); } 
                else{
                    System.out.print(list[i][j]);} }
            System.out.println(); }
    }
}