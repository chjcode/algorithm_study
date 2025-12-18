import java.util.*;
import java.io.*;

public class Main {
    
    static int n,m;
    static int[][] after, before;
    static boolean[][] visited;
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Point {
        int x, y;
        Point(int x, int y) { 
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
        
        before = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                before[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        after = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                after[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        visited = new boolean[n][m];
        int diffX = -1;
        int diffY = -1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    diffX = i;
                    diffY = j;
                    flag = true;
                    break;
                }
            }
            
            if (flag) break;
        }
        
        if (diffX == -1 && diffY == -1) {
            System.out.println("YES");
            return;
        }
        
        bfs(diffX, diffY);
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (before[i][j] != after[i][j]) {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println("YES");
        
        
        
    }
    
    private static void bfs(int x, int y) {
        int target = before[x][y];
        int change = after[x][y];
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(x,y));
        visited[x][y] = true;
        
        while(!deq.isEmpty()) {
            Point now = deq.pollFirst();
            before[now.x][now.y] = change;
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                
                if (!visited[nx][ny] && before[nx][ny] == target) {
                    visited[nx][ny] = true;
                    deq.addLast(new Point(nx,ny));
                }
            }
        }
    }
}