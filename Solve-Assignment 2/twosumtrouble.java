// A. Two sum trouble //
import java.io.*;
import java.util.*;

public class twosumtrouble {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int i = 0;
        int j = n - 1;
        boolean found = false;
        
        while (i < j) {
            long sum = (long) arr[i] + arr[j];
            if (sum == target) {
                pw.println((i + 1) + " " + (j + 1));
                pw.flush();
                found = true;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        
        if (!found) {
            pw.println(-1);
            pw.flush();
        }
    }
}
