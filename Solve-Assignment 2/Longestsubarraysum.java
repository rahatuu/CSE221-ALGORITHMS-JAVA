//E. Longest Subarray Sum

import java.io.*;
import java.util.StringTokenizer;
public class Longestsubarraysum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());}
        int left = 0;
        int currentsum = 0;
        int totalnumbers = 0;
        for (int right = 0; right < n; right++) {
            currentsum += numbers[right];
            while (currentsum > k && left <= right) {
                currentsum -= numbers[left];
                left++;}
            if (right - left + 1 > totalnumbers) {
                totalnumbers = right - left + 1;}}
        out.println(totalnumbers);
        out.flush();
    }
}
