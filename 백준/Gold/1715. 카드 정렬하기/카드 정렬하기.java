import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n  = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));            
        }
        
        int answer = 0;
        
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            
            int c = a + b;
            answer += c;
            pq.add(c);
        }
        
        System.out.println(answer);
    }
}