// C. Triple The Trouble

import java.util.Scanner;
import java.util.Arrays;

public class threesum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long x = sc.nextLong();
        
        long[] arr = new long[n];
        int[] idx = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
            idx[i] = i + 1;
        }
        
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    long temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    
                    int tempIdx = idx[i];
                    idx[i] = idx[j];
                    idx[j] = tempIdx;
                }
            }
        }
        
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                long sum = arr[i] + arr[left] + arr[right];
                if (sum == x) {
                    System.out.println(idx[i] + " " + idx[left] + " " + idx[right]);
                    return;
                } else if (sum < x) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        System.out.println(-1);
    }
}
