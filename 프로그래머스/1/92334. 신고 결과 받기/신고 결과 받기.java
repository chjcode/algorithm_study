import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        // 1. 누가 누굴 신고했는지 내역이 있어야 함.
        // 2. 
        
        
        Map<String, Integer> cntMap = new HashMap<>();
        Map<String, List<String>> reportMap = new HashMap<>();
        for (String id : id_list) {
            cntMap.put(id, 0);
            reportMap.put(id, new ArrayList<>());
        }
        
        
        
        Set<String> reportSet = new HashSet<>();
        for (String r : report) {
            String[] s = r.split(" ");
            
            if (!reportSet.contains(r)) {
                reportSet.add(r);
                cntMap.put(s[1], cntMap.get(s[1]) + 1);
                reportMap.get(s[0]).add(s[1]);
            }
            
        }

        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            
            for (String user : reportMap.get(id)) {
                if (cntMap.get(user) >= k) {
                    answer[i]++;
                }
            }
            
        }

        
        
        return answer;
    }
}