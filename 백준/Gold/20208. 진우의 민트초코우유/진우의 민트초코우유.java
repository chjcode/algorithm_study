import java.io.*;
import java.util.*;

public class Main {

    static int n, m, h, sx, sy, answer;
    static int[][] arr;
    static boolean[] visited;

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> milks = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1) {
                    sx = i; sy = j;
                } else if (arr[i][j] == 2) {
                    milks.add(new Point(i, j));
                }
            }
        }

        visited = new boolean[milks.size()];
        answer = 0;

        dfs(sx, sy, m, 0);

        System.out.println(answer);
    }

    static void dfs(int x, int y, int health, int cnt) {
        int distHome = Math.abs(x - sx) + Math.abs(y - sy);
        if (health >= distHome) answer = Math.max(answer, cnt);

        for (int i = 0; i < milks.size(); i++) {
            if (visited[i]) continue;

            Point p = milks.get(i);
            int dist = Math.abs(x - p.x) + Math.abs(y - p.y);

            if (health >= dist) {
                visited[i] = true;
                dfs(p.x, p.y, health - dist + h, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
