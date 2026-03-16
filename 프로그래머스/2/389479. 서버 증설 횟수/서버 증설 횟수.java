class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int[] server = new int[n + k];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int need = players[i] / m;

            if (server[i] < need) {
                int add = need - server[i];
                answer += add;

                for (int j = i; j < i + k; j++) {
                    server[j] += add;
                }
            }
        }

        return answer;
    }
}