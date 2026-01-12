import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Integer> deq = new LinkedList<>();
        for (int i = 1; i <= n; i++) deq.addLast(i);

        st = new StringTokenizer(br.readLine());
        int answer = 0;

        for (int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());

            int idx = 0;
            for (int x : deq) {
                if (x == target) break;
                idx++;
            }

            int size = deq.size();
            int left = idx;
            int right = size - idx;
            
            if (left <= right) {
                for (int k = 0; k < left; k++) {
                    deq.addLast(deq.pollFirst());
                }
                answer += left;
            } else {
                for (int k = 0; k < right; k++) {
                    deq.addFirst(deq.pollLast());
                }
                answer += right;
            }

            deq.pollFirst();
        }

        System.out.println(answer);
    }
}
