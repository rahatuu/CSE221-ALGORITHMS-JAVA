E. Reverse Sorting

import java.util.Scanner;
import java.util.Arrays;

public class reversesorting{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];
        int[] sortedArr = new int[N];
        
        for (int i = 0; i < N; i++) {
            arr[i] = input.nextInt();
            sortedArr[i] = arr[i];
        }
        
        Arrays.sort(sortedArr);
        
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < N - i - 2; j++) {
                if (arr[j] > arr[j + 2]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }
        
        boolean isSame = true;
        for (int i = 0; i < N; i++) {
            if (arr[i] != sortedArr[i]) {
                isSame = false;
                break;
            }
        }
        
        if (isSame) {
            System.out.println("Yes");
        } else {
            System.out.println("NO");
        }
    }
}
