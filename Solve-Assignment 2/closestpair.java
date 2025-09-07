// B. Two sum revisited

import java.util.Scanner;

public class closestpair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long k = sc.nextLong();
        
        long[] a = new long[n];
        long[] b = new long[m];
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextLong();
        }
        
        int i = 0;
        int j = m - 1;
        long minDiff = Long.MAX_VALUE;
        int ansI = 1;
        int ansJ = 1;
        
        while (i < n && j >= 0) {
            long sum = a[i] + b[j];
            long diff = sum - k;
            if (diff < 0) diff = -diff;
            
            if (diff < minDiff) {
                minDiff = diff;
                ansI = i + 1;
                ansJ = j + 1;
            }
            if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        
        System.out.println(ansI + " " + ansJ);
    }
}
