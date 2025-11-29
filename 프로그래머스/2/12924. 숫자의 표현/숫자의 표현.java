class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int left = 0;
        int right = 0;
        int cnt = 0;
        int sum = 0;
        while (right <= n) {
            if (sum == n) {
                cnt++;
                // System.out.println("left : " + left + " right : " + right);
                right++;
                sum += right;
                
            }
            if (sum < n) {
                right++;
                sum += right;
            } else if (sum > n) {
                sum -= left;
                left++;
            }
        }
        
        
        
        
        return cnt;
    }
}