import java.util.*;

class Solution {
    
    int max;
    
    public int solution(int k, int[][] dungeons) {
        
        max = 0;
        
        boolean[] visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, visited, 0);
        
        return max;
    }
    
    private void dfs(int k, int[][] dungeons, boolean[] visited, int cnt) {
        max = Math.max(max, cnt);
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i]) {
                if (k >= dungeons[i][0]) {
                    visited[i] = true;
                    dfs(k-dungeons[i][1], dungeons, visited, cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}