import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) trucks[i] = Integer.parseInt(st.nextToken());

        Deque<Integer> bridge = new ArrayDeque<>();
        for (int i = 0; i < w; i++) bridge.offer(0);

        int time = 0;
        int currLoad = 0;
        int idx = 0;

        while (idx < n) {
            time++;

            currLoad -= bridge.poll();

            int next = trucks[idx];
            if (currLoad + next <= L) {
                bridge.offer(next);
                currLoad += next;
                idx++;
            } else {

                bridge.offer(0);
            }
        }

        time += w; 

        System.out.println(time);
    }
}
