import java.util.*;
import java.io.*;

public class Main {
    
    static String goal = "123456780";
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                sb.append(st.nextToken());
            }
        }
        
        System.out.println(bfs(sb.toString()));
    }
    
    public static int bfs(String start) {
        Deque<String> deq = new ArrayDeque<>();
        Map<String, Integer> visited = new HashMap<>();
        
        deq.add(start);
        visited.put(start, 0);
        
        while (!deq.isEmpty()) {
            String now = deq.poll();
            
            if (now.equals(goal)) return visited.get(now);
            
            int zero = now.indexOf('0');
            int x = zero / 3;
            int y = zero % 3;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) continue;
                
                int idx = nx * 3 + ny;
                char[] arr = now.toCharArray();
                
                char temp = arr[zero];
                arr[zero] = arr[idx];
                arr[idx] = temp;
                
                String next = new String(arr);
                if(!visited.containsKey(next)) {
                    visited.put(next, visited.get(now) + 1);
                    deq.add(next);
                }
                
            }
        }
        
         return -1;
    }
}