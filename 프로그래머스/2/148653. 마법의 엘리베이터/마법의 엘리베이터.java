class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int num = storey % 10;  // 현재 보고 있는 자릿수
            int nextNum = (storey / 10 ) % 10;  // 현재 자릿수를 제거한 다음 자릿수
            
            // 5보다 크면 무조건 올림
            if (num > 5) {
                answer += 10 - num; //올린 만큼 +
                storey += 10;
            } else if (num == 5 && nextNum >= 5) {
                // num == 5이면 다음 자릿수를 고려해야하므로
                answer += 5;
                storey += 10;
            } else {
                answer += num;
            }
            
            storey /= 10;
        }
        
        return answer;
    }
}
