import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int n = park.length;
        int m = park[0].length;
        
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (park[i][0].equals("-1")) dp[i][0] = 1;
        }
        
        for (int j = 0; j < m; j++) {
            if (park[0][j].equals("-1")) dp[0][j] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (park[i][j].equals("-1")) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        
        Arrays.sort(mats);
        
        for (int mat : mats) {
            if (max >= mat) {
                answer = mat;
            }
        }
        
        return answer;
    }
}