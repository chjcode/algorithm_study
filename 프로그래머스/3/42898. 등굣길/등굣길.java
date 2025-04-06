class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] dp = new int[n + 1][m + 1];

        // 물웅덩이 표시용
        boolean[][] isPuddle = new boolean[n + 1][m + 1];
        for (int[] p : puddles) {
            isPuddle[p[1]][p[0]] = true;  // 1-based 좌표라 그대로 씀
        }

        dp[1][1] = 1;  // 시작점

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (isPuddle[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i > 1) dp[i][j] += dp[i - 1][j];
                if (j > 1) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }

        return dp[n][m];
    }
}
