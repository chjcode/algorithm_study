class Solution {
    public int solution(int[] diffs, int[] times, long limit) {

        int n = diffs.length;
        
        long left = 1;
        long right = 0;
        for (int d : diffs) {
            right = Math.max(right, d);
        }
        int result = 0;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            int level = (int) mid;
            long cnt = 0;
            long prev = 0;
            for (int i = 0; i < n; i++) {
                long now = times[i];
                if (diffs[i] > level) {
                    long wrong = diffs[i] - level;
                    
                    cnt += wrong * (now + prev) + now;
                } else {
                    cnt += now;
                }
                
                if (cnt > limit) {
                    break;
                }
                prev = now;
            }
            
            if (cnt <= limit) {
                result = level;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
}