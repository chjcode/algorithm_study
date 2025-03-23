class Solution {
    public long solution(int n, int[] times) {

        int maxTime = 0;
        for (int time : times) {
            maxTime = Math.max(time, maxTime);
        }

        long left = 0;
        long right = (long) maxTime * n;
        long result = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long cnt = 0;
            for (int time : times) {
                cnt += mid / time;
            }
            
            if (cnt >= n) {
                right = mid - 1;
                result = mid;
            } else {
                left = mid + 1;
            }
        }
        
        
        
        return result;
    }
}