import java.util.*;
import java.io.*;

public class Main {
    static int n,m;
    static int[][] graph;
    static int[][][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    static class Point{
        int x;
        int y;
        int used;
        Point(int x, int y, int used) {
            this.x = x;
            this.y = y;
            this.used = used;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }
        visited = new int[n][m][2];
        System.out.println(bfs(0,0,0));

//        for (int k = 0; k < 2; k++) {
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < m; j++) {
//                    System.out.print(visited[i][j][k] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

    }

    private static int bfs(int x, int y, int used) {
        Deque<Point> deq = new ArrayDeque<>();
        deq.addLast(new Point(x, y, used));
        visited[x][y][used] = 1;

        while (!deq.isEmpty()) {
            Point point = deq.pollFirst();

            if (point.x == (n-1) && point.y == (m-1)) {
                return visited[point.x][point.y][point.used];
            }

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;

                if (graph[nx][ny] == 0 && visited[nx][ny][point.used] == 0) {
                    visited[nx][ny][point.used] = visited[point.x][point.y][point.used] + 1;
                    deq.addLast(new Point(nx,ny,point.used));
                } else if (graph[nx][ny] == 1 && visited[nx][ny][point.used] == 0 && point.used == 0) {
                    visited[nx][ny][point.used+1] = visited[point.x][point.y][point.used] + 1;
                    deq.addLast(new Point(nx, ny, point.used + 1));
                }
            }
        }
        return -1;
    }
}
