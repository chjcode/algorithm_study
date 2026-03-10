import java.util.*;

class Solution {
    public int solution(int[][] info, int n, int m) {
        
        // dp[1] = 4 -> b가 1일 때 a의 최솟값은 4
        int[] dp = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        
        dp[0] = 0;
        
        for (int[] item : info) {
            int a = item[0];
            int b = item[1];
            
            int[] next = new int[m];
            Arrays.fill(next, Integer.MAX_VALUE);
            
            for (int nowB = 0; nowB < m; nowB++) {
                if (dp[nowB] == Integer.MAX_VALUE) continue;
                
                int nowA = dp[nowB];
                
                int nextA = nowA + a;
                if (nextA < n)  {
                    next[nowB] = Math.min(next[nowB], nextA);
                }
                
                int nextB = nowB + b;
                if (nextB < m) {
                    next[nextB] = Math.min(next[nextB], nowA);
                }
                
            }
            
            dp = next;
            
        }
        
        int answer = Integer.MAX_VALUE;
        
        for (int b = 0; b < m; b++) {
            answer = Math.min(answer, dp[b]);
        }
        
        if (answer == Integer.MAX_VALUE) answer = -1;
        
        return answer;
    }
}