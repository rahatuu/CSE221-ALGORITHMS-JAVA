import java.io.*;
import java.util.*;
import java.util.Scanner;
 
public class Assignment3 {

// Problem A
public static class CountTheInversion {
    static long inversionCount;
    public static int[] divideAndConquer(int[] array) {
        int length = array.length;
        if (length <= 1) return array;
        int mid = length / 2;
        int[] left = divideAndConquer(Arrays.copyOfRange(array, 0, mid));
        int[] right = divideAndConquer(Arrays.copyOfRange(array, mid, length));
        int i = 0, j = 0, k = 0;
        int leftLen = left.length, rightLen = right.length;
        int[] merged = new int[leftLen + rightLen];
        while (i < leftLen && j < rightLen) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                merged[k++] = right[j++];
                inversionCount += leftLen - i;
            }
        }
        while (i < leftLen) merged[k++] = left[i++];
        while (j < rightLen) merged[k++] = right[j++];
        return merged;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int n = Integer.parseInt(reader.readLine());
        int[] inputArray = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int idx = 0; idx < n; idx++) {
            inputArray[idx] = Integer.parseInt(tokenizer.nextToken());
        }
        int[] sortedArray = divideAndConquer(inputArray);
        writer.println(inversionCount);
        for (int val : sortedArray) writer.print(val + " ");
        writer.println();
        writer.flush();
    }
}

// Problem B
public static class CountTheInversionRevisited {
    static long count(int[] a, int l, int r) {
        if (l >= r) return 0;
        int m = (l + r) / 2;
        long ans = count(a, l, m) + count(a, m + 1, r);

        long[] sq = new long[r - m];
        for (int i = m + 1; i <= r; i++) sq[i - m - 1] = (long) a[i] * a[i];
        java.util.Arrays.sort(sq);

        for (int i = l; i <= m; i++) {
            int lo = 0, hi = sq.length;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (sq[mid] < a[i]) lo = mid + 1; 
                else hi = mid;
            }
            ans += lo;
        }

        int[] tmp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r) tmp[k++] = a[i] <= a[j] ? a[i++] : a[j++];
        while (i <= m) tmp[k++] = a[i++];
        while (j <= r) tmp[k++] = a[j++];
        for (i = 0; i < tmp.length; i++) a[l + i] = tmp[i];

        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println(count(a, 0, n - 1));
    }
}

// Problem C
public static class FastPowerDrift {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        long mod = 107;
        long res = 1;
        a %= mod;
        while (b > 0) {
            if (b % 2 == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            b /= 2;
        }
        System.out.println(res);
    }
}

// Problem D
public static class FastMatrixDrift {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] p = br.readLine().split(" ");
            int[] A = new int[4];
            for (int i = 0; i < 4; i++) A[i] = Integer.parseInt(p[i]);
            long X = Long.parseLong(br.readLine());
            int[] R = {1, 0, 0, 1};
            while (X > 0) {
                if ((X & 1) == 1) {
                    int[] C = new int[4];
                    C[0] = (int)(((long)R[0]*A[0] + (long)R[1]*A[2]) % MOD);
                    C[1] = (int)(((long)R[0]*A[1] + (long)R[1]*A[3]) % MOD);
                    C[2] = (int)(((long)R[2]*A[0] + (long)R[3]*A[2]) % MOD);
                    C[3] = (int)(((long)R[2]*A[1] + (long)R[3]*A[3]) % MOD);
                    R = C;
                }
                int[] B = new int[4];
                B[0] = (int)(((long)A[0]*A[0] + (long)A[1]*A[2]) % MOD);
                B[1] = (int)(((long)A[0]*A[1] + (long)A[1]*A[3]) % MOD);
                B[2] = (int)(((long)A[2]*A[0] + (long)A[3]*A[2]) % MOD);
                B[3] = (int)(((long)A[2]*A[1] + (long)A[3]*A[3]) % MOD);
                A = B;
                X >>= 1;
            }
            System.out.println(R[0] + " " + R[1]);
            System.out.println(R[2] + " " + R[3]);
        }
    }
}

// Problem E
public static class FastSeriesDrift {
    static long[] calc(long a, long n, long m) {
        if (n == 1) return new long[]{a % m, a % m};
        long[] half = calc(a, n / 2, m);
        long power = (half[0] * half[0]) % m;
        long sum = (half[1] + half[0] * half[1]) % m;
        if (n % 2 == 1) {
            power = (power * a) % m;
            sum = (sum + power) % m;
        }
        return new long[]{power, sum};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            String[] p = br.readLine().split(" ");
            long a = Long.parseLong(p[0]);
            long n = Long.parseLong(p[1]);
            long m = Long.parseLong(p[2]);
            if (a == 1) System.out.println(n % m);
            else System.out.println(calc(a, n, m)[1]);
        }
    }
}

// Problem F
public static class OrderingBinaryTree {
    static void buildOrder(int[] arr, int start, int end, StringBuilder sb) {
        if (start > end) return;
        int mid = (start + end) / 2;
        sb.append(arr[mid]).append(" ");
        buildOrder(arr, start, mid - 1, sb);
        buildOrder(arr, mid + 1, end, sb);
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        buildOrder(arr, 0, n-1, sb);
        System.out.println(sb.toString().trim());
        sc.close();
    }
}

// Problem G
public static class BinaryTreePostorder {
    static int[] inorder, preorder, postorder;
    static int preIndex = 0, postIndex = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        inorder = new int[n];
        preorder = new int[n];
        postorder = new int[n];
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();}
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();}
        buildPostorder(0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(postorder[i] + " ");}}
    public static void buildPostorder(int inStart, int inEnd) {
        if (inStart > inEnd) {
            return;}
        int root = preorder[preIndex];
        preIndex++;
        int inIndex = inStart;
        for (; inIndex <= inEnd; inIndex++) {
            if (inorder[inIndex] == root) {
                break;}}
        buildPostorder(inStart, inIndex - 1);
        buildPostorder(inIndex + 1, inEnd);

        postorder[postIndex] = root;
        postIndex++;
    }
}

// Problem H
public static class TreesReassessed {
    static int[] in, post, pre;
    static int preIndex;

    static void build(int inL, int inR, int postL, int postR) {
        if (inL > inR) return;
        int root = post[postR];
        pre[preIndex++] = root;
        int rootPos = -1;
        for (int i = inL; i <= inR; i++) {
            if (in[i] == root) {
                rootPos = i;
                break;
            }
        }
        int leftSize = rootPos - inL;
        build(inL, rootPos - 1, postL, postL + leftSize - 1);
        build(rootPos + 1, inR, postL + leftSize, postR - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        in = new int[n];
        post = new int[n];
        pre = new int[n];
        preIndex = 0;
        String[] inStr = br.readLine().split(" ");
        String[] postStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) in[i] = Integer.parseInt(inStr[i]);
        for (int i = 0; i < n; i++) post[i] = Integer.parseInt(postStr[i]);
        build(0, n - 1, 0, n - 1);
        for (int i = 0; i < n; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(pre[i]);
        }
    }
}
}
