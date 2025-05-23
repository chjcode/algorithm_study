import java.util.*;

class Solution {
    public int solution(int N, int number) {
        int answer = 0;
        
        List<Set<Integer>> dp = new ArrayList<>();
        
        for (int i = 0; i < 9; i++) {
            dp.add(new HashSet<>());
        }
        
        for (int i = 1; i < 9; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                cnt = cnt * 10 + N;
            }
            
            dp.get(i).add(cnt);
            
            
            for (int j = 1; j < i; j++) {
                for (int x : dp.get(j)) {
                    for (int y : dp.get(i-j)) {
                        dp.get(i).add(x+y);
                        dp.get(i).add(x-y);
                        dp.get(i).add(x*y);
                        if (y != 0) {
                            dp.get(i).add(x/y);
                        }
                    }
                }
            }
            
            if (dp.get(i).contains(number)) {
                return i;
            }
            
        }
        
        
        return -1;
    }
}