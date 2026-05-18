import java.util.*;

class Solution {
    
    int answer = 0;
    
    public int solution(int n, int[][] q, int[] ans) {
        dfs(1, 0, new HashSet<>(), n, q, ans);
        return answer;
    }
    
    private void dfs(int start, int depth, Set<Integer> arr,
                     int n, int[][] q, int[] ans) {
        
        if (depth == 5) {
            for (int i = 0; i < q.length; i++) {
                int cnt = 0;
                
                for (int num : q[i]) {
                    if (arr.contains(num)) {
                        cnt++;
                    }
                }
                
                if (cnt != ans[i]) {
                    return;
                }
            }
            
            answer++;
            return;
        }
        
        for (int i = start; i <= n; i++) {
            arr.add(i);
            dfs(i + 1, depth + 1, arr, n, q, ans);
            arr.remove(i);
        }
    }
}