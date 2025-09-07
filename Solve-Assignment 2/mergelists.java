// D. A Beautiful Sorted List

import java.io.*;
import java.util.StringTokenizer;

public class mergelists {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;
        
        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }
        
        while (i < n) {
            merged[k++] = a[i++];
        }
        
        while (j < m) {
            merged[k++] = b[j++];
        }
        
        for (int x = 0; x < n + m; x++) {
            pw.print(merged[x]);
            pw.print(' ');
        }
        pw.flush();
    }
}
