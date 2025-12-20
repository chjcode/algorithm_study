import java.util.*;
import java.io.*;

public class Main {
    
    static class Point{
        int x,y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[n][m];
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < n; i++ ) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                int num = s.charAt(j) - '0';
                arr[i][j] = num;
                if (num == 2) {
                    startX = i;
                    startY = j;
                }
            }
        }
        
        int[][] visited = new int[n][m];
        
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(startX, startY));
        visited[startX][startY] = 1;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        int cnt = 0;
        while (!deq.isEmpty()) {
            Point now = deq.pollFirst();
            if (arr[now.x][now.y] > 2) {
                cnt = visited[now.x][now.y]-1;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                
                if (visited[nx][ny] == 0 && arr[nx][ny] != 1) {
                    visited[nx][ny] = visited[now.x][now.y] + 1;
                    deq.addLast(new Point(nx,ny));
                }
            }
        }
        
        if (cnt == 0) {
            System.out.println("NIE");
        } else {
            System.out.println("TAK");
            System.out.println(cnt);
        }
    }
}