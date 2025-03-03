import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        // 동생과 철수가 공평하게 같은 수의 가짓수를 맛볼 수 있도록 자르기?
        // 공평하게 맛보는 경우의 수
        
        int n = topping.length;
        
        int[] c = new int[n];
        int[] b = new int[n];
        
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!set.contains(topping[i])) {
                set.add(topping[i]);
                idx++;
            }
            c[i] = idx;
        }
        
        idx = 0;
        set = new HashSet<>();
        for (int i = n-1; i > -1; i--) {
            if (!set.contains(topping[i])) {
                set.add(topping[i]);
                idx++;
            }
            b[i] = idx;
        }
        
        for (int i = 1; i < n-1; i++) {
            if (c[i-1] == b[i]) {
                answer++;
            }
        }

        return answer;
    }
}