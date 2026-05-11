import java.util.*;

class Solution {
    
    int n, m;
    int[][] arr;
    boolean[][] visited;
    List<Integer> answer;
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
        answer = new ArrayList<>();
        
        n = maps.length;
        m = maps[0].length();
        
        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = maps[i].charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != 'X' && !visited[i][j]) {
                    bfs(i, j);
                }
            }
        }
        
        if (answer.size() > 0) {
            Collections.sort(answer);
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
        
        return new int[]{-1};
    }
    
    private void bfs(int x, int y) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.add(new Point(x, y));

        int sum = arr[x][y] - '0';
        visited[x][y] = true;
        
        while (!deq.isEmpty()) {
            Point now = deq.pollLast();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (nx < 0 || nx > n - 1 || ny < 0 || ny > m - 1) continue;
                
                if (arr[nx][ny] != 'X' && !visited[nx][ny]) {
                    sum += arr[nx][ny] - '0';
                    visited[nx][ny] = true;
                    deq.add(new Point(nx, ny));
                }
            }
        }
        
        answer.add(sum);
    }
}