import java.io.*;
import java.util.*;

public class Main {

    static class Study {
        int start, end;
        Study(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        Study[] studies = new Study[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            studies[i] = new Study(s, e);
        }

        Arrays.sort(studies, (a, b) -> {
            if (a.start != b.start) return a.start - b.start;
            return a.end - b.end;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int answer = 0;
        for (Study s : studies) {
            if (!pq.isEmpty() && pq.peek() <= s.start) {
                pq.poll();
            }
            pq.add(s.end);

            answer = Math.max(answer, pq.size());
        }

        System.out.println(answer);
    }
}
