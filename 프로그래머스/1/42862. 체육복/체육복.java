class Solution {
    
    static final int NORMAL  = 0;
    static final int LOST = 1;
    static final int RESERVE = 2;
    
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        int[] student = new int[n+1];
        for (int i = 0; i < lost.length; i++) {
            student[lost[i]] = LOST;
            answer--;
        }
        
        for (int i = 0; i < reserve.length; i++) {
            if (student[reserve[i]] == LOST) {
                student[reserve[i]] = NORMAL;
                answer++;
            } else {
                student[reserve[i]] = RESERVE;
            }
        }
        
        for (int i = 1; i < n+1; i++) {
            if (student[i] == LOST && student[i-1] == RESERVE)  {
                student[i-1] = NORMAL;
                student[i] = NORMAL;
                answer++;
            } else if (i < n && student[i] == LOST && student[i+1] == RESERVE) {
                student[i+1] = NORMAL;
                student[i] = NORMAL;
                answer++;
            }
        }
        
        return answer;
    }
}