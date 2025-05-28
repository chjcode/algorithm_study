import java.io.*;
import java.util.*;

public class Main {
    
    static int n = 5;
    static int answer = 0;
    static char[][] graph = new char[n][n];
    static int[] students = new int[7];
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j);
            }
        }
        
        combination(0, 0, 0);

        System.out.println(answer);
    }
    
    static void combination(int start, int depth, int sCnt) {
        if (depth == 7) {
            if (sCnt >= 4 && isConnected()) {
                answer++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            students[depth] = i;
            int x = i/5;
            int y = i%5;
            
            if (graph[x][y] == 'S') {
                combination(i+1, depth+1, sCnt+1);
            } else {
                combination(i+1, depth+1, sCnt);
            }
        }
    }
    
    static boolean isConnected() {
        Deque<Integer> deq = new ArrayDeque<>();
        boolean[][] student = new boolean[n][n];
        boolean[][] visited = new boolean[n][n];
        
        for (int i = 0; i < 7; i++) {
            int x = students[i] / 5;
            int y = students[i] % 5;
            student[x][y] = true;
        }
        

        deq.addLast(students[0]);
        visited[students[0] / 5][students[0] % 5] = true;
        int cnt = 1;
        
        while(!deq.isEmpty()) {
            int now = deq.pollFirst();
            int x = now / 5;
            int y = now % 5;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;
                
                if (student[nx][ny] && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    deq.add(nx * 5 + ny);
                    cnt++;
                }
            }
        }
        
        return cnt == 7;
    }
}