import java.util.*;

class Solution {
    
    static List<List<Integer>> graph;
    static int[][] dp;
    static boolean[] visited;
    
    public int solution(int n, int[][] lighthouse) {
        
        graph = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] node : lighthouse) {
            graph.get(node[0]).add(node[1]);
            graph.get(node[1]).add(node[0]);
        }
        
        dp = new int[n+1][2];
        visited = new boolean[n+1];
        
        dfs(1);
        
        
        
        
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    static void dfs(int node) {
        visited[node] = true;
        
        dp[node][0] = 0;
        dp[node][1] = 1;
        
        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
                dp[node][0] += dp[child][1];
                dp[node][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }
}