//F. Longest K-Distinct Subarray

import java.io.*;
import java.util.*;

public class kdistinctsubarray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] a = new int[n];
        int[] freq = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());}
        int left = 0;
        int right = 0;
        int distinct = 0;
        int max = 0;
        while (right < n) {
            if (freq[a[right]] == 0) {
                distinct++;}
            freq[a[right]]++;
            while (distinct > k) {
                freq[a[left]]--;
                if (freq[a[left]] == 0) {
                    distinct--;}
                left++;}
            int len = right - left + 1;
            if (len > max) {
                max = len;}
            right++;}
        out.println(max);
        out.flush();
    }
}
