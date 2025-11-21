import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        
        Map<Character, Integer> map = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            char c = split[0].charAt(0);
            int i = Integer.parseInt(split[1]);
            map.put(c, i);
        }
        
        
        StringTokenizer st = new StringTokenizer(today, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        int sum = year * 12 * 28 + month * 28 + day;
        
        List<Integer> lst = new ArrayList<>();
        
        for (int i = 0; i < privacies.length; i++) {
            st = new StringTokenizer(privacies[i]);
            String s = st.nextToken();
            
            char type = st.nextToken().charAt(0);
            st = new StringTokenizer(s, ".");
            int pYear = Integer.parseInt(st.nextToken());
            int pMonth = Integer.parseInt(st.nextToken());
            int pDay = Integer.parseInt(st.nextToken());
            
            int start = pYear * 12 * 28 + pMonth * 28 + pDay;
            int end = start + map.get(type) * 28;
            
            if (end <= sum) {
                lst.add(i + 1);
            }
            
        }
        
        answer = new int[lst.size()];
        for (int i = 0; i < lst.size(); i++) {
            answer[i] = lst.get(i);
        }
        
        return answer;
    }
}