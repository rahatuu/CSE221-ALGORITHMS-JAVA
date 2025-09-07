// G. Count the Numbers

import java.io.*;
import java.util.StringTokenizer;

public class countInRange {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int queries = Integer.parseInt(st.nextToken());

        int[] numbers = new int[size];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < size; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int q = 0; q < queries; q++) {
            st = new StringTokenizer(br.readLine());
            int leftLimit = Integer.parseInt(st.nextToken());
            int rightLimit = Integer.parseInt(st.nextToken());

            int low = 0;
            int high = size - 1;
            int leftPos = size;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (numbers[mid] >= leftLimit) {
                    leftPos = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            low = 0;
            high = size - 1;
            int rightPos = -1;
            while (low <= high) {
                int mid = (low + high) / 2;
                if (numbers[mid] <= rightLimit) {
                    rightPos = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (leftPos <= rightPos && leftPos < size && rightPos >= 0) {
                out.println(rightPos - leftPos + 1);
            } else {
                out.println(0);
            }
        }
        out.flush();
    }
}
