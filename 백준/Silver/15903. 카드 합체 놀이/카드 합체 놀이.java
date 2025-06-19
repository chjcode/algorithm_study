import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        
        while (m-- > 0) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
          
            pq.add(sum);
            pq.add(sum);
        }
        
        long answer = 0;
        while(!pq.isEmpty()) {
            answer += pq.poll();
        }
        
        System.out.println(answer);
        
    }
}