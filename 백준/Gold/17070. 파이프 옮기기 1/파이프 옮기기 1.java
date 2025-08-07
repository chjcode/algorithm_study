import java.util.*;
import java.io.*;

public class Main {
    
    static int n, cnt;
    static int[][] graph;
    
    static enum Status {
        HORIZONTAL, VERTICAL, DIAGONAL;
    }
    
    static class Pipe {
        int x;
        int y;
        Status status;
        Pipe(int x, int y, Status status) {
            this.x = x;
            this.y = y;
            this.status = status;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        Pipe pipe = new Pipe(0,1,Status.HORIZONTAL);
        dfs(pipe);
        System.out.println(cnt);
    }
    
    //방향이 제한적이라 이전의 상태를 고려할 필요는 없을듯?
    private static void dfs(Pipe now) {
        int x = now.x;
        int y = now.y;
        Status status = now.status;

        if (x == n - 1 && y == n - 1) {
            cnt++;
            return;
        }

        // 가로
        if (status == Status.HORIZONTAL || status == Status.DIAGONAL) {
            int nx = x;
            int ny = y + 1;
            if (isIn(nx, ny) && graph[nx][ny] == 0) {
                dfs(new Pipe(nx, ny, Status.HORIZONTAL));
            }
        }

        // 세로
        if (status == Status.VERTICAL || status == Status.DIAGONAL) {
            int nx = x + 1;
            int ny = y;
            if (isIn(nx, ny) && graph[nx][ny] == 0) {
                dfs(new Pipe(nx, ny, Status.VERTICAL));
            }
        }
        
        // 대각선
        int nx = x + 1;
        int ny = y + 1;
        if (isIn(nx, ny) && graph[nx][ny] == 0 &&
            graph[x + 1][y] == 0 && graph[x][y + 1] == 0) {
            dfs(new Pipe(nx, ny, Status.DIAGONAL));
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}