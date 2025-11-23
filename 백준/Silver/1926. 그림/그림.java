import java.util.*;
import java.io.*;

public class Main {
    
    static int n,m;
    static int cnt = 0;
    static int size = 0;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] arr;
    
    static class Point{
        int x;
        int y;
        Point (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        int cnt = 0; // 그림 개수
        int size = 0;
        
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) {
                    size = Math.max(size, bfs(i,j));
                    cnt++;
                }
            }
        }
        
        System.out.println(cnt);
        System.out.println(size);
        
        
    }
    
    private static int bfs(int x, int y) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(x,y));
        int s = 1;
        arr[x][y] = 0;
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                
                if (arr[nx][ny] == 1) {
                    arr[nx][ny] = 0;
                    s++;
                    deq.addLast(new Point(nx, ny));
                }
                
            }
        }
        
        return s;
    }
}