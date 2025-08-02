import java.util.*;
import java.io.*;

public class Main {
    
    static int t, n,m;
    static List<List<Integer>> lst;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            
            lst = new ArrayList<>();
            for (int i = 0; i < n+1; i++) {
                lst.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                lst.get(a).add(b);
                lst.get(b).add(a);
            }

            visited = new boolean[n+1];
            int cnt = bfs(1);
            
            System.out.println(cnt-1);
            
        }
        
    }
    
    private static int bfs(int start) {
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(start);
        visited[start] = true;
        int cnt = 1;

        while (!deq.isEmpty()) {
            int now = deq.pollFirst();
            for (int next : lst.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    deq.addLast(next);
                    cnt++;
                }
            }
        }

        return cnt;
    }
}