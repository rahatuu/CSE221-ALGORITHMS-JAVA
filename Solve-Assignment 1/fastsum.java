C. Fast Sum

import java.util.Scanner;
public class fastsum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            long N = sc.nextLong();
            System.out.println(N * (N + 1) / 2);
        }
    }
}

