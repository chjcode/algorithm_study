class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int n = board.length;
        String color = board[h][w];
        for (int i = 0; i < 4; i++) {
            int nx = h + dx[i];
            int ny = w + dy[i];
            
            if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
            
            if (color.equals(board[nx][ny])) answer++;
        }
        
        return answer;
    }
}