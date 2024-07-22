
import java.util.*;
import java.io.*;

public class Main {

    static class Point{
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int t,n;
    static int[][] graph;
    static int[] dx = {-2,-2,-1,1,2,2,1,-1};
    static int[] dy = {-1,1,2,2,1,-1,-2,-2};

    static Point start,end;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            start = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            st = new StringTokenizer(br.readLine());
            end = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            graph = new int[n][n];

            bfs();
//            for (int i = 0; i < n; i++) {
//                for (int j = 0; j < n; j++) {
//                    System.out.print(graph[i][j] + " ");
//                }
//                System.out.println();
//            }
            System.out.println(graph[end.x][end.y]-1);
        }
    }

    public static void bfs() {
        Queue<Point> que = new LinkedList<>();
        que.add(start);
        graph[start.x][start.y] = 1;
        while (!que.isEmpty()) {
            Point point = que.poll();
            if (point.x == end.x && point.y == end.y) {
                return;
            }
            for (int i = 0; i < 8; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (nx < 0 || nx > (n - 1) || ny < 0 || ny > (n - 1)) {
                    continue;
                }
                if (graph[nx][ny] == 0) {
                    graph[nx][ny] = graph[point.x][point.y] + 1;
                    que.add(new Point(nx, ny));
                }
            }
        }
    }
}
