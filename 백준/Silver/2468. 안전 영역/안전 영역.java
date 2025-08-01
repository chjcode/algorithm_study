import java.util.*;
import java.io.*;

public class Main {
    
    static int n;
    static int[][] graph;
    static boolean[][] visited;
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
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        
        int maxHeight = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(graph[i][j], maxHeight);
            }
        }
        
        int answer = 0;
        for (int i = 0; i < maxHeight; i++) {
            visited = new boolean[n][n];
            
            makeMap(i);
            
            answer = Math.max(answer, cntSafeArea());
        }
        
        System.out.println(answer);
    }
    
    private static void makeMap(int height) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= height) {
                    visited[i][j] = true;
                }
            }
        }
    }
    
    private static int cntSafeArea() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false) {
                    bfs(i,j);
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
    
    private static void bfs(int x, int y) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(x,y));
        visited[x][y] = true;
        
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + now.x;
                int ny = dy[i] + now.y;
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
                
                if (visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    deq.addLast(new Point(nx,ny));
                }
            }
        }
        
    }
}