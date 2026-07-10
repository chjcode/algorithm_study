class Solution
{

    public int solution(String s)
    {
        int answer = 0;
    
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int oddCnt = checkOdd(i, s, n);
            int evenCnt = checkEven(i, s, n);
            
            answer = Math.max(answer, Math.max(oddCnt, evenCnt));
            
        }

        return answer;
    }
    
    private int checkOdd(int i, String s, int n) {
        int left = i-1;
        int right = i+1;
        int cnt = 1;
        while (left >= 0 && right < n) {
            if (s.charAt(left) == s.charAt(right)) {
                cnt+=2;
                left--;
                right++;
            } else {
                break;
            }
        }
        
        return cnt;
    }
    
    
    private int checkEven(int i, String s, int n) {
        int left = i;
        int right = i+1;
        int cnt = 0;
        while (left >= 0 && right < n) {
            if (s.charAt(left) == s.charAt(right)) {
                cnt+=2;
                left--;
                right++;
            } else {
                break;
            }
        }
        
        return cnt;
    }
}