import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        
        boolean[] nums = new boolean[46];
        
        int zeroCnt = 0;
        for (int lotto : lottos) {
            if (lotto == 0) {
                zeroCnt++;
                continue;
            }
            
            nums[lotto] = true;
        }
        
        int correctCnt = 0;
        for (int win_num : win_nums) {
            if (nums[win_num]) {
                correctCnt++;
            }
        }
        
        int worst = correctCnt;
        int best = correctCnt + zeroCnt;
        int worstRank = 0;
        int bestRank = 0;
        if (worst < 2) {
            worstRank = 6;
        } else {
            worstRank = 6 - worst + 1;
        }
        
        if (best < 2) {
            bestRank = 6;
        } else {
            bestRank = 6 - best + 1;
        }
        
        answer[0] = bestRank;
        answer[1] = worstRank;
        
        return answer;
    }
}