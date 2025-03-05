class Solution {
    public long solution(int n) {
        long answer = 0;
        
        int[] dp = new int[n+1];
        
        if (n == 1) return 1;
        else if (n == 2) return 2;
        else if (n == 3) return 3;
        
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        return dp[n];
    }
}

// 1 : 1
// 2 : 11, 2
// 3 : 111, 12, 21 -> 3
// 4 : 1111, 121, 211, 112, 22 -> 5
// 5 : 11111, 2111, 1211, 1121, 1112, 221, 212, 122 -> 8
// 6 : 