import java.util.*;

class Solution {
    
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        //한 번 들어간 점수는 k일간 유지?

        List<Integer> lst = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            lst.add(score[i]);
            Collections.sort(lst, (a1,a2) ->  a2-a1);
            answer[i] = lst.get(Math.min(lst.size()-1, k-1));
        }
        
        
        return answer;
    }
}