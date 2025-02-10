import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        
        List<Integer> lst = new ArrayList<>();
        
        for (int i : ingredient) {
            lst.add(i);
            
            if (lst.size() >= 4) {
                int size = lst.size();
                if (lst.get(size-1) == 1
                   && lst.get(size-2) == 3
                   && lst.get(size-3) == 2
                   && lst.get(size-4) == 1) {
                    for (int j = 0; j < 4; j++) {
                        lst.remove(lst.size() - 1);    
                    }
                    answer++;
                }
            }
        }
        
        return answer;
    }
}