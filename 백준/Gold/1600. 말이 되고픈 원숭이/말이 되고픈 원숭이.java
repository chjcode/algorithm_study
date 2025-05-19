import java.util.*;
import java.io.*;

public class Main {
    
    static int n, m,k;
    static int[][] graph;
    static int[][][] visited;
    static int[] dx = {-2,-1,1,2,2,1,-1,-2, 0,0,1,-1};
    static int[] dy = {-1,-2,-2,-1,1,2,2,1, 1,-1,0,0};
    
    static class Point{
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        k = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new int[k+1][n][m];
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(0,0,0));
        visited[0][0][0] = 1;
        
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            
            if (now.x == (n-1) && now.y == (m-1)) {
                System.out.println(visited[now.cnt][now.x][now.y] - 1);
                return;
            }
            
            for (int i = 0; i < 12; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int cnt = now.cnt;
                
                if (i < 8) cnt++;
                
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1) || cnt > k) continue;
                
                if (visited[cnt][nx][ny] == 0 && graph[nx][ny] != 1) {
                    visited[cnt][nx][ny] = visited[now.cnt][now.x][now.y] + 1;
                    deq.addLast(new Point(nx, ny, cnt));
                }
            }
        }
        
        System.out.println(-1);   
        
    }
    
}
