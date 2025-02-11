import java.util.*;

class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        
        for (int i = 1; i < number+1; i++) {
            int cnt = 0;
            for (int j = 1; j < (int)Math.sqrt(i)+1; j++) {
                if (i % j == 0) {
                    cnt += 2;
                    if (j * j == i) {
                        cnt--;
                    }
                }
            }
            if (cnt > limit) {
                answer += power;
            } else {
                answer += cnt;
            }
        }

        
        return answer;
    }
}