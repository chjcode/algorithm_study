import java.util.*;
import java.io.*;

public class Main {
    static int n, change;
    static  int[][] graph, dist;
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

        n = Integer.parseInt(br.readLine());

        graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<Point> deq = new ArrayDeque<>();

        dist[0][0] = 0;
        deq.addFirst(new Point(0, 0));

        while (!deq.isEmpty()) {
            Point point = deq.pollFirst();

            if (point.x == n - 1 && point.y == n - 1) {
                return dist[point.x][point.y];
            }

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (nx < 0 || nx > (n-1) || ny < 0 || ny > (n-1)) continue;

                int cost = (graph[nx][ny] == 0 ? 1 : 0);

                if (dist[point.x][point.y] + cost  < dist[nx][ny]) {
                    dist[nx][ny] = dist[point.x][point.y] + cost ;

                    if (graph[nx][ny] == 0) {
                        deq.addLast(new Point(nx, ny));
                    } else {
                        deq.addFirst(new Point(nx, ny));
                    }
                }

            }
        }

        return -1;
    }

}
