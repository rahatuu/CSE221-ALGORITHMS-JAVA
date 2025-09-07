//H. Searching is fun

import java.util.Scanner;
 
public class kthnumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        for (int i = 0; i < t; i++) {
            long k = sc.nextLong();
            long x = sc.nextLong();
            long ans = k + (k - 1) / (x - 1);
            System.out.println(ans);
        }
    }
}
