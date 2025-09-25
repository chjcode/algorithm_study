import java.util.*;
import java.io.*;

public class Main {
    
    static int m,n,k;
    static boolean[][] arr;
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
        
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 0; tc < t; tc++) {
            st = new StringTokenizer(br.readLine());
        
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
        
            arr = new boolean[n][m];
            for (int a = 0; a < k; a++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
            
                arr[x][y] = true;
            }
        
            int answer = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[i][j]) {
                        answer++;
                        bfs(i,j);
                    }
                }
            }
        
            System.out.println(answer);
        }
        
    }
    
    private static void bfs(int startX, int startY) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(startX, startY));
        arr[startX][startY] = false;
        
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                
                if (arr[nx][ny]) {
                    arr[nx][ny] = false;
                    deq.add(new Point(nx,ny));
                }
            }
        }
    }
    
}