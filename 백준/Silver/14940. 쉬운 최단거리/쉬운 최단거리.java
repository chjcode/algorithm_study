import java.util.*;
import java.io.*;

public class Main {

    static int n,m;
    static int[][] graph, visited;
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

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) {
                    visited[i][j] = 0;
                } else {
                    visited[i][j] = -1;
                }
            }
        }

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 2) {
                    bfs(i,j);
                    flag = true;
                    break;
                }
            }
            if (flag) break;
        }


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void bfs(int x,int y) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(x,y));
        visited[x][y] = 0;
        while (!deq.isEmpty()) {
            Point point = deq.pollFirst();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;

                if (graph[nx][ny] != 0 && visited[nx][ny] == -1) {
                    visited[nx][ny] = visited[point.x][point.y] + 1;
                    deq.addLast(new Point(nx,ny));
                }
            }
        }
    }

}
