import java.util.*;
public class AncientOrderingSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordCount = sc.nextInt();
        String[] words = new String[wordCount];
        for (int i = 0; i < wordCount; i++) words[i] = sc.next();
        ArrayList<Integer>[] adjacencyList = new ArrayList[26];
        for (int i = 0; i < 26; i++){ 
            adjacencyList[i] = new ArrayList<>();}
        int[] indegree = new int[26];
        boolean[] letterPresent = new boolean[26];

        for (int i = 0; i < wordCount; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                int letterIndex = words[i].charAt(j) - 'a';
                letterPresent[letterIndex] = true;}}
        for (int i = 1; i < wordCount; i++) {
            String prevWord = words[i - 1];
            String currWord = words[i];
            int len = Math.min(prevWord.length(), currWord.length());
            boolean diffFound = false;
            for (int j = 0; j < len; j++) {
                if (prevWord.charAt(j) != currWord.charAt(j)) {
                    int from = prevWord.charAt(j) - 'a';
                    int to = currWord.charAt(j) - 'a';
                    adjacencyList[from].add(to);
                    indegree[to]++;
                    diffFound = true;
                    break;}}
            if (!diffFound && prevWord.length() > currWord.length()) {
                System.out.println(-1);
                return; }}
        int lettersPrinted = 0;
        boolean progress = true;
        while (progress) {
            progress = false;
            for (int i = 0; i < 26; i++) {
                if (letterPresent[i] && indegree[i] == 0) {
                    System.out.print((char)(i + 'a'));
                    indegree[i] = -1;
                    lettersPrinted++;
                    progress = true;
                    for (int j = 0; j < adjacencyList[i].size(); j++) {
                        int to = adjacencyList[i].get(j);
                        indegree[to]--;}
                    break;}}}
        for (int i = 0; i < 26; i++) {
            if (letterPresent[i] && indegree[i] >= 0) {
                System.out.println(-1);
                return;}}
        if (lettersPrinted > 0) System.out.println();
    }
}