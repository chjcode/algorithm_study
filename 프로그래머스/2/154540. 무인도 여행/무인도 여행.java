import java.util.*;

class Solution {
    
    boolean[][] visited;
    int n, m;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        visited = new boolean[n][m];
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    list.add(bfs(i, j, maps));
                }
            }
        }
        
        if (list.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    private int bfs(int i, int j, String[] maps) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.add(new Point(i, j));
        visited[i][j] = true;
        
        int cnt = maps[i].charAt(j) - '0';
        
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            
            for (int dir = 0; dir < 4; dir++) {
                int nx = now.x + dx[dir];
                int ny = now.y + dy[dir];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                
                if (maps[nx].charAt(ny) != 'X' && !visited[nx][ny]) {
                    cnt += maps[nx].charAt(ny) - '0';
                    deq.addLast(new Point(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }
        
        return cnt;
    }
}