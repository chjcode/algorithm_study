import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class point {
        int x;
        int y;

        point(int x, int y) {
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

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        int last = 0;

        while (true) {
            int cnt = count();
            if (cnt == 0) break;

            last = cnt;
            bfs();
            melt();
            time++;
        }

        System.out.println(time);
        System.out.println(last);
    }

    static int count() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 1) cnt++;
            }
        }
        return cnt;
    }

    static void bfs() {
        visited = new boolean[n][m];

        Deque<point> deq = new ArrayDeque<>();
        deq.addLast(new point(0, 0));
        visited[0][0] = true;

        while (!deq.isEmpty()) {
            point cur = deq.pollFirst();
            int x = cur.x;
            int y = cur.y;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;

                if (arr[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    deq.addLast(new point(nx, ny));
                } else if (arr[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    arr[nx][ny] = 2;
                }
            }
        }
    }

    static void melt() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) arr[i][j] = 0;
            }
        }
    }
}
