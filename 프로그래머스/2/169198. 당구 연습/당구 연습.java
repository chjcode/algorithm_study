import java.util.*;

class Solution {
    
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            int ballX = balls[i][0];
            int ballY = balls[i][1];
            
            int min = Integer.MAX_VALUE;
            
            // 1. 왼쪽 벽 반사
            if (!(startY == ballY && startX > ballX)) {
                min = Math.min(min, getDist(startX, startY, -ballX, ballY));
            }
            
            // 2. 오른쪽 벽 반사
            if (!(startY == ballY && startX < ballX)) {
                min = Math.min(min, getDist(startX, startY, 2 * m - ballX, ballY));
            }
            
            // 3. 아래 벽 반사
            if (!(startX == ballX && startY > ballY)) {
                min = Math.min(min, getDist(startX, startY, ballX, -ballY));
            }
            
            // 4. 위 벽 반사
            if (!(startX == ballX && startY < ballY)) {
                min = Math.min(min, getDist(startX, startY, ballX, 2 * n - ballY));
            }
            
            answer[i] = min;
        }
        
        return answer;
    }
    
    private int getDist(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }
}