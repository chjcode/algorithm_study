import java.util.*;
class Solution {
    public List<Integer> solution(String[] intStrs, int k, int s, int l) {
        List<Integer> answer = new ArrayList<>();
        
        for(String string : intStrs){
            StringBuilder sb = new StringBuilder();
            for (int i = s; i < s+l; i++){
                sb.append(string.charAt(i));
            }
            int num = Integer.parseInt(sb.toString());
            if (num > k){
                answer.add(num);
            }
        }
        
        return answer;
    }
}