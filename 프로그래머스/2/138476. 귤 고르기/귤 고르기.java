import java.util.*;

class Solution {
    
    static class Tan implements Comparable<Tan>{
        int size;
        int cal;
        Tan(int size, int cal) {
            this.size = size;
            this.cal = cal;
        }
        
        @Override
        public int compareTo(Tan t) {
            return this.cal-t.cal;
        }
        
    }
    
    static Map<Integer, Integer> map;
    static List<Tan> lst;
    
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        // k개 골랐을 때 다른 귤이 최소가 되도록 -> 귤 종류 반환
        // 1. map으로 개수 세기
        // 2. map key로 받아서 클래스로 변환시킨 다음에 정렬
        // 3. 개수가 적은 것 부터 k개 삭제
        
        map = new HashMap<>();
        
        for (int i = 0; i < tangerine.length; i++) {
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0) + 1);
        }
        
        lst = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            lst.add(new Tan(entry.getKey(), entry.getValue()));
        }
        
        Collections.sort(lst);
        
//         for (int i = 0; i < lst.size(); i++) {
//             System.out.println(lst.get(i).cal);
//         }
        
        int pick = tangerine.length - k;
        int idx = 0;
        int cnt = 0;
        while (true) {
            cnt += lst.get(idx).cal;
            if (cnt == pick) {
                answer = lst.size() - idx - 1;
                break;
            } else if (cnt > pick) {
                answer = lst.size() - idx;
                break;
            }
            idx++;
        }
        
        
        return answer;
    }
}