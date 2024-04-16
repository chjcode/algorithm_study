/**

**/
import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];  // 배열에 추가 어떻게? python의 append
        
        Map<Character, Integer> map = new HashMap<>();
        // map에 알파벳별 가장 빠른 idx 저장
        // keymap을 순서대로 순회하면서 map에 없으면 저장
        // map에 있으면 비교해보고 저장
        for (String key : keymap) {
            for (int i = 0; i < key.length(); i++) {
                if (map.containsKey(key.charAt(i))) {
                    if (map.get(key.charAt(i)) > i) {
                        map.put(key.charAt(i),i+1);    //java의 맵. 이미 있는 key 또 저장하면 덮어씌우는지?
                    }
                } else {
                    map.put(key.charAt(i),i+1);
                }
            }
        }
        
        // target 순회하면서 최소 몇 번 눌러야 하는지 answer에 저장
        for (int i = 0; i < targets.length; i++) {
            int cnt = 0;
            String target = targets[i];
            for (int j = 0; j < target.length(); j++) {
                if (map.containsKey(target.charAt(j))) {
                    cnt += map.get(target.charAt(j));
                } else {
                    cnt = -1;
                    break;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
}