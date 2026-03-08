import java.util.*;

class Solution {
    
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        List<int[]> lst = new ArrayList<>();
        for (int[] d : data) {
            if (d[map.get(ext)] < val_ext) {
                lst.add(d);
            }
        }
        
        Collections.sort(lst, (a,b) -> a[map.get(sort_by)] - b[map.get(sort_by)]);
        
        int[][] answer = new int[lst.size()][4];
        
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
}