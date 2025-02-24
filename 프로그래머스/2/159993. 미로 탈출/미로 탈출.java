import java.util.*;

class Solution {
    
    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(String[] maps) {
        //벽 지나갈 수 없음
        // 통로만 지나갈 수 잇음
        // 레버를 먼저 당기고 출구가 있는 칸을 지나간다.
        // 탈출 불가시 -1 return
        
        // start -> lever bfs
        // lever -> end bfs
        
        n = maps.length;
        m = maps[0].length();
        
        Point start = new Point(-1,-1);
        Point end = new Point(-1,-1);
        Point lever = new Point(-1,-1);
        
        char[][] graph = new char[n][m];
        for (int i = 0; i < n; i++) {
            String s = maps[i];
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
        
                if (c == 'S') {
                    start = new Point(i,j);
                } else if (c == 'E') {
                    end = new Point(i,j);
                } else if (c == 'L') {
                    lever = new Point(i,j);
                }
                
                if (c == 'X') {
                    graph[i][j] = 'X';
                } else {
                    graph[i][j] = 'O';
                }
            }
        }
        
        int sToL = bfs(start, lever, graph);
        if (sToL == -1) {
            return -1;
        }
        int lToE = bfs(lever, end, graph);
        if (lToE == -1) {
            return -1;
        }
        
        return sToL + lToE;
    }
    
    private static int bfs(Point start, Point end, char[][] graph) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(start);
        int[][] visited = new int[n][m];
        
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                
                if (nx == end.x && ny == end.y) {
                    return visited[now.x][now.y] + 1;
                }
                
                if (visited[nx][ny] == 0 && graph[nx][ny] == 'O') {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    deq.addLast(new Point(nx,ny));
                }
            } 
        }
        
        return -1;
    }
}