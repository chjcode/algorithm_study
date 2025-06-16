import java.util.*;
import java.io.*;

public class Main {
    
    static class Point{
        int x;
        int y;
        int k;
        Point(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], k+1);
        }
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(0,0,0));
        visited[0][0] = 0;
        int steps = 1;
        boolean flag = true;
        
        while (!deq.isEmpty()) {
            int size = deq.size();
            
            while (size-- > 0) {
                Point now = deq.pollFirst();
                
                if (now.x == n-1 && now.y == m-1) {
                    System.out.println(steps);
                    flag = false;
                    break;
                }
            
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];

                    if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                    
                    int nk = now.k + graph[nx][ny];
                    
                    if (nk < k+1 && nk < visited[nx][ny]) {
                        visited[nx][ny] = nk;
                        deq.addLast(new Point(nx, ny, nk));
                    }
                    
                }
            }
            if (flag) {
                steps++;
            } else {
                break;
            }
           
        }
        
        if (flag) {
            System.out.println(-1);
        }
        
    }
}
