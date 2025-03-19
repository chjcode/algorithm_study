class Solution {
    public int solution(int n, int[][] results) {
        // n+1 x n+1 배열 사용 (선수 번호가 1부터 시작)
        boolean[][] win = new boolean[n + 1][n + 1];
        
        // 주어진 경기 결과 반영: result[0]번 선수가 result[1]번 선수를 이겼음
        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];
            win[winner][loser] = true;
        }
        
        // 플로이드–워셜 알고리즘을 이용하여 간접적인 승리 관계 계산
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (win[i][k]) {
                    for (int j = 1; j <= n; j++) {
                        if (win[k][j]) {
                            win[i][j] = true;
                        }
                    }
                }
            }
        }
        
        // 순위가 결정된 선수 계산
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                // i가 j를 이겼거나 j가 i를 이긴 경우 카운트 증가
                if (win[i][j] || win[j][i]) {
                    count++;
                }
            }
            // 다른 모든 선수와의 승패 관계가 결정되어 있으면 순위 결정 가능
            if (count == n - 1) {
                answer++;
            }
        }
        return answer;
    }
}
