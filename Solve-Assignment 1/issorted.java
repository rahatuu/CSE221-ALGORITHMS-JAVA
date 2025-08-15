D. Is Sorted?

import java.util.Scanner;
public class Main {
    public static void issorted(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int length = scanner.nextInt();
            int[] A = new int[length];
            for (int i = 0; i < length; i++) {
                A[i] = scanner.nextInt();}
            boolean sorted = true;
            for (int i = 0; i < length - 1; i++) {
                if (A[i] > A[i + 1]) {
                    sorted = false;
                    break;}}
            if (sorted==true) {
                System.out.println("YES");}
            else {
                System.out.println("NO");}
        }
    }
}
