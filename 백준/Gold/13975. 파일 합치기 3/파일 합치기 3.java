import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            int k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < k; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }
            
            long answer = 0;

            while(pq.size() != 1) {
                long a = pq.poll();
                long b = pq.poll();
                long sum = a + b;
                answer += sum;
                pq.add(sum);
            }
            
            System.out.println(answer);
        }
    }
}