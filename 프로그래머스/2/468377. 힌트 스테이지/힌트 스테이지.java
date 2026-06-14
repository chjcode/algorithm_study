import java.util.*;

class Solution {
    public int solution(int[][] cost, int[][] hint) {
        int answer = Integer.MAX_VALUE;
        int n = cost.length;

        int max = 1 << (n - 1);

        for (int mask = 0; mask < max; mask++) {
            int total = 0;
            int[] cnt = new int[n];

            for (int i = 0; i < n - 1; i++) {
                if ((mask & (1 << i)) != 0) {
                    total += hint[i][0];

                    for (int j = 1; j < hint[i].length; j++) {
                        int idx = hint[i][j] - 1;
                        cnt[idx]++;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int use = Math.min(cnt[i], n - 1);
                total += cost[i][use];
            }

            answer = Math.min(answer, total);
        }

        return answer;
    }
}