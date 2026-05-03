import java.util.*;

class Solution {
    
    Map<String, Integer> map;
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answer = new ArrayList<>();
        
        for (int i = 0; i < orders.length; i++) {
            char[] menu = orders[i].toCharArray();
            Arrays.sort(menu);
            orders[i] = new String(menu);
        }
        
        for (int num : course) {
            map = new HashMap<>();
            
            for (String order : orders) {
                if (order.length() >= num) {
                    dfs(0, "", order, num);
                }
            }
            
            int max = 0;
            
            for (int count : map.values()) {
                if (count >= 2) {
                    max = Math.max(max, count);
                }
            }
            
            for (String key : map.keySet()) {
                if (map.get(key) == max && max >= 2) {
                    answer.add(key);
                }
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }
    
    private void dfs(int idx, String current, String order, int targetLength) {
        if (current.length() == targetLength) {
            map.put(current, map.getOrDefault(current, 0) + 1);
            return;
        }
        
        for (int i = idx; i < order.length(); i++) {
            dfs(i + 1, current + order.charAt(i), order, targetLength);
        }
    }
}