import java.util.*;

class Solution {
    public int solution(int[] cards) {
        
        int n = cards.length;
        boolean[] visited = new boolean[n];
        List<Integer> lst = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int cnt = 0;
                int now = i;
                while (!visited[now]) {
                    visited[now] = true;
                    now = cards[now] - 1;
                    cnt++;
                }
                lst.add(cnt);
            }
        }
        
        Collections.sort(lst, Collections.reverseOrder());
        
        if (lst.size() < 2) {
            return 0;
        }
        return lst.get(0) * lst.get(1);
    }
}