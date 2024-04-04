class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 1; // 처음에 한 번 칠함
        int start = section[0]; // 맨 처음 칠한거 저장
        
        for (int s : section) {
            if (start + m <= s) {   // 다음 칠할 자리가 시작지점+붓 크기보다 크면
                start = s;  // 다음 구역을 시작지점으로 다시 정해주고
                answer += 1;    // 붓질 한 번 추가
            }
        }
        
        return answer;
    }
}
