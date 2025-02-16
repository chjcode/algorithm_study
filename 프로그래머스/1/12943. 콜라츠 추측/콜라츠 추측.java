class Solution {
    public int solution(int num) {
        int answer = 0;
        int cnt = 0;
        long n = num;
        while (cnt < 500 && n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }
            cnt++;
        }
        
        if (n != 1) {
            cnt = -1;
        }
        return cnt;
    }
}