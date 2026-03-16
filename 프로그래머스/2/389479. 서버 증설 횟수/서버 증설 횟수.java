class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int[] expire = new int[n + k + 1];
        int active = 0;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            active -= expire[i];

            int need = players[i] / m;   // 여기만 고치면 됨

            if (active < need) {
                int add = need - active;
                active += add;
                answer += add;
                expire[i + k] += add;
            }
        }

        return answer;
    }
}