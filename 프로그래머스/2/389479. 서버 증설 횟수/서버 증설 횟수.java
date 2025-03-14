import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // m 명 늘어나면 서버 추가 필요
        // k : 증설한 서버 이용시간
        int now = 1;
        
        int[] server = new int[24];
        
        for (int i = 0; i < 24; i++) {
            int need = 0;
            if (m > 0) {
                need = players[i]/m;
            }
            if (need > server[i]) {
                int sub = need - server[i];
                for (int j = i; j < i+k; j++) {
                    if (j < 24) {
                        server[j] += sub;
                        // System.out.println(Arrays.toString(server));
                    }
                }
                answer += sub;
            }
        }
        // System.out.println(Arrays.toString(server));
        
        return answer;
    }
}