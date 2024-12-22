import java.io.*;
import java.util.*;

public class Main {

    static int n, m;
    static char[][] graph;
    static int[][] visited;
    static Deque<Point> jihun, fire;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

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

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char[n][m];
        jihun = new ArrayDeque<>();
        fire = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char now = s.charAt(j);
                graph[i][j] = now;
                if (now == 'J') {
                    jihun.addLast(new Point(i, j));
                } else if (now == 'F') {
                    fire.addLast(new Point(i, j));
                }
            }
        }

        visited = new int[n][m];
        bfsF();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (visited[i][j] < 0) {
//                    System.out.print(" "+ visited[i][j]);
//                } else{
//
//                    System.out.print("  " + visited[i][j]);
//                }
//            }
//            System.out.println();
//        }
        bfsJ();
//        System.out.println();
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                if (visited[i][j] < 0) {
//                    System.out.print(" "+ visited[i][j]);
//                } else{
//
//                    System.out.print("  " + visited[i][j]);
//                }
//            }
//            System.out.println();
//        }
    }

    private static void bfsF() {
        while (!fire.isEmpty()) {
            Point point = fire.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;

                if (graph[nx][ny] == '.' && visited[nx][ny] == 0) {
                    visited[nx][ny] = visited[point.x][point.y] - 1;
                    fire.addLast(new Point(nx, ny));
                }
            }
        }
    }

    private static void bfsJ() {
        while (!jihun.isEmpty()) {
            Point point = jihun.pollFirst();
            if (point.x == 0 || point.x == n - 1 || point.y == 0 || point.y == m-1) {
                System.out.println(visited[point.x][point.y] + 1);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (m-1)) continue;

                if (graph[nx][ny] == '.' && (visited[point.x][point.y]+1 < -visited[nx][ny] || visited[nx][ny] == 0) ) {
                    visited[nx][ny] = visited[point.x][point.y] + 1;
                    jihun.addLast(new Point(nx, ny));
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
/**
 * 0 0 0 0
 * 0 0 0 0
 * 0 2 1 0
 * 0 3 2 0
 * 0 4 3 0
 *
 * 0 0 0 0
 * 0 0 0 0
 * 0 1 2 0
 * 0 2 3 0
 * 0 3 4 0
 */
