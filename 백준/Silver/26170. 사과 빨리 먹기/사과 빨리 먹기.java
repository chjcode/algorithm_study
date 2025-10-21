import java.util.*;
import java.io.*;

public class Main {
    public static class Point{
        int x;
        int y;
        int cnt;
        Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    
    static int n;
    static int[][] graph;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int result = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = 5;
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int apple = 0;
        if (graph[startX][startY] == 1) {
            apple++;
        }
        graph[startX][startY] = -1;
        dfs(new Point(startX, startY, 0), apple);
        
        if (result == Integer.MAX_VALUE) {
            result = -1;
        }
        System.out.println(result);

    }
    
    private static void dfs(Point point, int apple) {
        if (apple == 3) {
            result = Math.min(result, point.cnt);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = point.x + dx[i];
            int ny = point.y + dy[i];
            if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
            
            if (graph[nx][ny] == 0) {
                int prev = graph[nx][ny];
                graph[nx][ny] = -1;
                dfs(new Point(nx, ny, point.cnt+1), apple);
                graph[nx][ny] = prev;
            } else if (graph[nx][ny] == 1) {
                int prev = graph[nx][ny];
                graph[nx][ny] = -1;
                dfs(new Point(nx, ny, point.cnt+1), apple+1);
                graph[nx][ny] = prev;
            }
        }
    }
}