import java.util.*;

class Solution {
    static int[] answer;
    static Map<String, Integer> trashes;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int n = enroll.length;
        answer = new int[n];
        
        trashes = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            trashes.put(enroll[i],i);
        }
        
        for (int i = 0; i < seller.length; i++) {
            int idx = trashes.get(seller[i]);
            int profit = amount[i] * 100;
            cal(referral, idx, profit);
        }
        
        return answer;
    }
    
    private static void cal(String[] referral, int idx, int profit) {
        if (profit < 1) return;
        
        int parentTrash = profit / 10;
        int childTrash = profit - parentTrash;
        
        answer[idx] += childTrash;
        
        if (referral[idx].equals("-")) return;
        
        cal(referral, trashes.get(referral[idx]), parentTrash);
    
    }
}