import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m;
    static List<List<Island>> lst;
    static boolean[] visited;
    
    static class Island {
        int idx;
        int limit;
        Island(int idx, int limit) {
            this.idx = idx;
            this.limit = limit;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        lst = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            lst.add(new ArrayList<>());
        }
        
        int maxLimit = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            lst.get(u).add(new Island(v, l));
            lst.get(v).add(new Island(u, l));
            maxLimit = Math.max(maxLimit, l);
        }
        
        st = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(st.nextToken());
        int v   = Integer.parseInt(st.nextToken());
        
        int left = 1;
        int right = maxLimit;
        int answer = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            visited = new boolean[n + 1];
            if (canCross(u, v, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        System.out.println(answer);
    }
    
    static boolean canCross(int start, int end, int weight) {
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(start);
        visited[start] = true;
        
        while (!deq.isEmpty()) {
            int cur = deq.pollFirst();
            if (cur == end) return true;
            
            for (Island next : lst.get(cur)) {
                if (!visited[next.idx] && next.limit >= weight) {
                    visited[next.idx] = true;
                    deq.addLast(next.idx);
                }
            }
        }
        
        return false;
    }
}
