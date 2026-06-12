import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int n = want.length;
        int m = discount.length;
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(want[i], i);
        }
        
        int[] cnt = new int[n];
        int perfect = 0;
        for (int i = 0; i < 10; i++) {
            if (map.containsKey(discount[i])) {
                int idx = map.get(discount[i]);
                
                if (cnt[idx] == number[idx]) perfect--;
                
                cnt[idx]++;
                
                if (cnt[idx] == number[idx]) perfect++;
            }
        }
        
        if (perfect == n) answer++;
        
        for (int right = 10; right < m; right++) {
            int left = right - 10;
            
            String remove = discount[left];
            if (map.containsKey(discount[left])) {
                int idx = map.get(remove);
                
                if (cnt[idx] == number[idx]) perfect--;
                
                cnt[idx]--;
                
                if (cnt[idx] == number[idx]) perfect++;
            }
            
            String add = discount[right];
            if (map.containsKey(add)) {
                int idx = map.get(add);
                
                if (cnt[idx] == number[idx]) perfect--;
                
                cnt[idx]++;
                
                if (cnt[idx] == number[idx]) perfect++;
            }
            
            if (perfect == n) answer++;
        }
        
        
        
        return answer;
    }
}