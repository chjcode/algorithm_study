import java.util.*;
import java.io.*;

public class Main {
    
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int cnt;
        Point (int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
        
        @Override
        public int compareTo(Point p) {
            if (this.cnt != p.cnt) {
                return this.cnt - p.cnt;
            } else if (this.x != p.x) {
                return this.x - p.x;
            } else {
                return this.y - p.y;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int sharkX = -1;
        int sharkY = -1;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    sharkX = i;
                    sharkY = j;
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = num;
                }
            }
        }
        
        int answer = 0;
        int babyShark = 2;
        int eatCount = 0;
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        
        
        while(true) {
            PriorityQueue<Point> pq = new PriorityQueue<>();
            pq.add(new Point(sharkX, sharkY,0));
            boolean[][] visited = new boolean[n][n];
            visited[sharkX][sharkY] = true;
            
            boolean ate = false;
            while (!pq.isEmpty()) {
                Point now = pq.poll();
                
                if (graph[now.x][now.y] > 0 && graph[now.x][now.y] < babyShark) {
                    answer += now.cnt;
                    
                    graph[now.x][now.y] = 0;
                    
                    eatCount++;
                    if (eatCount == babyShark) {
                        babyShark++;
                        eatCount = 0;
                    }
                    
                    sharkX = now.x;
                    sharkY = now.y;
                    ate = true;
                    break;
                }
                
                for (int i = 0; i < 4; i++) {
                    int nx = now.x + dx[i];
                    int ny = now.y + dy[i];
                        
                    if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
                    
                    if (graph[nx][ny] <= babyShark && !visited[nx][ny]) {
                        pq.add(new Point(nx,ny, now.cnt+1));
                        visited[nx][ny] = true;
                    }
                }
            }
            
            if (!ate) break;
        }
        
        System.out.println(answer);
    }
}