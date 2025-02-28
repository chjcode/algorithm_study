import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
        
        // n : 배열 크기
        // 1행 1열부터 i행 i열까지 모든 빈 칸을 숫자 i로 채운다?
        // 1~n행을 잘라내어 모두 이어붙인 새로운 1차원 배열 만듦
        
        int[] answer = new int[(int)(right - left) + 1];
        for (long i = left ; i < right+1; i++) {
            int x = (int) (i/n);
            int y = (int) (i%n);
            
            answer[(int) (i-left)] = Math.max(x,y) + 1;
        }

        
        // 시작하는 i와 j값을 어떻게 구하지?
        // left = i * n + j = 2

        
        return answer;
    }
    
    
}
// 00 01 02
// 10 11 12
// 20 21 22

// 1 2 3
