G. Sorting Again??

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class againsorting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] idStr = br.readLine().split(" ");
        String[] markStr = br.readLine().split(" ");
        
        int[] id = new int[n];
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) id[i] = Integer.parseInt(idStr[i]);
        for (int i = 0; i < n; i++) mark[i] = Integer.parseInt(markStr[i]);
        
        int swaps = 0;
        
        for (int i = 0; i < n - 1; i++) {
            int best = i;
            for (int j = i + 1; j < n; j++) {
                if (mark[j] > mark[best] || (mark[j] == mark[best] && id[j] < id[best])) {
                    best = j;}}
                    
            if (best != i) {
                int tempMark = mark[i];
                mark[i] = mark[best];
                mark[best] = tempMark;
                int tempId = id[i];
                id[i] = id[best];
                id[best] = tempId;
                swaps++;}}
                
        System.out.println("Minimum swaps: " + swaps);
        for (int i = 0; i < n; i++) {
            System.out.println("ID: " + id[i] + " Mark: " + mark[i]);
        }
    }
}
