import java.util.*;

import java.util.*;

class Solution {

    static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;

        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(computers, n, i);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private static void bfs(int[][] computers, int n, int start) {
        Deque<Integer> deq = new ArrayDeque<>();
        deq.add(start);
        visited[start] = true;
        while (!deq.isEmpty()) {
            int now = deq.pollFirst();
            
            for (int i = 0; i < n; i++) {
                if (computers[i][now] == 1 && !visited[i]) {
                    visited[i] = true;
                    deq.addLast(i);
                }
            }
        }
    }
}