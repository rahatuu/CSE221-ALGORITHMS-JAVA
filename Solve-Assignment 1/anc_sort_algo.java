F. An Ancient Sorting Algorithm

import java.util.Scanner;

public class anc_sort_algo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < n - 1; i++) {
                if ((arr[i] % 2 == arr[i + 1] % 2) && arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    changed = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
}
