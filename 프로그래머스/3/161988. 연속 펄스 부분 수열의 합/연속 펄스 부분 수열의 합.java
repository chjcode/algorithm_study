class Solution {
    public long solution(int[] sequence) {
        long answer = 0;
        
        long sum1 = 0;
        long sum2 = 0;
        
        boolean flag = true;
        for (int num : sequence) {
            if (flag) {
                sum1 += num;
                sum2 -= num;
            } else {
                sum1 -= num;
                sum2 += num;
            }
            
            if (sum1 < 0) {
                sum1 = 0;
            }
            
            if (sum2 < 0) {
                sum2 = 0;
            }
            answer = Math.max(answer, Math.max(sum1, sum2));
            
            flag = !flag;
        }
        
        return answer;
    }
}