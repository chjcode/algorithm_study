
import java.io.*;
import java.util.*;

public class Main {

    static int n,m;
    static Map<String,Integer> map;

    static class Word implements Comparable<Word>{
        String word;
        int cnt;

        Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Word w) {
            if (this.cnt != w.cnt) {
                return Integer.compare(w.cnt, this.cnt);
            }

            if (this.word.length() != w.word.length()) {
                return Integer.compare(w.word.length(), this.word.length());
            }

            return this.word.compareTo(w.word);

        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.length() < m) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        PriorityQueue<Word> pq = new PriorityQueue<>();
        int cnt = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new Word(entry.getKey(), entry.getValue()));
            cnt++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cnt; i++) {
            sb.append(pq.poll().word).append("\n");
        }

        System.out.println(sb.toString());
    }
}
