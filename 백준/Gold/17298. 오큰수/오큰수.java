import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Deque<Integer> deq = new ArrayDeque<>();
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            while (!deq.isEmpty() && arr[deq.peekLast()] < arr[i]) {
                answer[deq.pollLast()] = arr[i];
            }
            
            deq.add(i);
        }
        
        while (!deq.isEmpty()) {
            answer[deq.pollLast()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(answer[i]).append(' ');
        }
        
        System.out.println(sb.toString());
    }
}