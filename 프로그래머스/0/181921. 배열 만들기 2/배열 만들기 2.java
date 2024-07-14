import java.util.*;

class Solution {
    public List solution(int l, int r) {      
        List<Integer> answer = new ArrayList<>();
        
        for (int i = l; i < r+1; i++){
            String s = Integer.toString(i);
            boolean flag = true;
            for (int j = 0; j < s.length(); j++){
                if (s.charAt(j) != '5' && s.charAt(j) != '0'){
                    flag = false;
                    break;
                }
            }
            if (flag){
                answer.add(i);
            }
        }
        if (answer.isEmpty()){
            answer.add(-1);
        }
        
        return answer;
    }
}