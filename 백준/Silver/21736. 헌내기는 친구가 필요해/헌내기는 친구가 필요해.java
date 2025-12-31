import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new char[n][m];
        visited = new boolean[n][m];

        int sx = 0, sy = 0;

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = line.charAt(j);
                if (arr[i][j] == 'I') {
                    sx = i;
                    sy = j;
                }
            }
        }

        int result = bfs(sx, sy);

        if (result == 0) {
            System.out.println("TT");
        } else {
            System.out.println(result);
        }
    }

    static int bfs(int x, int y) {
        Deque<int[]> deq = new ArrayDeque<>();
        deq.add(new int[]{x, y});
        visited[x][y] = true;

        int count = 0;

        while (!deq.isEmpty()) {
            int[] cur = deq.poll();
            int cx = cur[0];
            int cy = cur[1];

            if (arr[cx][cy] == 'P') count++;

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (arr[nx][ny] == 'X') continue;

                visited[nx][ny] = true;
                deq.add(new int[]{nx, ny});
            }
        }

        return count;
    }
}
