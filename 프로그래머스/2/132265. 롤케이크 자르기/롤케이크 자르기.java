import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int t : topping) {
            map.put(t, map.getOrDefault(t,0)+1);
        }
        
        Set<Integer> set = new HashSet<>();
        for (int t : topping) {
            int cnt = map.get(t)-1;
            if (cnt == 0) {
                map.remove(t);
            } else {
                map.put(t, cnt);
            }
            
            set.add(t);
            
            if (map.size() == set.size()) {
                answer++;
            }
        }
        
        return answer;
    }
}