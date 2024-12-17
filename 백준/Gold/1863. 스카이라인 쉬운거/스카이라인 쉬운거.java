import java.util.*;
import java.io.*;

public class Main {

    static int n, answer;
    static int[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        Deque<Integer> deq = new ArrayDeque<>();
        answer = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            while (!deq.isEmpty() && deq.peekLast() > y) {
                answer++;
                deq.pollLast();
            }

            if (!deq.isEmpty() && deq.peekLast() == y) continue;

            deq.addLast(y);
//            System.out.println(Arrays.toString(deq.toArray()));
        }
//        System.out.println(Arrays.toString(deq.toArray()));
        while(!deq.isEmpty()) {
            if (deq.peekLast() > 0) {
                answer++;
            }
            deq.pollLast();
        }

        System.out.println(answer);


    }
}
