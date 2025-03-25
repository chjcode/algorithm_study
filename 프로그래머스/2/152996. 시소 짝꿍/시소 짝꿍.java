import java.util.HashMap;
import java.util.Map;

class Solution {
    public long solution(int[] weights) {
        Map<Integer, Long> freq = new HashMap<>();
        
        long answer = 0;
        
        for (int w : weights) {
            // 같은 몸무게끼리 짝을 미리 계산
            if (freq.containsKey(w)) {
                answer += freq.get(w);
            }
            freq.put(w, freq.getOrDefault(w, 0L) + 1);
        }
        
        // 가능한 비율: 3/2, 2, 4/3 (모두 1보다 큰 값)
        int[][] ratios = { {3, 2}, {2, 1}, {4, 3} };
        for (int a : freq.keySet()) {
            for (int[] ratio : ratios) {
                int numerator = ratio[0];
                int denominator = ratio[1];
                
                if ((a * numerator) % denominator != 0) continue;
                int b = a * numerator / denominator;
                
                if (b <= a) continue;
                if (freq.containsKey(b)) {
                    answer += freq.get(a) * freq.get(b);
                }
            }
        }
        
        return answer;
    }
}
