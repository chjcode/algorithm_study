import java.util.*;

class Solution {
    
    static Set<Integer> set;
    
    public int solution(int[] elements) {
        int n = elements.length;
        set = new HashSet<>();
        
        for (int elCnt = 1; elCnt < n+1; elCnt++) {
            for (int i = 0; i < n; i++) {
                int cnt = 0;
                for (int j = i; j < i+elCnt; j++) {
                    cnt += elements[j%n];
                }
                set.add(cnt);
            }        
        }

        return set.size();
    }
}