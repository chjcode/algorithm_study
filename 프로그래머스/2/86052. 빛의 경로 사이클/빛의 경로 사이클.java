import java.util.*;

class Solution {
    
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[] grid) {
        
        int n = grid.length;
        int m = grid[0].length();
        
        List<Integer> answer = new ArrayList<>();
        boolean[][][] visited = new boolean[n][m][4];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if (!visited[i][j][k]) {
                        int cnt = 0;
                        
                        int x = i;
                        int y = j;
                        int dir = k;
                        
                        while (!visited[x][y][dir]) {
                            visited[x][y][dir] = true;
                            cnt++;
                            
                            char c = grid[x].charAt(y);
                            
                            if (c == 'L') {
                                dir = (dir + 3) % 4;
                            } else if (c == 'R') {
                                dir = (dir + 1) % 4;
                            }
                            
                            x = (x + dx[dir] + n) % n;
                            y = (y + dy[dir] + m) % m;
                        }
                        
                        answer.add(cnt);
                    }
                }
            }
        }
        
        Collections.sort(answer);
        
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        
        return result;
    }
}