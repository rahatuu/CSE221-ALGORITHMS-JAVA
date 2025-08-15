H. Trains?

import java.util.Scanner;

public class trains {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); sc.nextLine();
        String[] name = new String[n];
        String[] dest = new String[n];
        int[] time = new int[n];
        int[] idx = new int[n];
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] p = line.split(" ");
            name[i] = p[0];
            dest[i] = p[4];
            int h = Integer.parseInt(p[6].substring(0, 2));
            int m = Integer.parseInt(p[6].substring(3));
            time[i] = h * 60 + m;
            idx[i] = i;
        }
        
        for (int i = 0; i < n - 1; i++) {
            int best = i;
            for (int j = i + 1; j < n; j++) {
                int c = name[j].compareTo(name[best]);
                if (c < 0 || (c == 0 && (time[j] > time[best] || (time[j] == time[best] && idx[j] < idx[best])))) {
                    best = j;
                }
            }
            if (best != i) {
                String tName = name[i]; name[i] = name[best]; name[best] = tName;
                String tDest = dest[i]; dest[i] = dest[best]; dest[best] = tDest;
                int tTime = time[i]; time[i] = time[best]; time[best] = tTime;
                int tIdx = idx[i]; idx[i] = idx[best]; idx[best] = tIdx;
            }
        }
        
        for (int i = 0; i < n; i++) {
            int h = time[i] / 60, m = time[i] % 60;
            System.out.printf("%s will departure for %s at %02d:%02d\n", name[i], dest[i], h, m);
        }
    }
}
