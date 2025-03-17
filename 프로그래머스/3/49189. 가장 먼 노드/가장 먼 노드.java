import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] node : edge) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }
        
        Deque<Integer> deq = new ArrayDeque<>();
        deq.addLast(1);
        dist[1] = 0;
        
        while (!deq.isEmpty()) {
            int now = deq.pollFirst();
            for (int next : graph.get(now)) {
                if (dist[next] == Integer.MAX_VALUE) {
                    dist[next] = dist[now] + 1;
                    deq.addLast(next);
                }
            }
        }
        
        
        int maxDist = 0;
        for (int i = 1; i <= n; i++) {
            maxDist = Math.max(maxDist, dist[i]);
        }
        
        for (int i = 1; i <= n; i++) {
            if (dist[i] == maxDist) {
                answer++;
            }
        }
        
        
        return answer;
    }
}