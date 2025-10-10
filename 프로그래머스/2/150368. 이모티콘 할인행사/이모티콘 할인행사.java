import java.util.*;

class Solution {
    // 전역 최적값
    private int bestJoin = 0;
    private int bestRevenue = 0;

    // 고정 할인 후보
    private static final int[] RATES = {10, 20, 30, 40};

    private int[][] users;
    private int[] emoticons;
    private int m;

    public int[] solution(int[][] users, int[] emoticons) {
        this.users = users;
        this.emoticons = emoticons;
        this.m = emoticons.length;

        int[] picked = new int[m];  // 각 이모티콘에 선택된 할인율
        dfs(0, picked);

        return new int[]{bestJoin, bestRevenue};
    }

    // idx번째 이모티콘의 할인율을 고르는 DFS
    private void dfs(int idx, int[] picked) {
        if (idx == m) {
            evaluate(picked);
            return;
        }
        for (int r : RATES) {
            picked[idx] = r;
            dfs(idx + 1, picked);
        }
    }

    // 현재 할인 조합(picked)에 대해 가입자 수와 매출 계산
    private void evaluate(int[] picked) {
        int join = 0;
        int revenue = 0;

        for (int[] u : users) {
            int minRate = u[0];   // 이 사용자 최소 선호 할인율(이상이어야 구매)
            int plusCut = u[1];   // 이 이상이면 플러스 가입

            int sum = 0;
            for (int i = 0; i < m; i++) {
                if (picked[i] >= minRate) {
                    int price = emoticons[i] * (100 - picked[i]) / 100; // 정수 계산
                    sum += price;
                }
            }

            if (sum >= plusCut) {
                join++;
            } else {
                revenue += sum;
            }
        }

        // 우선순위: 가입자 수 > 매출
        if (join > bestJoin || (join == bestJoin && revenue > bestRevenue)) {
            bestJoin = join;
            bestRevenue = revenue;
        }
    }
}
