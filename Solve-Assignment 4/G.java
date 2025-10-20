import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(), m=sc.nextInt(), k=sc.nextInt();
        boolean[][] board = new boolean[n+1][m+1];
        int[] xs = new int[k], ys = new int[k];
        for(int i=0; i<k; i++) {
            xs[i] = sc.nextInt();
            ys[i] = sc.nextInt();
            board[xs[i]][ys[i]] = true;
        }
        int[] dx = {2,2,1,1,-1,-1,-2,-2};
        int[] dy = {1,-1,2,-2,2,-2,1,-1};
        boolean found = false;
        for(int i=0; i<k && !found; i++) {
            for(int d=0; d<8; d++) {
                int nx = xs[i] + dx[d], ny = ys[i] + dy[d];
                if(nx >= 1 && nx <= n && ny >= 1 && ny <= m) {
                    if(board[nx][ny]) {
                        found = true;
                        break;
                    }
                }
            }
        }
        System.out.println(found ? "YES" : "NO");
    }
}