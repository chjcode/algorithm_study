import java.util.*;

class Solution {
    class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};

    char[][] arr;
    int n, m;
    Point start, end;
    int answer = Integer.MAX_VALUE;
    int[][] visited;

    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();

        arr = new char[n][m];
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char c = board[i].charAt(j);
                arr[i][j] = c;

                if (c == 'R') start = new Point(i, j);
                else if (c == 'G') end = new Point(i, j);
            }
        }

        dfs(start, 0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(Point now, int depth) {
        if (depth >= answer) return;
        if (depth >= visited[now.x][now.y]) return;

        visited[now.x][now.y] = depth;

        if (now.x == end.x && now.y == end.y) {
            answer = depth;
            return;
        }

        for (int i = 0; i < 4; i++) {
            Point next = move(now, i);

            if (next.x == now.x && next.y == now.y) continue;

            dfs(next, depth + 1);
        }
    }

    private Point move(Point now, int dir) {
        int x = now.x;
        int y = now.y;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m || arr[nx][ny] == 'D') {
                return new Point(x, y);
            }

            x = nx;
            y = ny;
        }
    }
}