import java.util.*;
import java.io.*;

public class Main {
    
    static class Point{
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    static int[][] graph;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        
        visited = new int[n][m];
        
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(0,0));
        visited[0][0] = 1;
        
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                
                if (visited[nx][ny] == 0 && graph[nx][ny] == 1) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    deq.addLast(new Point(nx,ny));
                }
            }
        }
        
        System.out.println(visited[n-1][m-1]);
    }
}
