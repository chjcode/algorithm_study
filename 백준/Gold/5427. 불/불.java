import java.util.*;
import java.io.*;

public class Main{
    
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
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            
            char[][] graph = new char[n][m];
            int[][] fVisited = new int[n][m];
            int[][] sVisited = new int[n][m];
            
            for (int i = 0; i < n; i++) {
                Arrays.fill(fVisited[i], Integer.MAX_VALUE);
                Arrays.fill(sVisited[i], Integer.MAX_VALUE);
            }
            
            Deque<Point> fDeq = new ArrayDeque<>();
            Deque<Point> sDeq = new ArrayDeque<>();
            
            boolean flag1 = false;
            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                for (int j = 0; j < m; j++) {
                    char c = s.charAt(j);
                    graph[i][j] = c;
                    if (c == '*') {
                        fDeq.addLast(new Point(i,j));
                        fVisited[i][j] = 0;
                    }
                    if (c == '@') {
                        sDeq.addLast(new Point(i,j));  
                        sVisited[i][j] = 0;
                        
                        if (i == 0 || i == n-1 || j == 0 || j == m-1) {
                            System.out.println(1);
                            flag1 = true;
                            break;
                        }
                    } 
                }
            }
            
            if (flag1) continue;
            
            //불 bfs 작업
            while(!fDeq.isEmpty()) {
                Point point = fDeq.pollFirst();
                
                for (int i = 0; i < 4; i++) {
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];
                    
                    if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;
                    
                    if ((graph[nx][ny] == '.' || graph[nx][ny] =='@') && fVisited[nx][ny] == Integer.MAX_VALUE) {
                        fVisited[nx][ny] = fVisited[point.x][point.y] + 1;
                        fDeq.addLast(new Point(nx,ny));
                    }
                }
            }
            

            
            boolean flag2 = false;
            // 상근이 bfs 작업
            while(!sDeq.isEmpty()) {
                Point point = sDeq.pollFirst();
                
                for (int i = 0; i < 4; i++) {
                    int nx = point.x + dx[i];
                    int ny = point.y + dy[i];
                    
                    if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) {
                        flag2 = true;
                        System.out.println(sVisited[point.x][point.y] + 1);
                        break;
                    }
                    
                    
                    if ((graph[nx][ny] == '.' || graph[nx][ny] == '@') 
                        && fVisited[nx][ny] > sVisited[point.x][point.y] + 1
                        && sVisited[nx][ny] == Integer.MAX_VALUE
                       ) {
                        
                        sDeq.addLast(new Point(nx,ny));
                        sVisited[nx][ny] = sVisited[point.x][point.y] + 1;
                    }
                }
                
                if (flag2) break;
            }

            if (!flag2) {
                System.out.println("IMPOSSIBLE");
            }
            
        }
    }
}